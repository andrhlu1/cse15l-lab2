---
layout: default
---

# StringServer Simulation

<div id="output"></div>

<script>
    // Load previous messages from localStorage
    let messages = JSON.parse(localStorage.getItem("messages") || "[]");

    function displayMessages() {
        const displayText = messages.map((message, index) => `${index + 1}. ${message}`).join("<br>");
        document.getElementById('output').innerHTML = displayText;
    }

    function handleRequest() {
        const currentPath = window.location.pathname;
        const urlParams = new URLSearchParams(window.location.search);
        const message = urlParams.get('s');

        if (currentPath.endsWith("/add-message") && message) {
            messages.push(message);
            // Save updated messages to localStorage
            localStorage.setItem("messages", JSON.stringify(messages));
            displayMessages();
        } else {
            displayMessages();
        }
    }

    handleRequest();
</script>
