<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/giathanh.php'); // đã gọi được rồi

    /**
     * 
     */
    class giathanhcontroller
    {
        var $giathanh_model;

        public function __construct()
        {
            $this->giathanh_model = new giathanh();
        }

        public function list()   // hàm hiển thị tất cả sản phẩm trong database 
        {

             if(isset($_POST['timkiem'])){
                $timkiem = $_POST['timkiem'];
                $data = $this->giathanh_model->timkiem($timkiem);
            }else{
                $data = $this->giathanh_model->all();
            }
            require_once('views_admin/index.php');
        }




        public function all_km()   // hàm hiển thị tất cả sản phẩm trong database 
        {
            $data_km = $this->giathanh_model->all_km();
            require_once('views_admin/index.php');
        }






         public function details()  // hàm hiển thị chi tiết thông tin của một sản phẩm được chọn bởi $id
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->giathanh_model->find($id);
            $data_km = $this->giathanh_model->all_km();
            require_once('views_admin/index.php');
        } 

      
        

        public function update()                            
       {

            $idGiaThanh = filter_input(INPUT_POST, 'idGiaThanh');
            $GiaNiemYet = filter_input(INPUT_POST, 'GiaNiemYet');
            $idKM = filter_input(INPUT_POST, 'idKM');
           
            

            $this->giathanh_model->update($idGiaThanh, $GiaNiemYet, $idKM);

         }


         public function them()  
         {
            $idGiaThanh =filter_input(INPUT_POST, 'idGiaThanh');

             $GiaNiemYet =filter_input(INPUT_POST, 'GiaNiemYet');


            $idKM =filter_input(INPUT_POST, 'idKM');
            
             $this->giathanh_model->insert($GiaNiemYet, $idKM);


         }


         public function xoagiathanh()    
         {
            $id = isset($_GET['id']) ? $_GET['id'] : '1';

            $this->giathanh_model->delete($id);
         }



        




         }

?>