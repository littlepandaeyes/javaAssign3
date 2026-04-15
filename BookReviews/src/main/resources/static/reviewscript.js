async function getReview(id) {
	const response = await fetch('/books/' + id + '/details');
	if (!response.ok) {
		document.getElementById('bookdetails').innerHTML = '<p>Could not load book details.</p>';
		document.getElementById('reviewdetails').innerHTML = '';
		return;
	}

	const data = await response.json();
	showBook(data.book);
	showReview(data.reviews || []);

	const hiddenBookId = document.getElementById('selectedBookId');
	if (hiddenBookId) {
		hiddenBookId.value = id;
	}
}

function showBook(book) {
	let html = '<h3>' + (book.title || '') + '</h3>';
	if (book.author) {
		html += '<p>Author: ' + book.author + '</p>';
	}
	document.getElementById('bookdetails').innerHTML = html;
}

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

