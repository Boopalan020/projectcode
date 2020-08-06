// for validating the usre name
function validateName() {
    var name = document.getElementById('username').value;
    var regex = /^[a-zA-Z ]*$/;

    if (name.match(regex))
        document.getElementById('name-error').innerHTML = "";
    else
        document.getElementById('name-error').innerHTML = "<div class='alert alert-danger'><strong> Only Alphabets and Space </strong></div>";
}

// For validating the phone number
function validatePhone() {
    var phno = document.getElementById('phno').value;
    var exp = /^\d{10}$/;

    if (phno.match(exp))
        document.getElementById('numb-error').innerHTML = "";
    else
        document.getElementById('numb-error').innerHTML = "<div class='alert alert-danger'><strong> Only digits allowed (10 - digits) </strong></div>";
}

// for validating the password
function validatePsw() {
    var psw = document.getElementById('psw').value;
    var exp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})";

    if (psw.match(exp)) {
        document.getElementById('psw-error').innerHTML = "";
    } else {
        document.getElementById('psw-error').innerHTML = " <div class='alert alert-danger'> <strong> <ul> <li> Atleast or above 8 character </li><li> Atleast 1 Lowercase </li><li> Atleast 1 Uppercase </li><li> Atleast 1 Number </li> </ul> </strong> </div> ";
    }
}

// to match the entered password
function matchPsw()
{
    var cpsw = document.getElementById('cpsw').value;
    var psw = document.getElementById('psw').value;

    if(psw.localeCompare(cpsw) == 0)
        document.getElementById('cpsw-error').innerHTML = "";
    else
        document.getElementById('cpsw-error').innerHTML = "<div class='alert alert-danger'> Password doesn't match </div>";
}

function disableTextBox(dname)
{
    var textbox = document.getElementById(dname);
    textbox.disabled = !(textbox.disabled);
}