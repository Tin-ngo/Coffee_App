<?php    
                                       // MODEL CHO CÁC THÔNG TIN SẢN PHẨM
    require_once('ketnoi.php');

    /**
     * 
     */
    class hoadon
    {
    	var $conn;
    	
    	function __construct()
    	{
    		$connect_obj = new ketnoi();
    		$this->conn = $connect_obj->connect;
    	}
    	
    	function all()
    	{
    		$query = "SELECT datnuoc.idDatnuoc, datnuoc.ngay, datnuoc.idSoban, datnuoc.idNuoc, nuoc.tenNuoc, datnuoc.soluong, giathanh.GiaNiemYet 
                        FROM datnuoc 
                        INNER JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc 
                        INNER JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh
                        WHERE thanhtoan = '1' ";

    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}


         function timkiem_hd($timkiem_hd)
        {
            $query = "SELECT * FROM hoadon WHERE idUser LIKE '%$timkiem_hd%' ORDER BY idhoadon";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }




    	function find($id)   
        {
            $query = "SELECT * FROM hoadon WHERE idHoaDon=$id";  // viết idhoadon vẫn được
            return $this->conn->query($query)->fetch_assoc();
        }


         function delete($id)        //đang
         {
            $query = "DELETE FROM datnuoc WHERE idDatnuoc='$id' ";
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script>";
                echo "location.href='?action=hoadon';</script>";

            }else{
                echo "<script> ";
                echo "location.href='?action=trangchu';</script>";
            }
         }


         //duyệt hóa đơn
          function duyet_hoadon($id)        //đang
         {
            $query = "UPDATE hoadon SET trangthai = 1 WHERE idhoadon = '$id' ";

            $result = $this->conn->query($query);

            if($result == true){

                echo "<script>";
                echo "location.href='?action=hoadon';</script>";

            }else{
                echo "<script> ";
                echo "location.href='?action=trangchu';</script>";
            }
         }



          function sanpham_tru($id, $sotru)     
         {
            $query = "UPDATE sanpham SET soluong = soluong - '$sotru' WHERE idSP = '$id'";
            
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script>";
                echo "location.href='?action=hoadon';</script>";

            }else{
                echo "<script> ";
                echo "location.href='?action=trangchu';</script>";
            }
         }




         //xem chi tiết hóa đơn

         function user($id)
         {
             $query = "SELECT * FROM user WHERE idUser=$id";

            return $this->conn->query($query)->fetch_assoc();

         }

         function sanpham($id)
         {
             $query = "SELECT * FROM hoadon WHERE idHoaDon=$id";

             return $this->conn->query($query)->fetch_assoc();

         }







    }
     
?>