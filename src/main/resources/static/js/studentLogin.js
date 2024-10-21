document.getElementById('studentLoginForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the default form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('error-message');

    const params = new URLSearchParams();
    params.append('username', username);
    params.append('password', password);

    fetch('http://localhost:8080/students/loginStudent', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: params.toString(),
    })
    .then(response => response.text())
    .then(data => {
        if (data === 'Login successful') {
            // Clear the error message
            errorMessage.textContent = '';
            // Redirect to the dashboard page
			let url = 'http://localhost:8080/students/by-username/' + username;
            window.location.href = url;
        } else {
            // Show error message in red
            errorMessage.textContent = 'Invalid user credentials';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        errorMessage.textContent = 'Something went wrong. Please try again.';
    });
});
