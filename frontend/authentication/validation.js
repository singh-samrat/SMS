document.addEventListener('formDataReady', function(event){
        const {formData, source} = event.detail;
        alert(event.detail);
        if(source === "Login"){
            validation(formData);
            // window.location.href = "/Home/home.html";   
        }else{
            validation(formData);
            // window.location.href = "/login/login.html";   
        }
});

function validation(formData){
    alert(formData);
}