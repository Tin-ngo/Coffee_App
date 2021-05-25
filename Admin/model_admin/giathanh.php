<?php    
                                       // MODEL CHO CÁC THÔNG TIN SẢN PHẨM
    require_once('ketnoi.php');

    /**
     * 
     */
    class giathanh
    {
    	var $conn;
    	
    	function __construct()
    	{
    		$connect_obj = new ketnoi();
    		$this->conn = $connect_obj->connect;
    	}

        function phantrang()
        {
            $query = "SELECT * FROM sanpham";
            return $this->conn->query($query);
        }
        function phantrang_timkiem()
        {
            $query = "SELECT * FROM sanpham WHERE tenSP LIKE '%$timkiem_sp%'";
            return $this->conn->query($query);
        }

        function all_them()
        {
            
            $query = "SELECT * FROM sanpham; ";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }

    	
    	function all()
    	{
            
    		$query = "SELECT * FROM giathanh ORDER BY idGiaThanh";

    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}

        function timkiem_sp($timkiem_sp, $batdau, $gioihan)
        {
            $query = "SELECT * FROM sanpham WHERE tenSP LIKE '%$timkiem_sp%' LIMIT $batdau, $gioihan";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }



 

    	function find($id)
        {
             $query = "SELECT * FROM giathanh WHERE idGiaThanh=$id"; 
            return $this->conn->query($query)->fetch_assoc();
        }


         function update($idGiaThanh, $GiaNiemYet, $idKM) 
        {
            
             $query="UPDATE giathanh SET GiaNiemYet='$GiaNiemYet', idKM='$idKM' WHERE idGiaThanh='$idGiaThanh';";        

            $result = $this->conn->query($query);

            if($result == true){

                header('Location: ?action=giathanh');
            }

         }

         function insert($GiaNiemYet, $idKM) 
         {

            $query= "INSERT INTO giathanh (GiaNiemYet, idKM) 
            VALUES ('$GiaNiemYet', '$idKM') ";

            $result = $this->conn->query($query);

            if($result == true){
                header('location: ?action=giathanh');
            }
            else{
                header('location: ?action=trangchu');
            }
         }



         function delete($id)        //dang
         {
            $query = "DELETE FROM giathanh WHERE idGiaThanh='$id' ";
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script> ";
                echo "location.href='?action=giathanh';</script>";

            }else{
                echo "<script>  ";
                echo "location.href='?action=trangchu';</script>";
            }
         }

         // function khuyenmai()
         // {

         //    $query = "SELECT * FROM khuyenmai";

         //    $result = $this->conn->query($query);

         //    $data = array();

         //    while ($row = $result->fetch_assoc()) {
         //       $data[] = $row;
         //    }

         //    return $data;

         // }

       






    }
     
?>