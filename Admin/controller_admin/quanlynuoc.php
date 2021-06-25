<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/nuoc.php');

    /**
     * 
     */
    class nuocController
    {
    	var $nuoc_controller;  //$nguoidung_model;

    	public function __construct()
    	{
    		$this->nuoc_controller = new nuoc();
    	}

    	public function list() 
    	{
            if(isset($_POST['timkiem'])){
                $timkiem = $_POST['timkiem'];
                $data = $this->nuoc_controller->timkiem($timkiem);
            }else{
                $data = $this->nuoc_controller->all();
            }
    		require_once('views_admin/index.php');
    	}



        public function list_loainuoc() 
        {
            $data_loainuoc = $this->nuoc_controller->All_LoaiNuoc();
            $data_giathanh = $this->nuoc_controller->ALl_GiaThanh();
            require_once('views_admin/index.php');
        }




        public function details()  // hàm hiển thị chi tiết thông tin của một người dùng được chọn bởi $id
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->nuoc_controller->find($id);
            require_once('views_admin/index.php');
        }

        public function edit()
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->nuoc_controller->find($id);

            $data_loainuoc = $this->nuoc_controller->All_LoaiNuoc();
            $data_giathanh = $this->nuoc_controller->ALl_GiaThanh();
            
            require_once('views_admin/index.php');
        }

       public function update()
       {
            $hinhanh = $_FILES['hinhanh']['name'];
            $hinhanh_tmp = $_FILES['hinhanh']['tmp_name'];
            move_uploaded_file($hinhanh_tmp, './public_admin/image/nuoc/'.$hinhanh);

            $idLoaiNuoc =filter_input(INPUT_POST, 'idLoaiNuoc');
            $tenNuoc =filter_input(INPUT_POST, 'tenNuoc');
            $mota =filter_input(INPUT_POST, 'mota');
            $idGiaThanh =filter_input(INPUT_POST, 'idGiaThanh');
            $idNuoc = filter_input(INPUT_POST, 'idNuoc');

            $this->nuoc_controller->update($idNuoc, $idLoaiNuoc, $tenNuoc, $hinhanh, $mota, $idGiaThanh);

         }


         public function them()
         {
            $hinhanh = $_FILES['hinhanh']['name'];
            $hinhanh_tmp = $_FILES['hinhanh']['tmp_name'];
            move_uploaded_file($hinhanh_tmp, './public_admin/image/nuoc/'.$hinhanh);


            $idLoaiNuoc =filter_input(INPUT_POST, 'idLoaiNuoc');
            $tenNuoc =filter_input(INPUT_POST, 'tenNuoc');
            $ngaynhap =filter_input(INPUT_POST, 'ngaynhap');
            $mota =filter_input(INPUT_POST, 'mota');
            $idGiaThanh =filter_input(INPUT_POST, 'idGiaThanh');

            $this->nuoc_controller->insert($idLoaiNuoc, $tenNuoc, $hinhanh, $mota, $idGiaThanh);
         }


         public function xoanuoc()
         {
            $id = isset($_GET['id']) ? $_GET['id'] : '';

            $this->nuoc_controller->delete($id);
         }

         // public function phanquyen()
         // {
         //    $id = isset($_GET['id']) ? $_GET['id'] : '';

         //    $quyen = $_GET['quyen'];

         //    $this->nuoc_controller->phanquyen($id, $quyen);
         // }







       }

       
    


?>