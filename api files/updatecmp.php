<?php

$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$id = $_POST["id"];
$coursee = $_POST["coursee"];
$code1 = $_POST["code1"];
$code2 = $_POST["code2"];
$code3 = $_POST["code3"];

$sql = "UPDATE computer SET coursee = '$coursee',code1 = '$code1',code2 = '$code2',code3 = '$code3' WHERE id = '$id'";
$result = mysqli_query($connection,$sql);
if($result){
    echo "data updated";
}
else{
echo "failed";
}
mysqli_close($connection);
?>

