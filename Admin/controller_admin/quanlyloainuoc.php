<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/loainuoc.php'); // đã gọi được rồi

    /**
     * 
     */
    class loainuoccontroller
    {
    	var $loainuoc_model;

    	public function __construct()
    	{
    		$this->loainuoc_model = new loainuoc();
    	}

    	public function list() 
    	{
    		if(isset($_POST['timkiem_lsp'])){
                $timkiem_lsp = $_POST['timkiem_lsp'];
                $data = $this->loainuoc_model->timkiem_lsp($timkiem_lsp);
            }else{
                $data = $this->loainuoc_model->all();
            }
            require_once('views_admin/index.php');
    	}
         public function them()  
         {
             $tenLN = filter_input(INPUT_POST, 'tenLN');

             // $hinhanh = $_FILES['hinhanh']['name'];
             // $hinhanh_tmp = $_FILES['hinhanh']['tmp_name'];
             // move_uploaded_file($hinhanh_tmp, './public_admin/image/loaisanpham/'.$hinhanh);

            $this->loainuoc_model->insert($tenLN);
         }

    	 public function details() 
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->loainuoc_model->find($id);
            require_once('views_admin/index.php');
        } 

      
        

        

        public function update()                    
       {
             $idLoaiNuoc = filter_input(INPUT_POST, 'idLoaiNuoc');
             $tenLN = filter_input(INPUT_POST, 'tenLN');

             // $hinhanh = $_FILES['hinhanh']['name'];
             // $hinhanh_tmp = $_FILES['hinhanh']['tmp_name'];
             // move_uploaded_file($hinhanh_tmp, './public_admin/image/loaisanpham/'.$hinhanh);

            $this->loainuoc_model->update($idLoaiNuoc, $tenLN);

         }


        


         public function xoaloainuoc()     // đang  
         {
            $id = isset($_GET['id']) ? $_GET['id'] : '1';

            $this->loainuoc_model->delete($id);
         }










       }

       
    


?>