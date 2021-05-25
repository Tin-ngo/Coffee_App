<?php      
     // CONTROLLER DÙNG ĐỂ GỌI CÁC HÀM TRONG MODEL


    require_once('./model_admin/user.php'); // đã gọi được rồi

    /**
     * 
     */
    class usercontroller
    {
    	var $user_model;

    	public function __construct()
    	{
    		$this->user_model = new user();
    	}

    	public function list()  
    	{
    		if(isset($_POST['timkiem_bn'])){
                $timkiem_bn = $_POST['timkiem_bn'];
                $data = $this->user_model->timkiem_bn($timkiem_bn);
            }else{
                $data = $this->user_model->all();
            }
            require_once('views_admin/index.php');
    	}

        public function details() 
        {
            $id = isset($_GET['id']) ? $_GET['id'] : 1;
            $data = $this->user_model->find($id);
            require_once('views_admin/index.php');
        }

       public function update()
       {
            $idQuyen =filter_input(INPUT_POST, 'idQuyen');
            $ho =filter_input(INPUT_POST, 'ho');
            $ten =filter_input(INPUT_POST, 'ten');
            $email =filter_input(INPUT_POST, 'email');
            $diachi =filter_input(INPUT_POST, 'diachi');
            $gioitinh =filter_input(INPUT_POST, 'gioitinh');
            $sodienthoai = filter_input(INPUT_POST, 'sodienthoai');
            $tendangnhap = filter_input(INPUT_POST, 'tendangnhap');
            $matkhau = filter_input(INPUT_POST, 'matkhau');

            $idUser = filter_input(INPUT_POST, 'iduser');

            $this->user_model->update($idUser, $idQuyen, $ho, $ten, $email, $diachi, $gioitinh, $sodienthoai, $tendangnhap, $matkhau);

         }


         public function them()
         {
            // $idbanner = filter_input(INPUT_POST, 'idbanner');
            //  $anhbanner = $_FILES['anhbanner']['name'];
            //  $anhbanner_tmp = $_FILES['anhbanner']['tmp_name'];
            //  move_uploaded_file($anhbanner_tmp, './public_admin/image/banner/'.$anhbanner);

            $idQuyen =filter_input(INPUT_POST, 'idQuyen');
            $ho =filter_input(INPUT_POST, 'ho');
            $ten =filter_input(INPUT_POST, 'ten');
            $email =filter_input(INPUT_POST, 'email');
            $diachi =filter_input(INPUT_POST, 'diachi');
            $gioitinh =filter_input(INPUT_POST, 'gioitinh');
            $sodienthoai = filter_input(INPUT_POST, 'sodienthoai');
            $tendangnhap = filter_input(INPUT_POST, 'tendangnhap');
            $matkhau = filter_input(INPUT_POST, 'matkhau');

            $this->user_model->insert($idQuyen, $ho, $ten, $email, $diachi, $gioitinh, $sodienthoai, $tendangnhap, $matkhau);
         }


         public function xoauser() 
         {
            $id = isset($_GET['id']) ? $_GET['id'] : '1';

            $this->user_model->delete($id);
         }







       }

       
    


?>