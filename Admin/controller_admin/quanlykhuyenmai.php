<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/khuyenmai.php'); // đã gọi được rồi

    /**
     * 
     */
    class khuyenmaicontroller
    {
    	var $khuyenmai_model;

    	public function __construct()
    	{
    		$this->khuyenmai_model = new khuyenmai();
    	}

    	public function list()  
    	{
    		 if(isset($_POST['timkiem_km'])){
                $timkiem_km = $_POST['timkiem_km'];
                $data = $this->khuyenmai_model->timkiem_km($timkiem_km);
            }else{
                $data = $this->khuyenmai_model->all();
            }
            require_once('views_admin/index.php');
    	}

    	 public function details()    
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->khuyenmai_model->find($id);
            require_once('views_admin/index.php');
        } 

      
        

        public function update()       //đang          
       {
             $LoaiKM = filter_input(INPUT_POST, 'LoaiKM');
             $GiatriKM = filter_input(INPUT_POST, 'GiatriKM');
             $NgayBD = filter_input(INPUT_POST, 'NgayBD');
             $NgayKT = filter_input(INPUT_POST, 'NgayKT');

             $idKM = filter_input(INPUT_POST, 'idKM');

            $this->khuyenmai_model->update($idKM, $LoaiKM, $GiatriKM, $NgayBD, $NgayKT);

         }


         public function them()
         {
             $LoaiKM = filter_input(INPUT_POST, 'LoaiKM');
             $GiatriKM = filter_input(INPUT_POST, 'GiatriKM');
             $NgayBD = filter_input(INPUT_POST, 'NgayBD');
             $NgayKT = filter_input(INPUT_POST, 'NgayKT');

            $this->khuyenmai_model->insert($LoaiKM, $GiatriKM, $NgayBD, $NgayKT);
         }


         public function xoakhuyenmai()     //chưa
         {
            $id = isset($_GET['id']) ? $_GET['id'] : '1';

            $this->khuyenmai_model->delete($id);
         }










       }

       
    


?>