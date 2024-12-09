document.addEventListener("DOMContentLoaded", () => {
    const API_BASE_URL = "http://localhost:8089"; // Replace with your backend URL

    // Create the new driver
    function createDriver() {
        const name = document.querySelector("#driver-name").value;
        const age = document.querySelector("#driver-age").value;
        const car = document.querySelector("#driver-car").value;

        // Validate form fields
        if (name && age && car) {
            const driverData = {
                name: name,
                age: parseInt(age), // Convert age to integer
                car: car
            };

            fetch(`${API_BASE_URL}/drivers`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(driverData)
            })
                .then(response => {
                    if (response.ok) {
                        alert("Driver created successfully!");
                        window.location.href = "distributor.html"; // Redirect to drivers list page
                    } else {
                        throw new Error("Failed to create driver. Please try again.");
                    }
                })
                .catch(error => {
                    document.querySelector("#message").textContent = "Error: " + error.message;
                });
        } else {
            alert("Please fill out all fields.");
        }
    }

    // Attach event listener to the create driver button
    document.querySelector("#create-driver-button").addEventListener("click", createDriver);
});
