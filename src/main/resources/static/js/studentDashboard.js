document.addEventListener("DOMContentLoaded", () => {
    // Toggle sections based on clicked link
    const links = document.querySelectorAll("nav ul li a");
    const sections = document.querySelectorAll(".section");

    links.forEach(link => {
        link.addEventListener("click", (event) => {
            event.preventDefault();

            const id = link.id.split("-")[0] + "-section";

            sections.forEach(section => {
                section.classList.remove("active");
            });

            document.getElementById(id).classList.add("active");
        });
    });

    // Mobile Menu Toggle
    const menuToggle = document.getElementById("mobile-menu");
    const navbarUl = document.querySelector(".navbar ul");

    menuToggle.addEventListener("click", () => {
        navbarUl.classList.toggle("active");
    });

    // Fetch student data dynamically after login (example)
    fetch('http://localhost:8080/students/data')
        .then(response => response.json())
        .then(data => {
            document.getElementById('student-name').textContent = data.name;
            document.getElementById('student-roll').textContent = data.rollNumber;
            document.getElementById('student-email').textContent = data.email;
            document.getElementById('student-course').textContent = data.course;
            document.getElementById('student-grade').textContent = data.averageGrade;
        })
        .catch(err => console.error('Error fetching student data:', err));
});
