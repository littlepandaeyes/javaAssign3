function getBook(id) {
    // Fetches book details and its reviews from the REST API 
    fetch("/api/books/" + id)
        .then(response => response.json())
        .then(function(data) { 
            showBook(data); 
        })
        .catch(error => console.error('Error:', error));
}

function showBook(data) {
    // 'data' contains both 'book' object and 'reviews' list from the Controller
    var book = data.book;
    var reviews = data.reviews;

    // Displaying book details as per requirement 
    var content = "<br/>Title: " + book.title + 
                  "<br/>Authors: " + book.author + 
                  "<ul>";

    // Loop through reviews and add to the list [cite: 9, 14]
    reviews.forEach(function(r) {
        content += "<li>" + r.review + "</li>";
    });

    content += "</ul>";
    
    // Inject the generated HTML into the bottom div 
    document.getElementById("bookdetails").innerHTML = content;
}