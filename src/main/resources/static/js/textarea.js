var textarea = document.getElementById("messageInput");

textarea.addEventListener("keydown", function(event) {
    if (event.key === "Enter" && !event.shiftKey) {
        event.preventDefault();

        var message = textarea.value.trim();
        textarea.value = "";

        // 发送 POST 请求
        fetch('/chat/chat', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ content: message })
        }).then(function(response) {
            // 刷新页面
            location.reload();
        });
    }
});

textarea.addEventListener("keydown", function(event) {
    if (event.key === "Enter" && event.shiftKey) {
        // 在 Shift+Enter 情况下允许换行
        textarea.value += "\n";
        event.preventDefault();
    }
});