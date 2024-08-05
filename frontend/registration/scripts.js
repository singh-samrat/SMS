document.addEventListener('DOMContentLoaded', function() {
    const days = document.getElementById('dob-day');
    const months = document.getElementById('dob-month');
    const years = document.getElementById('dob-year');

    const dayPlaceholder = document.createElement('option');
    dayPlaceholder.value = "";
    dayPlaceholder.disabled = true;
    dayPlaceholder.selected = true;
    dayPlaceholder.textContent = "Day";
    days.appendChild(dayPlaceholder);

    for (let i = 1; i <= 31; i++) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = i;
        days.appendChild(option);
    }

    const monthNames = [
        'January', 'February', 'March', 'April', 'May', 'June',
        'July', 'August', 'September', 'October', 'November', 'December'
    ];

    const monthPlaceholder = document.createElement('option');
    monthPlaceholder.value = "";
    monthPlaceholder.disabled = true;
    monthPlaceholder.selected = true;
    monthPlaceholder.textContent = "Month";
    months.appendChild(monthPlaceholder);

    monthNames.forEach((month, index) => {
        const option = document.createElement('option');
        option.value = month;
        option.textContent = month;
        months.appendChild(option);
    });

    const yearPlaceholder = document.createElement('option');
    yearPlaceholder.value = "";
    yearPlaceholder.disabled = true;
    yearPlaceholder.selected = true;
    yearPlaceholder.textContent = "Year";
    years.appendChild(yearPlaceholder);

    const currentYear = new Date().getFullYear();
    for (let i = currentYear; i >= 1900; i--) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = i;
        years.appendChild(option);
    }
});


document.getElementById('loginForm').addEventListener('submit', async function(event){
    event.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const day = document.getElementById('dob-day').value;
    const month = document.getElementById('dob-month').value;
    const year = document.getElementById('dob-year').value;

    const userData = {
        name : name,
        email : email,
        password : password,
        day : day,
        month : month,
        year : year
    };

    try {
        const response = await fetch('http://localhost:8080/api/v1/authenticate/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        if (response.ok) {
            const data = await response.text();
            const event = new CustomEvent('formDataReady', {detail: {userData, source : "registration"}});
            document.dispatchEvent(event);
            // window.location.href = "/login/login.html";   
        } else {
            const error = await response.text();
            console.error('Registration failed:', error);
            alert('Registration failed: ' + error);
        }   
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred: ' + error.message);
    }
    
});