fetch("/api/article")
    .then(response => response.json())
    .then(article => {
        document.getElementById("quote").textContent = article.quote;
        document.getElementById("paragraph1").textContent = article.paragraph;
    })
    .catch(error => console.error("Could not load article:", error));