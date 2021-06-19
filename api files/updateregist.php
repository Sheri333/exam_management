<?php

$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$id = $_POST["id"];
$name = $_POST["name"];
$roll = $_POST["roll"];
$email = $_POST["email"];
$course1 = $_POST["course1"];
$course2 = $_POST["course2"];
$course3 = $_POST["course3"];
$course4 = $_POST["course4"];

$sql = "UPDATE exam SET name = '$name',roll = '$roll',email = '$email',course1 = '$course1',course2 = '$course2',course3 = '$course3',course4 = '$course4' WHERE id = '$id'";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data updated";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

