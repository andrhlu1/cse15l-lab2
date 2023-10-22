---
layout: default
---

# StringServer Simulation

<div id="output"></div>

<script>
    let messageCount = 0;
    let messages = "";

    function handleRequest() {
        const urlParams = new URLSearchParams(window.location.search);
        const message = urlParams.get('s');

        if (message) {
            messageCount++;
            if (messages.length > 0) {
                messages += "<br>";
            }
            messages += messageCount + ". " + message;
            document.getElementById('output').innerHTML = messages;
        }
    }

    handleRequest();
</script>
