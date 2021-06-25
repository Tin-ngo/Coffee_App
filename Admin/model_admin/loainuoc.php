<?php    
                                       // MODEL CHO CÁC THÔNG TIN SẢN PHẨM
    require_once('ketnoi.php');

    /**
     * 
     */
    class loainuoc
    {
    	var $conn;
    	
    	function __construct()
    	{
    		$connect_obj = new ketnoi();
    		$this->conn = $connect_obj->connect;
    	}
    	
    	function all() 
    	{
    		$query = "SELECT * FROM loainuoc ORDER BY idLoaiNuoc";

    		$result = $this->conn->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}

         function timkiem_lsp($timkiem_lsp)
        {   
            $query = "SELECT * FROM loainuoc WHERE tenLN LIKE '%$timkiem_lsp%' ORDER BY idLoainuoc";

            $result = $this->conn->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }




    	function find($id)
        {
            $query = "SELECT * FROM loainuoc WHERE idLoaiNuoc=$id";
            return $this->conn->query($query)->fetch_assoc();
        }


         function update($idLoaiNuoc, $tenLN) 
        {
            

     
             $query="UPDATE loainuoc SET tenLN='$tenLN' WHERE idLoaiNuoc='$idLoaiNuoc' ";        

            $result = $this->conn->query($query);

            if($result == true){

                header('Location: ?action=loainuoc');
            }
        

         }

         function insert($tenLN) 
         {

             $query= "INSERT INTO loainuoc (tenLN) 
            VALUES ('$tenLN') ";

            $result = $this->conn->query($query);

            if($result == true){
                header('location: ?action=loainuoc');
            }
            else{
                header('location: ?action=trangchu');
            }
         }

         function delete($id)     //đang
         {
            $query = "DELETE FROM loainuoc WHERE idLoaiNuoc='$id' ";
            $result = $this->conn->query($query);

            if($result == true){

                echo "<script> ";
                echo "location.href='?action=loainuoc';</script>";

            }else{
                echo "<script>  ";
                echo "location.href='?action=trangchu';</script>";
            }
         }





    }
     
?>