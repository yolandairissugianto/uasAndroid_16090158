<?php
    if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$name = $_POST['name'];
		$no_hp = $_POST['no_hp'];
		$alamat = $_POST['alamat'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO data_haji (nama, no_hp, alamat) VALUES ('$name','$no_hp','$alamat')";
		
		require_once('koneksi.php');
		
		if(mysqli_query($con,$sql)){
		echo 'Berhasil Menambahkan Pegawai';
		}else{
		echo 'Gagal Menambahkan Pegawai';
		}
		
		mysqli_close($con);
	}
?>