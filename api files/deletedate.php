<?php
$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$id = $_POST["id"];
$sql = "DELETE FROM date WHERE id='$id'";

$result=mysqli_query($connection,$sql);
if($result){
    echo "Data Deleted";
}
else{
    echo "failed";
}
mysqli_close($connection);
?>

