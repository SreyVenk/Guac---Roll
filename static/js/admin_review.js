// Fetch and display all reviews
function loadReviews() {
    fetch('http://localhost:8089/reviews')
        .then(response => response.json())
        .then(reviews => {
            const reviewsContainer = document.getElementById('reviews');
            reviewsContainer.innerHTML = '';

            reviews.forEach(review => {
                const reviewElement = document.createElement('div');
                reviewElement.classList.add('review');
                reviewElement.innerHTML = `
                    <p><strong>Review ID ${review.reviewId}:</strong> ${review.details} (${review.rating}/5)</p>
                    <p>Reviewer ID: ${review.reviewerId}</p>
                    <p>Status: ${review.status}</p>
                    <button onclick="editReview(${review.reviewId})">Edit</button>
                    <button onclick="deleteReview(${review.reviewId})">Delete</button>
                `;
                reviewsContainer.appendChild(reviewElement);
            });
        })
        .catch(error => console.error('Error fetching reviews:', error));
}

// Delete a review by fetching and reloading
function deleteReview(reviewId) {
    fetch(`http://localhost:8089/reviews/${reviewId}`, { method: 'DELETE' })
        .then(() => {
            alert('Review deleted!');
            loadReviews();
        })
        .catch(error => console.error('Error deleting review:', error));
}

// Edit a review by fetching and reloading
function editReview(reviewId) {
    const newDetails = prompt('Enter new review content:');
    if (newDetails) {
        fetch(`http://localhost:8089/reviews/${reviewId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ details: newDetails })
        })
            .then(() => {
                alert('Review updated!');
                loadReviews();
            })
            .catch(error => console.error('Error editing review:', error));
    }
}

// Load reviews on page load
document.addEventListener('DOMContentLoaded', loadReviews);
