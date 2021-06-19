<?php

$connection = mysqli_connect("localhost","id17060054_degreeclr","Fatima0811/Sheri0808","id17060054_degreeclear");
$name = $_POST["name"];
$email = $_POST["email"];
$password = $_POST["password"];

$sql = "INSERT INTO student(name,email,password) VALUES ('$name','$email','$password')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>