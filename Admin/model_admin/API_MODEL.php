<?php    
                                       // MODEL CHO CÁC THÔNG TIN SẢN PHẨM
    require_once('ketnoi.php');

    /**
     * 
     */
    class API
    {
    	var $api;
    	
    	function __construct()
    	{
    		$connect_obj = new ketnoi();
            $this->api = $connect_obj->connect;
    	}

        function all_loainuoc()
        {
            
            $query = "SELECT * FROM loainuoc ORDER BY idloaiNuoc";

            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }

        function insert_loainuoc(){

            if(isset($_POST["tenLN"])){   // Thay bằng $_GET thì được

                // $tenLN = $_POST["tenLN"]
            $tenLN = filter_input(INPUT_POST, 'tenLN');  // Thay bằng INPUT_GET thì được

            $query = "INSERT INTO loainuoc(tenLN) VALUES ('$tenLN') ";

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;

        }

        function all_user()   //r  - dùng để đăng nhập user
        {
            
            $query = "SELECT * FROM user ORDER BY idUser";

            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }

        //PHẦN THÊM
        function lay_soban()   //r  - dùng để lấy số bàn 
        {
            $query = "SELECT * FROM soban";
            $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }

        function lay_datnuoc()   //r  - dùng để lấy bảng đặt bàn
        {
            $query = "SELECT * FROM datnuoc";
            $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }


        //HẾT PHẦN THÊM



        function all_soban()  
        {

            // $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet FROM soban LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh WHERE datnuoc.idDatnuoc IS NULL ORDER BY soban.idSoban";
            $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet FROM soban 
                LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban 
                LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc 
                LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh 
                WHERE datnuoc.thanhtoan = 1 || datnuoc.idDatnuoc IS NULL 
                ORDER BY soban.idSoban";


            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }

        function soban_order()  
        {

            // $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet FROM soban LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh 
            // WHERE datnuoc.idDatnuoc IS NOT NULL 
            // ORDER BY soban.idSoban";


//             $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet
// FROM soban 
// LEFT JOIN datnuoc ON  soban.idSoban = datnuoc.idSoban
// LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc 
// LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh 
//             WHERE datnuoc.idDatnuoc IS NOT NULL 
//             ORDER BY soban.idSoban";

            // $query = "SELECT DISTINCT soban.idSoban FROM soban LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh WHERE datnuoc.idDatnuoc IS NOT NULL ORDER BY soban.idSoban";
            $query = "SELECT DISTINCT soban.idSoban FROM soban LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh WHERE datnuoc.thanhtoan = 0 && datnuoc.idDatnuoc IS NOT NULL ORDER BY soban.idSoban";


            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }





        // chưa
    	function all_nuoc()
    	{
            
    		$query = "SELECT * FROM nuoc ORDER BY idNuoc";

    		$result = $this->api->query($query);

    		$data = array();

    		while ($row = $result->fetch_assoc()) {
       		   $data[] = $row;
    		}

    		return $data;
    	}



// insert đặt bàn -- chưa xong
        function insert_datnuoc(){
            if(isset($_POST["idSoban"])){ 
                // $tenLN = $_POST["tenLN"]
            $idSoban = filter_input(INPUT_POST, 'idSoban');
            $idNuoc = filter_input(INPUT_POST, 'idNuoc');
            $soluong = filter_input(INPUT_POST, 'soluong');
            $ngay = filter_input(INPUT_POST, 'ngay');


            $query = "INSERT INTO datnuoc(idSoban, idNuoc, soluong, ngay, thanhtoan, Xong_Don) 
            VALUES ('$idSoban', '$idNuoc', '$soluong', '$ngay', 0, 0) ";

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi rồi kìa kk'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;
        }


    // xoá đặt nước
        function delete_datnuoc(){
            if(isset($_POST["idSoban"])){ 
                // $tenLN = $_POST["tenLN"]
            $idSoban = filter_input(INPUT_POST, 'idSoban');
            $idNuoc = filter_input(INPUT_POST, 'idNuoc');
            $soluong = filter_input(INPUT_POST, 'soluong');
            $ngay = filter_input(INPUT_POST, 'ngay');

            $query = "DELETE FROM datnuoc
             WHERE idSoban='$idSoban' && idNuoc = '$idNuoc' &&
              ngay = '$ngay' ";

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;

        }
// xong delete


        function all_datnuoc_innerjoin()   // bàn đã order nước
        {
            
//             $query = "SELECT * FROM datnuoc ORDER BY idDatnuoc";
            // $query = "SELECT * FROM datnuoc 
            //         INNER JOIN soban 
            //         INNER JOIN nuoc 
            //         ON datnuoc.idSoban = soban.idSoban
            //             && datnuoc.idNuoc = nuoc.idNuoc
            //          ORDER BY Xong_Don
            //         ";

            $ngay = date("Y-m-d");

             $query = "SELECT * FROM datnuoc 
             INNER JOIN soban 
             INNER JOIN nuoc 
             ON datnuoc.idSoban = soban.idSoban && datnuoc.idNuoc = nuoc.idNuoc 
             INNER JOIN giathanh 
             ON nuoc.idGiaThanh = giathanh.idGiaThanh
             WHERE ngay = '$ngay'
              ORDER BY Xong_Don
            ";

            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }





                   
        function update_datnuoc(){

            if(isset($_POST["thanhtoan"])){ 
                // $tenLN = $_POST["tenLN"]
            $thanhtoan = filter_input(INPUT_POST, 'thanhtoan');
            $idDatnuoc = filter_input(INPUT_POST, 'idDatnuoc');

            $query="UPDATE datnuoc SET thanhtoan = '$thanhtoan'
                     WHERE idDatnuoc='$idDatnuoc'";  

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;
        }




// cập nhật nước đã bưng lên cho khách
        function update_xongnuoc(){

            if(isset($_POST["idDatnuoc"])){ 
                // $tenLN = $_POST["tenLN"]
            $Xong_Don = filter_input(INPUT_POST, 'Xong_Don');
            $idDatnuoc = filter_input(INPUT_POST, 'idDatnuoc');

            $query="UPDATE datnuoc SET Xong_Don = '$Xong_Don'
                     WHERE idDatnuoc='$idDatnuoc'";  

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;
        }



// lấy inner join nuoc và giá thành theo id các loại nước đã đặt
        function all_nuoc_giathanh()
        {
            $query = "SELECT * FROM datnuoc 
                        INNER JOIN giathanh 
                        INNER JOIN nuoc
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh && 
                        datnuoc.idNuoc = nuoc.idNuoc
                        ";

            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }



// lấy inner join nuoc và giá thành theo id các loại nước đã đặt hôm nay
        function loai_nuoc_giathanh_homnay()
        {
            $ngay = date("Y-m-d");
            $query="SELECT nuoc.tenNuoc, giathanh.GiaNiemYet, datnuoc.soluong
                        FROM datnuoc 
                        INNER JOIN giathanh 
                        INNER JOIN nuoc
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh && 
                        datnuoc.idNuoc = nuoc.idNuoc
                        WHERE datnuoc.ngay = '$ngay' && datnuoc.thanhtoan = 1
                        ";  
            // chọn những bàn đã thanh toán vì thanhtoan = 1 là đã tt, =0 là chưa tt

           $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }



        function loai_nuoc_giathanh_thangnay()
        {
            $thang = date("Y-m");
            $query="SELECT nuoc.tenNuoc, giathanh.GiaNiemYet, datnuoc.soluong
                         FROM datnuoc 
                        INNER JOIN giathanh 
                        INNER JOIN nuoc
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh && 
                        datnuoc.idNuoc = nuoc.idNuoc
                        WHERE datnuoc.ngay LIKE '%$thang%' && datnuoc.thanhtoan = 1
                        ";  
            // chọn những bàn đã thanh toán vì thanhtoan = 1 là đã tt, =0 là chưa tt

           $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }



        function loai_nuoc_giathanh_namnay()
        {
            $nam = date("Y");
            $query="SELECT nuoc.tenNuoc, giathanh.GiaNiemYet, datnuoc.soluong
                        FROM datnuoc 
                        INNER JOIN giathanh 
                        INNER JOIN nuoc
                        ON nuoc.idGiaThanh = giathanh.idGiaThanh && 
                        datnuoc.idNuoc = nuoc.idNuoc
                        WHERE datnuoc.ngay LIKE '%$nam%' && datnuoc.thanhtoan = 1
                        ";  
            // chọn những bàn đã thanh toán vì thanhtoan = 1 là đã tt, =0 là chưa tt
                        
           $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }


            // QUẦY

        function nuoc_canlam_quay()
        {
            // $query="SELECT * FROM datnuoc WHERE Xong_Don = 0";  
            // chọn những bàn đã thanh toán vì thanhtoan = 1 là đã tt, =0 là chưa tt
            $query = "SELECT * FROM datnuoc 
                    INNER JOIN soban 
                    INNER JOIN nuoc 
                    ON datnuoc.idSoban = soban.idSoban
                        && datnuoc.idNuoc = nuoc.idNuoc
                    WHERE Xong_Don = 0
                     ORDER BY idDatnuoc";
                        
           $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }



        // cập nhật QUẦY đã làm xong nước
        function update_lam_xongnuoc(){

            if(isset($_POST["idDatnuoc"])){ 
                // $tenLN = $_POST["tenLN"]
            $Xong_Don = filter_input(INPUT_POST, 'Xong_Don');
            $idDatnuoc = filter_input(INPUT_POST, 'idDatnuoc');

            $query="UPDATE datnuoc SET Xong_Don = '$Xong_Don'
                     WHERE idDatnuoc='$idDatnuoc'";  

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;
        }



// Nước đã làm trong hôm nay
        function nuoc_dalam_homnay()
        {
            $ngay = date("Y-m-d");
            // $query="SELECT * FROM datnuoc 
            //             WHERE ngay = '$ngay' && Xong_Don = 1
            //             || Xong_Don = 2 ";  

            $query = "SELECT * FROM datnuoc 
                    INNER JOIN soban 
                    INNER JOIN nuoc 
                    ON datnuoc.idSoban = soban.idSoban
                        && datnuoc.idNuoc = nuoc.idNuoc
                    WHERE ngay = '$ngay' && Xong_Don = 1 || Xong_Don = 2
                    ORDER BY idDatnuoc";


            // chọn những bàn đã thanh toán vì thanhtoan = 1 là đã tt, =0 là chưa tt

           $result = $this->api->query($query);
            $data = array();
            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }
            return $data;
        }





        function vidu2(){
                // $tenLN = $_POST["tenLN"]
            $idSoban = $_GET["idSoban"];

             $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet FROM soban LEFT JOIN datnuoc ON soban.idSoban = datnuoc.idSoban LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh 
            WHERE  datnuoc.idSoban = '$idSoban'
            ORDER BY soban.idSoban";


            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

        

        return $data;
        
    }





        function all_chat()
        {
            
            $query = "SELECT * FROM chat ORDER BY idchat DESC";

            $result = $this->api->query($query);

            $data = array();

            while ($row = $result->fetch_assoc()) {
               $data[] = $row;
            }

            return $data;
        }



        function insert_chat(){
            if(isset($_POST["idQuyen"])){ 
                // $tenLN = $_POST["tenLN"]
            $idQuyen = filter_input(INPUT_POST, 'idQuyen');
            $NoiDung = filter_input(INPUT_POST, 'NoiDung');


            $query = "INSERT INTO chat(idQuyen, NoiDung) 
            VALUES ('$idQuyen', '$NoiDung') ";

            $result = $this->api->query($query);

            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            }else{
                $data[] = array(
                'success'   =>  'no value'
            );
        }
        return $data;
        }

        // HẾT CHAT



        function Order_Xong()  
        {
        
        if(isset($_GET["idSoban"])){   

            $idSoban = filter_input(INPUT_GET, 'idSoban');

            // $query = "SELECT * FROM soban WHERE idSoban = '$idSoban' ";

            $query = "SELECT soban.idSoban, datnuoc.idDatnuoc,datnuoc.thanhtoan, datnuoc.Xong_Don, datnuoc.soluong, nuoc.tenNuoc, nuoc.idGiaThanh, giathanh.GiaNiemYet
                FROM soban 
                LEFT JOIN datnuoc ON  soban.idSoban = datnuoc.idSoban
                LEFT JOIN nuoc ON datnuoc.idNuoc = nuoc.idNuoc 
                LEFT JOIN giathanh ON nuoc.idGiaThanh = giathanh.idGiaThanh 
                WHERE soban.idSoban = '$idSoban' 
                ORDER BY soban.idSoban";

            $result = $this->api->query($query);
            
            if($result == true){
                $data[] = array(
                    'success'   =>  '1'
                );
            }
            else{
                $data[] = array(
                    'success'   =>  'lỗi'
                );
            }
            
        }else{
            $data[] = array(
                'success'   =>  'no value'
            );
        }
            return $data;
        
        }



       


      

    }
     
?>