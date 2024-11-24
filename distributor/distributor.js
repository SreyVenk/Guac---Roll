document.addEventListener("DOMContentLoaded", () => {
    const API_BASE_URL = "http://localhost:8080"; // Replace with your backend URL

    // Fetch and render Orders
    function fetchOrders() {
        fetch(`${API_BASE_URL}/orders/all`)
            .then(response => response.json())
            .then(orders => {
                const ordersTable = document.querySelector("#orders tbody");
                ordersTable.innerHTML = ""; // Clear existing rows
                orders.forEach(order => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${order.orderId}</td>
                        <td>${order.user.userName}</td>
                        <td>${order.details}</td>
                        <td>${order.status}</td>
                    `;
                    ordersTable.appendChild(row);
                });
            })
            .catch(error => console.error("Error fetching orders:", error));
    }

    // Fetch and render Drivers
    function fetchDrivers() {
        fetch(`${API_BASE_URL}/drivers`)
            .then(response => response.json())
            .then(drivers => {
                const driversTable = document.querySelector("#drivers tbody");
                driversTable.innerHTML = ""; // Clear existing rows

                drivers.forEach(driver => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                    <td>${driver.driverId}</td>
                    <td>${driver.name}</td>
                    <td>${driver.car}</td>
                    <td>${driver.age}</td>
                    <td>
                        <button class="edit-button">Edit</button>
                        <button class="remove-button" data-driver-id="${driver.driverId}">Remove</button>
                    </td>
                `;
                    driversTable.appendChild(row);

                    // Add event listener for the Remove button
                    const removeButton = row.querySelector(".remove-button");
                    removeButton.addEventListener("click", () => {
                        removeDriver(driver.driverId, row);
                    });
                });
            })
            .catch(error => console.error("Error fetching drivers:", error));
    }

    function removeDriver(driverId, row) {
        if (confirm("Are you sure you want to remove this driver?")) {
            fetch(`${API_BASE_URL}/drivers/${driverId}/delete`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (response.ok) {
                        row.remove(); // Remove the row from the table
                        alert("Driver removed successfully.");
                    } else {
                        throw new Error("Failed to remove driver. Please try again.");
                    }
                })
                .catch(error => {
                    console.error("Error removing driver:", error);
                    alert("Error: " + error.message);
                });
        }
    }


    // Fetch and render Ingredients Stock
    function fetchInventory() {
        fetch(`${API_BASE_URL}/ingredients`)
            .then(response => response.json())
            .then(ingredients => {
                const inventoryTable = document.querySelector("#inventory tbody");
                inventoryTable.innerHTML = ""; // Clear existing rows
                ingredients.forEach(item => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                    <td>${item.itemName}</td>
                    <td>${item.numberInStock}</td>
                    <td><button id="restock-button-${item.ingredientId}">Restock</button></td>
                `;

                    // Append the row to the table
                    inventoryTable.appendChild(row);

                    document
                        .querySelector(`#restock-button-${item.ingredientId}`)
                        .addEventListener("click", () => {
                            window.location.href = `distributor-restock.html?ingredientId=${item.ingredientId}`;
                        });
                });
            })
            .catch(error => console.error("Error fetching inventory:", error));
    }


    // Fetch and render Deliveries
    function fetchDeliveries() {
        fetch(`${API_BASE_URL}/orders/all`)
            .then(response => response.json())
            .then(deliveries => {
                const deliveriesTable = document.querySelector("#deliveries tbody");
                deliveriesTable.innerHTML = ""; // Clear existing rows
                deliveries.forEach(order => {
                    if (order.delivery) { // Assuming `isDelivered` is a boolean
                        const row = document.createElement("tr");
                        row.innerHTML = `
                            <td>${order.orderId}</td>
                            <td>${order.driver.name}</td>
                            <td>${order.details}</td>
                            <td>${order.status}</td>
                        `;
                        deliveriesTable.appendChild(row);
                    }
                });
            })
            .catch(error => console.error("Error fetching deliveries:", error));
    }

    // Call fetch functions to populate data
    fetchOrders();
    fetchDrivers();
    fetchInventory();
    fetchDeliveries();
});
