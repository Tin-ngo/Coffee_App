<?php

    require_once('ketnoi.php');
    /**
     * 
     */
    class nuoc
    {
    	var $conn;

    	function __construct()
    	{
    		$connect_obj = new ketnoi();
            $this->conn = $connect_obj->connect;
    	}

    	function all()
    	{
    		$query = "SELECT * FROM nuoc ORDER BY idNuoc ASC";

    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}


        function timkiem($timkiem)
        {
            $query = "SELECT * FROM nuoc WHERE tenNuoc LIKE '%$timkiem%' ORDER BY idNuoc";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }




        function find($id)
        {
            $query = "SELECT * FROM nuoc WHERE idNuoc=$id";
            return $this->conn->query($query)->fetch_assoc();
        }

        function update($idNuoc, $idLoaiNuoc, $tenNuoc, $hinhanh, $mota, $idGiaThanh)
        {
            

     
             $query="UPDATE nuoc SET idLoaiNuoc='$idLoaiNuoc',tenNuoc='$tenNuoc', hinhanh='$hinhanh', mota='$mota', idGiaThanh='$idGiaThanh' WHERE idNuoc='$idNuoc';";        

            $result = $this->conn->query($query);

            if($result == true){

                header('Location: ?action=nuoc');
            }
        

         }

         function insert($idLoaiNuoc, $tenNuoc, $hinhanh, $mota, $idGiaThanh)
         {
            $query= "INSERT INTO nuoc (idLoaiNuoc, tenNuoc, hinhanh, mota, idGiaThanh) 
            VALUES ('$idLoaiNuoc', '$tenNuoc', '$hinhanh', '$mota', '$idGiaThanh')";  

            $result = $this->conn->query($query);

            if($result == true){
                header('location: ?action=nuoc');
            }
            else{
                header('location: ?action=trangchu');
            }
         }

         function delete($id)
         {
            $query = "DELETE FROM nuoc WHERE idNuoc='$id' ";
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script> ";
                echo "location.href='?action=nuoc';</script>";

            }else{
                echo "<script> alert('LỖI, Chưa xóa được người dùng');";
                echo "location.href='?action=trangchu';</script>";
            }
         }

// // phân quyền
//          function phanquyen($idUser, $idQuyen)
//          {
//             $query = "UPDATE user SET idQuyen='$idQuyen' WHERE idUser='$idUser';";

//             $result = $this->conn->query($query);

//             if($result == true){

//                 header('Location: ?action=taikhoan');
//             }
//          }


}

?>