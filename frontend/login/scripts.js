document.getElementById('loginForm').addEventListener('submit',async function(event){
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    
    console.log(email);

    const loginData = {
        email : email,
        password: password
    };

    try {
        const response = await fetch('http://localhost:8080/api/v1/authenticate/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData)
        });

        if (response.ok) {
            const data = await response.text();
           
            const event = new CustomEvent('formDataReady', {detail: {loginData, source : "Login"}});
            document.dispatchEvent(event);
            // window.location.href = "/Home/home.html";   
        } else {
            const error = await response.text();
            console.error('Login failed:', error);
            alert('Login failed: ' + error);
        }   
    } catch (error) {
        console.error('Error:', error);
        alert('An error occurred: ' + error.message);
    }
});

