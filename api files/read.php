<?php
$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$result = array();
$result['data']=array();
$select = "SELECT *from exam";
$responce = mysqli_query($connection,$select);
while($row = mysqli_fetch_array($responce)){
    $index['id']  = $row['0'];
    $index['name']  = $row['1'];
    $index['roll']  = $row['2'];
    $index['email']  = $row['3'];
    $index['course1']  = $row['4'];
    $index['course2']  = $row['5'];
    $index['course3']  = $row['6'];
    $index['course4']  = $row['7'];
            
    array_push($result['data'],$index);
    
}
$result["success"]="1";
echo json_encode($result);
mysqli_close($connection);
?>

