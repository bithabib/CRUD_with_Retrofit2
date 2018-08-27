# CRUD_with_Retrofit2
CRUD operation using retrofit2.

PHP code : 
Login PHP code :
<?php
	require_once('dbConnect.php');
	$password = $_POST['password'];
	$id = $_POST['id'];
	$sql = "SELECT * FROM `EmployeeTable` WHERE id= '$id' AND password='$password' ";
	$result = mysqli_query($con,$sql);
	$count=mysqli_num_rows($result);
	if($count==1){
		$response["success"] = 1;
	}
	else{
		$response["success"] = 2;
	}
	echo json_encode($response);
?>

1. Data Base connect :
This is php code for connect with mysql database. 
<?php
  define('HOST','localhost');
  define('USER','root');
  define('PASS','');
  define('DB','EmployeeInformation'); 
  $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
?>
2. Insert: 
Insert data into database

<?php
	require_once('dbConnect.php');
	$name = $_POST['name'];
	$type = $_POST['type'];
	$id = $_POST['id'];
	$address = $_POST['address'];
	$date_of_joining = $_POST['date_of_joining'];
	$password=$_POST['password'];
	$sql = "insert into EmployeeTable(name,type,id,address, date_of_joining, password) values ('$name','$type','$id','$address','$date_of_joining','$password');";
	if (mysqli_query($con,$sql)){
		$response["success"] = 1;
	    $response["message"] = "Food successful inserted!";
	    echo json_encode($response);
	}
	else {
		$response["success"] = 2;
	    $response["message"] = "Food not inserted!";
	    echo json_encode($response);
	}
	mysqli_close($con);
?>

3. Fetch data: 
Retrivie data from database. 

<?php
	require_once('dbConnect.php');
	$sql = "SELECT * FROM `EmployeeTable`";
	$result = mysqli_query($con,$sql);
	$json = array();
	while($row =  mysqli_fetch_assoc($result)){
    	$json[]=$row;
	}
	$response["success"] = 1;
	echo json_encode($json);
	
?>


4. Update Data


<?php
	require_once('dbConnect.php');
	$name = $_POST['name'];
	$type = $_POST['type'];
	$id = $_POST['id'];
	$address = $_POST['address'];
	$date_of_joining = $_POST['date_of_joining'];
	$sql = "UPDATE `EmployeeTable` SET name='$name',type='$type',address='$address',date_of_joining='$date_of_joining' WHERE id=$id";
	$result = mysqli_query($con,$sql);
	$response["success"] = 1;
	echo json_encode($response);
?>

5. Delete data: 
<?php
	require_once('dbConnect.php');
	$id = $_POST['id'];
	$sql = "DELETE FROM `EmployeeTable` WHERE id=$id";
	$result = mysqli_query($con,$sql);
	$response["success"] = 1;
	echo json_encode($response);
	
?>

