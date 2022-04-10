let form_userName = document.getElementById("crs_name");
let form_code = document.getElementById("code");
let form_specialization = document.getElementById("spc");
let form_capacity = document.getElementById("cpc");
let form_credit = document.getElementById("credit");
let form_error = document.getElementById('error');
let form_delete_field = document.getElementById('crsID');
let form_error_delete = document.getElementById('deleteError');

let update_error = document.getElementById('updateError');
let update_alert = document.getElementById('updateAlert');

function hideElement(){
    var x = document.getElementById("show_course");
    var y = document.getElementById("addCourse");
    let z = document.getElementById("delete");
    let v = document.getElementById("update");

    v.style.display = "none";
    z.style.display = "none";
    x.style.display = "none";
    y.style.display = "none";
}

async function fetch_courses(){
    let x = document.getElementById("show_course");
    let y = document.getElementById("addCourse");
    let z = document.getElementById("delete");
    let v = document.getElementById("update");
    if(x.style.display==="block"){
        x.style.display = "none";
        let rowLength = document.getElementById("tableSelect").rows.length;
        for(let i=1; i<rowLength; i++){
            document.getElementById("tableSelect").deleteRow(1);
        }
        return;
    }
    let response = await fetch("api/course/getCourse");
    let courses = await response.json();
    console.log("In Fetch Course");

    let table = document.getElementById("tableBody");

    courses.forEach(courses => {
        let row = table.insertRow();

        let CourseID = row.insertCell(0);
        CourseID.innerHTML = courses['course_id'];
        CourseID.setAttribute("class", "course_id")

        let Name = row.insertCell(1);
        Name.innerHTML = courses['course_name'];
        Name.setAttribute("class", "name")

        let CourseCode = row.insertCell(2);
        CourseCode.innerHTML = courses['course_code'];
        CourseCode.setAttribute("class", "course_code")

        let Specialization = row.insertCell(3);
        Specialization.innerHTML = courses['specialization'];
        Specialization.setAttribute("class", "description")

        let Capacity = row.insertCell(4);
        Capacity.innerHTML = courses['capacity'];
        Capacity.setAttribute("class", "capacity")

        let Credit = row.insertCell(5);
        Credit.innerHTML = courses['credit'];
        Credit.setAttribute("class", "credit")

        let Prerequisite = row.insertCell(6);
        Prerequisite.innerHTML = courses['prerequisite'];
        Prerequisite.setAttribute("class", "Prerequisite");
    });

    // let x = document.getElementById("show_course");
    // let y = document.getElementById("addCourse");
    if(x.style.display==="none"){
        z.style.display = "none";
        y.style.display = "none";
        v.style.display = "none";
        x.style.display = "block";
    }
}

async function add_course(){
    let x = document.getElementById("show_course");
    let y = document.getElementById("addCourse");
    let z = document.getElementById("delete");
    let v = document.getElementById("update");
    if(y.style.display==="none"){
        z.style.display="none";
        x.style.display="none";
        v.style.display="none"
        let rowLength = document.getElementById("tableSelect").rows.length;
        for(let i=1; i<rowLength; i++){
            document.getElementById("tableSelect").deleteRow(1);
        }
        y.style.display = "block";
    }
    else {
        y.style.display = "none"
    }
}

async function add_course_form(){
        if (!form_userName.value||!form_code.value||!form_specialization.value||!form_capacity.value||!form_credit.value){
            form_error.innerHTML = "All fields are mandatory";
            return;
        }
        if(isNaN(form_capacity.value)||isNaN(form_credit.value)){
            form_error.innerHTML = "Capacity or Credit should be a number";
            return;
        }


        let response = await fetch('api/course/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                course_name: document.getElementById('crs_name').value,
                course_code: document.getElementById('code').value,
                specialization: document.getElementById('spc').value,
                capacity: document.getElementById('cpc').value,
                credit: document.getElementById('credit').value,
                prerequisite: document.getElementById('prerequisite').value,
            })
        });

        let result = await response;
        if (result["status"] === 200) {
            document.getElementById("course-alert").style.display = "block";
        } else {
            document.getElementById("course-alert-fail").style.display = "block";
        }
}

async function delete_course(){
    let x = document.getElementById("show_course");
    let y = document.getElementById("addCourse");
    let z = document.getElementById("delete");
    if(z.style.display==="none"){
        x.style.display="none";
        let rowLength = document.getElementById("tableSelect").rows.length;
        for(let i=1; i<rowLength; i++){
            document.getElementById("tableSelect").deleteRow(1);
        }
        y.style.display = "none";
        z.style.display = "block";
    }
    else {
        z.style.display = "none";
    }
}

async function delete_crs_form(){
    if (isNaN(form_delete_field.value)){
        form_error_delete.innerHTML = "Enter a Valid Number";
        return;
    }


    let response = await fetch('api/course/deleteCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            capacity: document.getElementById('crsID').value,
        })
    });

    let result = await response;
    if (result["status"] === 200) {
        document.getElementById("delete-alert").style.display = "block";
    } else {
        document.getElementById("course-alert-fail").style.display = "block";
    }
}

async function update_course(){
    let x = document.getElementById("show_course");
    let y = document.getElementById("addCourse");
    let z = document.getElementById("delete");
    let v = document.getElementById("update");

    if(v.style.display==="none"){
        x.style.display="none";
        let rowLength = document.getElementById("tableSelect").rows.length;
        for(let i=1; i<rowLength; i++){
            document.getElementById("tableSelect").deleteRow(1);
        }
        y.style.display = "none";
        z.style.display = "none";
        v.style.display = "block";
    }
    else {
        v.style.display = "none";
    }
}

async function update_crs_form() {

    let response = await fetch('api/course/updateCourse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            credit: document.getElementById('field').value,
            capacity: document.getElementById('value').value,
        })
    });

    let result = await response;
    if (result["status"] === 200) {
        update_alert.innerHTML = "Updated Successfully";
    } else {
        update_alert.innerHTML = "Update Unsuccessful";
        update_alert.style.color = "brown";
    }
}