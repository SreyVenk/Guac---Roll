document.addEventListener("DOMContentLoaded", () => {
    const API_BASE_URL = "http://localhost:8089"; // Replace with your backend URL

    // Helper function to get the ingredient ID from the URL
    function getIngredientIdFromUrl() {
        const urlParams = new URLSearchParams(window.location.search); // Parse the query string
        return urlParams.get("ingredientId"); // Extract the value of "ingredientId"
    }

    const ingredientId = getIngredientIdFromUrl();

    console.log(ingredientId)

    // Fetch ingredient details
    function fetchIngredientDetails() {
        fetch(`${API_BASE_URL}/ingredients/${ingredientId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Ingredient not found");
                }
                return response.json();
            })
            .then(ingredient => {
                document.querySelector("#ingredient-name").textContent = ingredient.itemName;
                document.querySelector("#current-stock").textContent = `Current Stock: ${ingredient.numberInStock}`;
            })
            .catch(error => {
                document.querySelector("#message").textContent = "Error: " + error.message;
            });
    }

    // Restock the ingredient
    function restockIngredient() {
        const restockAmount = document.querySelector("#restock-amount").value;

        if (restockAmount && !isNaN(restockAmount)) {
            fetch(`${API_BASE_URL}/ingredients/${ingredientId}/restock`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ newStock: parseInt(restockAmount) })
            })
                .then(response => {
                    if (response.ok) {
                        alert("Ingredient restocked successfully!");
                        fetchIngredientDetails(); // Refresh ingredient details
                        window.location.href = "distributor.html";
                    } else {
                        throw new Error("Failed to restock ingredient. Please try again.");
                    }
                })
                .catch(error => {
                    document.querySelector("#message").textContent = "Error: " + error.message;
                });
        } else {
            alert("Please enter a valid number.");
        }
    }

    // Attach event listener to the restock button
    document.querySelector("#restock-button").addEventListener("click", restockIngredient);

    // Initialize the page by fetching ingredient details
    fetchIngredientDetails();
});
