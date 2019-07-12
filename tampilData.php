<?php
    
	$sql = "SELECT * FROM haji";
	
	$r = mysqli_query($con,$sql);
	
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		array_push($result,array(
		"id"=>$row['id'],
		"name"=>$row['nama']
		));
	}
	
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>