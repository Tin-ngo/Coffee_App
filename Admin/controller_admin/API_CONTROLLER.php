<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/API_MODEL.php'); // đã gọi được rồi

    /**
     * 
     */
    class API_CONTROLLER
    {
    	var $api_model;

    	public function __construct()
    	{
    		$this->api_model = new API();
    	}

    	public function list_nuoc()  // chua
    	{
            $data = $this->api_model->all_nuoc();
            
            echo json_encode($data);
    	}

        public function list_loainuoc() //r
        {
            $data = $this->api_model->all_loainuoc();
            
            echo json_encode($data);
        }

        public function insert_loainuoc() //r
        {

            $data = $this->api_model->insert_loainuoc();
            echo json_encode($data);
            
        }

        public function dangnhap_user() // r
        {

            $data = $this->api_model->all_user();
            echo json_encode($data);
            
        }

        //PHẦN THÊM

         public function lay_soban() // r
        {
            $data = $this->api_model->lay_soban();
            echo json_encode($data);
        }

         public function lay_datnuoc() // r
        {
            $data = $this->api_model->lay_datnuoc();
            echo json_encode($data);
        }


        //HÉT PHẦN THÊM


        public function list_soban() // r
        {

            $data = $this->api_model->all_soban();
            echo json_encode($data);
            
        }


         public function insert_datnuoc() //r
        {
            $data = $this->api_model->insert_datnuoc();
            echo json_encode($data);
        }

        public function delete_datnuoc()
        {
            $data = $this->api_model->delete_datnuoc();
            echo json_encode($data);
        }

        public function list_datnuoc_i()   // hiển thị trong bàn dã order
        {
            $data = $this->api_model->all_datnuoc_innerjoin();
            echo json_encode($data);
        }


        public function update_datnuoc()   // hiển thị trong bàn dã order
        {
            $data = $this->api_model->update_datnuoc();
            echo json_encode($data);
        }

        public function update_xongnuoc()   // hiển thị trong bàn dã order
        {
            $data = $this->api_model->update_xongnuoc();
            echo json_encode($data);
        }

        

        public function list_nuoc_giathanh()   // hiển thị inner join nước và giá thành
        {
            $data = $this->api_model->all_nuoc_giathanh();
            echo json_encode($data);
        }

// hiển thị inner join nước và giá thành
        public function list_nuoc_giathanh_homnay()
        {
            $data = $this->api_model->loai_nuoc_giathanh_homnay();
            echo json_encode($data);
        }


        public function list_nuoc_giathanh_thangnay()
        {
            $data = $this->api_model->loai_nuoc_giathanh_thangnay();
            echo json_encode($data);
        }


        public function list_nuoc_giathanh_namnay()
        {
            $data = $this->api_model->loai_nuoc_giathanh_namnay();
            echo json_encode($data);
        }


        //QUẦY

        public function nuoc_canlam_quay()
        {
            $data = $this->api_model->nuoc_canlam_quay();
            echo json_encode($data);
        }


        public function update_lam_xongnuoc()
        {
            $data = $this->api_model->update_lam_xongnuoc();
            echo json_encode($data);
        }


        public function nuoc_dalam_homnay()
        {
            $data = $this->api_model->nuoc_dalam_homnay();
            echo json_encode($data);
        }




        public function vidu2()
        {
            $data = $this->api_model->vidu2();
            echo json_encode($data);
        }



         public function soban_order()
        {
            $data = $this->api_model->soban_order();
            echo json_encode($data);
        }







        // CHAT



        public function all_chat()
        {
            $data = $this->api_model->all_chat();
            echo json_encode($data);
        }


         public function insert_chat()
        {
            $data = $this->api_model->insert_chat();
            echo json_encode($data);
        }


        // hết chát



         public function Order_Xong() //r
        {
            $data = $this->api_model->Order_Xong();
            echo json_encode($data);
        }


        


       }

?>