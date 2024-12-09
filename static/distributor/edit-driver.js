document.addEventListener("DOMContentLoaded", () => {
    const API_BASE_URL = "http://localhost:8089"; // Replace with your backend URL

    // Helper function to get the driver ID from the URL
    function getDriverIdFromUrl() {
        const urlParams = new URLSearchParams(window.location.search); // Parse the query string
        return urlParams.get("driverId"); // Extract the value of "driverId"
    }

    const driverId = getDriverIdFromUrl();

    if (!driverId) {
        document.querySelector("#message").textContent = "Error: Driver ID not found in URL.";
        return;
    }

    console.log(`Driver ID: ${driverId}`);

    // Fetch driver details
    function fetchDriverDetails() {
        fetch(`${API_BASE_URL}/drivers/${driverId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Driver not found");
                }
                return response.json();
            })
            .then(driver => {
                // Populate the form fields with fetched data
                document.querySelector("#driver-name").value = driver.name;
                document.querySelector("#driver-age").value = driver.age;
                document.querySelector("#driver-car").value = driver.car;
            })
            .catch(error => {
                document.querySelector("#message").textContent = "Error: " + error.message;
            });
    }

    // Update driver details
    function updateDriverDetails() {
        const name = document.querySelector("#driver-name").value.trim();
        const age = document.querySelector("#driver-age").value;
        const carModel = document.querySelector("#driver-car").value.trim();

        if (!name || !age || !carModel) {
            alert("Please fill in all fields.");
            return;
        }

        fetch(`${API_BASE_URL}/drivers/${driverId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                age: parseInt(age),
                car: carModel
            })
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = "distributor.html"; // Redirect after successful update
                } else {
                    throw new Error("Failed to update driver details. Please try again.");
                }
            })
            .catch(error => {
                document.querySelector("#message").textContent = "Error: " + error.message;
            });
    }

    // Attach event listener to the save changes button
    document.querySelector("#edit-driver-button").addEventListener("click", updateDriverDetails);

    // Initialize the page by fetching driver details
    fetchDriverDetails();
});
