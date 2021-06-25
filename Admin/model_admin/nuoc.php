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
    		$query = "SELECT * FROM nuoc 
                        INNER JOIN loainuoc 
                        ON nuoc.idLoaiNuoc = loainuoc.idLoaiNuoc
                        INNER JOIN giathanh
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh
                        ORDER BY idNuoc";
    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}


        function All_LoaiNuoc()
        {
            $query = "SELECT * FROM loainuoc";
            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }


        function All_GiaThanh()
        {
            $query = "SELECT * FROM giathanh";
            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }


        function timkiem($timkiem)
        {
            // $query = "SELECT * FROM nuoc WHERE tenNuoc LIKE '%$timkiem%' ORDER BY idNuoc";
            $query = "SELECT * FROM nuoc 
                        INNER JOIN loainuoc 
                        ON nuoc.idLoaiNuoc = loainuoc.idLoaiNuoc
                        INNER JOIN giathanh
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh
                        WHERE tenNuoc LIKE '%$timkiem%' 
                        ORDER BY idNuoc";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }





        function find($id)
        {
            $query = "SELECT * FROM nuoc 
                        INNER JOIN loainuoc 
                        ON nuoc.idLoaiNuoc = loainuoc.idLoaiNuoc
                        INNER JOIN giathanh
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh
                         WHERE idNuoc=$id";
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
                echo "<script> alert('LỖI');";
                echo "location.href='?action=nuoc';</script>";
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