// Fetch and display all users
function loadUsers() {
    fetch('http://localhost:8080/users')
        .then(response => response.json())
        .then(users => {
            const userList = document.getElementById('user-list');
            userList.innerHTML = ''; // Clear existing list

            users.forEach(user => {
                const userElement = document.createElement('div');
                userElement.classList.add('user');
                userElement.innerHTML = `
                    <p><strong>${user.userName}</strong> - Status: ${user.accountStatus}</p>
                    <button onclick="suspendUser(${user.userId})">Suspend</button>
                    <button onclick="banUser(${user.userId})">Ban</button>
                    <button onclick="deleteUser(${user.userId})">Delete</button>
                `;
                userList.appendChild(userElement);
            });
        })
        .catch(error => console.error('Error fetching users:', error));
}

// Suspend a user
function suspendUser(userId) {
    fetch(`http://localhost:8080/users/${userId}/status?status=suspended`, { method: 'PUT' })
        .then(() => {
            alert('User suspended!');
            loadUsers(); // Reload user list
        })
        .catch(error => console.error('Error suspending user:', error));
}

// Ban a user
function banUser(userId) {
    fetch(`http://localhost:8080/users/${userId}/status?status=banned`, { method: 'PUT' })
        .then(() => {
            alert('User banned!');
            loadUsers(); // Reload user list
        })
        .catch(error => console.error('Error banning user:', error));
}

// Delete a user
function deleteUser(userId) {
    fetch(`http://localhost:8080/users/${userId}`, { method: 'DELETE' })
        .then(() => {
            alert('User deleted!');
            loadUsers(); // Reload user list
        })
        .catch(error => console.error('Error deleting user:', error));
}

// Load users on page load
document.addEventListener('DOMContentLoaded', loadUsers);
