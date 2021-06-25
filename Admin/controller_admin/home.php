<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/trangchu.php'); // đã gọi được rồi

    /**
     * 
     */
    class trangchucontroller
    {
    	var $trangchu_model;

    	public function __construct()
    	{
    		$this->trangchu_model = new trangchu();
    	}

    	public function dem()  
    	{
    		$data_nuoc = $this->trangchu_model->all_nuoc(); //
    
    		$data_loainuoc = $this->trangchu_model->all_loainuoc(); //

    		$data_hoadon = $this->trangchu_model->all_hoadon(); //

    		$data_user = $this->trangchu_model->all_user(); //

    		$data_khuyenmai = $this->trangchu_model->all_khuyenmai();
            
            $data_giathanh = $this->trangchu_model->all_giathanh();


    		require_once('views_admin/index.php');
    	}


        public function delete_chat()  
        {
            $this->trangchu_model->delete_chat();
        }




       }

       
?>