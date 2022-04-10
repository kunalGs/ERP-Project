let login_form = document.getElementById('login-Validation');

login_form.addEventListener('submit', async (e)=>{
    e.preventDefault();
    e.stopPropagation();
    if(login_form.checkValidity()===true){
        let response = await fetch('api/admin/login', {
            method: 'POST',
            headers:{
                'Content-Type':'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                username :document.getElementById('userName').value,
                password :document.getElementById('pwd').value,
            })
        });

        let result = await response;
        if(result["status"]===200){
            window.location.href = 'dashboard.html';
        }else{
            document.getElementById("login-alert").style.display = "block";
        }
    }
})