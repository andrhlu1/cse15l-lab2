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
        const currentHash = window.location.hash.substring(1); // Remove the '#' at the start
        const urlParams = new URLSearchParams(currentHash.split("?")[1]);
        const message = urlParams.get('s');

        if (currentHash.startsWith("add-message") && message) {
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
