<?php

$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$name = $_POST["name"];
$roll = $_POST["roll"];
$email = $_POST["email"];
$course1 = $_POST["course1"];
$course2 = $_POST["course2"];
$course3 = $_POST["course3"];
$course4 = $_POST["course4"];

$sql = "INSERT INTO exam(name,roll,email,course1,course2,course3,course4) VALUES ('$name','$roll','$email','$course1','$course2','$course3','$course4')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

