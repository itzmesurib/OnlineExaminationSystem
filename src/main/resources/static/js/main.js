document.getElementById('studentRegisterForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const studentData = {
        name: document.getElementById('name').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
    };
	
	console.log(studentData);

    fetch('http://localhost:8080/students/addStudent', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(studentData),
    })
	.then(response => {
	        if (response.ok) {
	            alert('Student registered successfully');
	        } else {
	            alert('Student registration failed');
	        }
	    })
	    .catch(error => {
	        console.error('Error:', error);
	        alert('Student registration failed');
	    });
});
