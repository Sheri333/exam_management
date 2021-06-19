<?php

$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$course = $_POST["course"];
$code = $_POST["code"];
$room = $_POST["room"];
$date = $_POST["date"];

$sql = "INSERT INTO date(course,code,room,date) VALUES ('$course','$code','$room','$date')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

