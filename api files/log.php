<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$email = $_POST["email"];
$password = $_POST["password"];
$sql = "SELECT * FROM student WHERE email = '$email' AND password = '$password'";
$result = mysqli_query($connection,$sql);
if($result->num_rows>0){
    echo "logged in successfully";
}
else{
echo "failed";
}
mysqli_close($connection);
?>