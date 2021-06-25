<?php    
                                       // MODEL CHO CÁC THÔNG TIN SẢN PHẨM
    require_once('ketnoi.php');

    /**
     * 
     */
    class user
    {
    	var $conn;
    	
    	function __construct()
    	{
    		$connect_obj = new ketnoi();
    		$this->conn = $connect_obj->connect;
    	}
    	
    	function all()  
    	{
    		// $query = "SELECT * FROM user ORDER BY idUser";
            $query = "SELECT * FROM user 
                        INNER JOIN phanquyen
                        ON user.idQuyen = phanquyen.idQuyen
                        ORDER BY idUser";

    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}

        function all_phanquyen(){

            $query = "SELECT * FROM phanquyen ORDER BY idQuyen";
            $result = $this->conn->query($query);
            $data = array();

            while ($row = $result->fetch_assoc()) {
                $data[] = $row;
            }
            return $data;
        }

        function timkiem_bn($timkiem_bn)
        {
            $query = "SELECT * FROM user 
                        INNER JOIN phanquyen
                        ON user.idQuyen = phanquyen.idQuyen
                         WHERE ten LIKE '%$timkiem_bn%' ORDER BY idUser";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }


    	function find($id) 
        {
            $query = "SELECT * FROM user 
                        INNER JOIN phanquyen
                        ON user.idQuyen = phanquyen.idQuyen
                        WHERE idUser=$id
                        ORDER BY idUser ";
            return $this->conn->query($query)->fetch_assoc();
        }


         function update($idUser, $idQuyen, $ho, $ten, $email, $diachi, $gioitinh, $sodienthoai, $tendangnhap, $matkhau) 
        {
                 
            $query="UPDATE user SET idQuyen='$idQuyen', ho='$ho', ten='$ten', email='$email', diachi='$diachi', gioitinh='$gioitinh', sodienthoai='$sodienthoai', tendangnhap='$tendangnhap', matkhau='$matkhau' WHERE idUser='$idUser' ";        

            $result = $this->conn->query($query);

           if($result == true){
                header('location: ?action=user');
            }
            else{
                header('location: ?action=trangchu');
            }
        

         }

         function insert($idQuyen, $ho, $ten, $email, $diachi, $gioitinh, $sodienthoai, $tendangnhap, $matkhau)
         {

             $query= "INSERT INTO user (idQuyen, ho, ten, email, diachi, gioitinh, sodienthoai, tendangnhap, matkhau) 
            VALUES ('$idQuyen', '$ho', '$ten', '$email', '$diachi', '$gioitinh', '$sodienthoai', '$tendangnhap', '$matkhau') ";

            $result = $this->conn->query($query);

            if($result == true){
                header('location: ?action=user');
            }
            else{
                header('location: ?action=trangchu');
            }
         }

         function delete($id)
         {
            $query = "DELETE FROM user WHERE idUser='$id' ";
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script> ";
                echo "location.href='?action=user';</script>";

            }else{
                echo "<script>";
                echo "location.href='?action=trangchu';</script>";
            }
         }





    }
     
?>