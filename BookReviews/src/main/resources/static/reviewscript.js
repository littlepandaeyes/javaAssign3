//Assignment 3: Book Reviews App
//Sarah-Anne Green + Rongjun Zhang
//Purpose: Create a book review database and web application to manage the 
// books and reviews. Utilze ansynchronous requests, and implement security 
// to restrict access requiring user authentication.
//April 14, 2026

//method to fetch book and review details asynchronously
async function getBook(id) {
	const response = await fetch('/books/' + id + '/details');
	if (!response.ok) {
		document.getElementById('bookdetails').innerHTML = '<p>Could not load book details.</p>';
		document.getElementById('reviewdetails').innerHTML = '';
		return;
	}

	const data = await response.json();
	showBook(data.book);
	showReview(data.reviews || []);
}

//function to get the book review via the requested book
async function getReview(id) {
	return getBook(id);
}

//function to show the book details on the same page
function showBook(book) {
	let html = '<h3>' + (book.title || '') + '</h3>';
	if (book.author) {
		html += '<p>Author: ' + book.author + '</p>';
	}
	document.getElementById('bookdetails').innerHTML = html;
}

//function to show the review details on the same page, and a message if there is none
function showReview(reviews) {
	if (!reviews.length) {
		document.getElementById('reviewdetails').innerHTML = '<p>No reviews yet.</p>';
		return;
	}

	let html = '<ul>';
	reviews.forEach(review => {
		html += '<li>' + review.review + '</li>';
	});
	html += '</ul>';
	document.getElementById('reviewdetails').innerHTML = html;
}
//end of reviewscript.js
