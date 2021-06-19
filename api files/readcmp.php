<?php
$connection = mysqli_connect("localhost","id17028422_uogexam","Sheri0808/Ali1212","id17028422_examre");
$result = array();
$result['data']=array();
$select = "SELECT *from computer";
$responce = mysqli_query($connection,$select);
while($row = mysqli_fetch_array($responce)){
    $index['id']  = $row['0'];
    $index['coursee']  = $row['1'];
    $index['code1']  = $row['2'];
    $index['code2']  = $row['3'];
    $index['code3']  = $row['4'];
            
    array_push($result['data'],$index);
    
}
$result["success"]="1";
echo json_encode($result);
mysqli_close($connection);
?>

