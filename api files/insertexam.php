<?php

$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");

$coursee = $_POST["coursee"];
$code1 = $_POST["code1"];
$code2 = $_POST["code2"];
$code3 = $_POST["code3"];

$sql = "INSERT INTO computer(coursee,code1,code2,code3) VALUES ('$coursee','$code1','$code2','$code3')";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data inserted";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

