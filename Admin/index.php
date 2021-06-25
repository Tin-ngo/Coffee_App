<?php

// Index này gọi tới controller
if(isset($_GET['idSoban'])){
        // chỉ hiển thị số bàn không dùng inner join 
 
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->vidu2();

    }



// Index này gọi tới controller
    session_start();
    $act = isset($_GET['action']) ? $_GET['action'] : "trangchu";

    switch ($act) {

        // Phần API
        case 'API_NUOC':  //c
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_nuoc();
             break;
        case 'API_LOAINUOC':  //r
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_loainuoc();
             break;

        case 'insert_loainuoc':   //r (chu y phan duong dan)
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->insert_loainuoc();
             break;

        case 'API_USER':  
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->dangnhap_user();
             break;

        //PHẦN THÊM

        case 'LAY_SOBAN':  
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->lay_soban();
             break;

        case 'LAY_DATNUOC':  
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->lay_datnuoc();
             break;


        // HẾT PHẦN THÊM
        case 'API_SOBAN':  
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_soban();
             break;


        case 'insert_datnuoc':   //r (chu y phan duong dan)
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->insert_datnuoc();
             break;

        case 'delete_datnuoc':   //r (chu y phan duong dan)
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->delete_datnuoc();
             break;


        case 'API_datnuoc':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_datnuoc_i();  // i là inner join
            break;


        case 'thanhtoan_datnuoc':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->update_datnuoc(); 
            break;


        case 'update_xongnuoc':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->update_xongnuoc();
            break;


        case 'HOMNAY_nuoc_giathanh':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_nuoc_giathanh_homnay();
            break;

        case 'THANGNAY_nuoc_giathanh':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_nuoc_giathanh_thangnay();
            break;

        case 'NAMNAY_nuoc_giathanh':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->list_nuoc_giathanh_namnay();
            break;


        // QUẦY

        case 'NUOC_Canlam':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->nuoc_canlam_quay();
            break;
           

        case 'update_lam_xongnuoc':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->update_lam_xongnuoc();
            break;
            

        case 'nuoc_dalam_homnay':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->nuoc_dalam_homnay();
            break;




// CHAT

        case 'API_CHAT':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->all_chat();
            break;


        case 'INSERT_CHAT':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->insert_chat();
            break;

//HẾT CHAT

        case 'API_SOBAN_Order':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->soban_order();
            break;






// Đang làm phần  SELECT  WHERE   - LẤy OBJ_BAN
        case 'Order_Xong':
            require_once('controller_admin/API_CONTROLLER.php');
            $controller_taikhoanobj = new API_CONTROLLER();
            $controller_taikhoanobj->Order_Xong();
            break;


        















        // Phần website
        case 'trangchu':
            require_once('controller_admin/home.php');
            $controller_taikhoanobj = new trangchucontroller();
             $controller_taikhoanobj->dem();
            break;
        
        case 'delete_chat':
            require_once('controller_admin/home.php');
            $controller_taikhoanobj = new trangchucontroller();
             $controller_taikhoanobj->delete_chat();
            break;


        case 'nuoc':           // đang sửa
            require_once('controller_admin/quanlynuoc.php');
            $nuocController = new nuocController();
            $nuocController->list();
            break;
        case 'xemnuoc':
           require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->details();
            break; 
        case 'edit':    // UPDATE giao diện
            require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->edit();
            break;
        case 'sua_xl':   //UPDATE xử lý
            require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->update();
            break;
        case 'them_giaodien':
            require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->list_loainuoc();
            break;
        case 'them': 
            require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->them();
            break;
        case 'xoanuoc':
            require_once('controller_admin/quanlynuoc.php');
            $controller_taikhoanobj = new nuoccontroller();
            $controller_taikhoanobj->xoanuoc();
            break;
        // case 'phanquyen':
        //     require_once('controller_admin/quanlytaikhoan.php');
        //     $controller_taikhoanobj = new nguoidungcontroller();
        //     $controller_taikhoanobj->phanquyen();
        //     break;



              //loại sản phẩm

        case 'loainuoc':
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->list();
            break;
        case 'themloainuoc':
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->them();
            break;
        case 'themloainuoc_giaodien':
            require_once('views_admin/index.php');
            break;
        case 'xemloainuoc':
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->details();
            break;
        case 'sualoainuoc':
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->details();
            break;
        case 'sualoainuoc_xl':
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->update();
            break;
        case 'xoaloainuoc': 
            require_once('controller_admin/quanlyloainuoc.php');
            $controller_taikhoanobj = new loainuoccontroller();
            $controller_taikhoanobj->xoaloainuoc();
            break;


                  //user

        case 'user':
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->list();
            break;
        case 'themuser_giaodien':
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->all_phanquyen();
            break;
        case 'themuser':
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->them();
            break;
        case 'suauser': 
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->details();
            break;
        case 'suauser_xl': 
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->update();
            break;
        
        case 'xoauser':
            require_once('controller_admin/quanlyuser.php');
            $controller_taikhoanobj = new usercontroller();
            $controller_taikhoanobj->xoauser();
            break;





            //hóa đơn

        case 'hoadon': 
            require_once('controller_admin/duyethoadon.php');
            $controller_taikhoanobj = new hoadoncontroller();
            $controller_taikhoanobj->list_hoadon();
            break;
        case 'xoahoadon':
            require_once('controller_admin/duyethoadon.php');
            $controller_taikhoanobj = new hoadoncontroller();
            $controller_taikhoanobj->xoahoadon();
            break;
        case 'xemhoadon':
            require_once('controller_admin/duyethoadon.php');
            $controller_taikhoanobj = new hoadoncontroller();
            $controller_taikhoanobj->chitiet_hoadon();
            break;

         case 'giathanh':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->list();
            break;
        case 'them_giathanh_giaodien':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->all_km();
            break;
        case 'them_giathanh': 
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->them();
            break;



        case 'xemgiathanh':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->details();
            break;
        case 'suagiathanh':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->details();
            break; 

        case 'suagiathanh_xl':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->update();
            break;

        case 'xoagiathanh':
            require_once('controller_admin/quanlygiathanh.php');
            $controller_taikhoanobj = new giathanhcontroller();
            $controller_taikhoanobj->xoagiathanh();
            break;

      
      

        //khuyến mãi

        case 'khuyenmai':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->list();
            break;
        case 'themkhuyenmai_giaodien':
            require_once('views_admin/index.php');
             break;
        case 'themkhuyenmai_xl':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->them();
             break;
             
        case 'xemkhuyenmai':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->details();
            break;
        case 'suakhuyenmai_giaodien':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->details();
            break;
        case 'suakhuyenmai_xl':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->update();
            break;

        

        case 'xoakhuyenmai':
            require_once('controller_admin/quanlykhuyenmai.php');
            $controller_taikhoanobj = new khuyenmaicontroller();
            $controller_taikhoanobj->xoakhuyenmai();
             break;

        

        default:
            require_once('controller_admin/home.php');
            break;
    }
?>