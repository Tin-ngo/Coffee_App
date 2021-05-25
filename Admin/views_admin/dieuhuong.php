<?php
    $action = isset($_GET['action']) ? $_GET['action'] : "trangchu";    //   $_GET['']     lấy thông tin trên thanh địa chỉ

    switch ($action) {
    	case 'trangchu':
    		require_once('trangchu/trangchu.php');
    		break;
        case 'nuoc':
            require_once('nuoc/Quanlynuoc.php');
            break;
        case 'xemnuoc':
            require_once('nuoc/xem.php');
            break;
        case 'edit':
            require_once('nuoc/sua.php');
            break;
        case 'them_giaodien':
            require_once('nuoc/them.php');
            break;


    
        case 'loainuoc':
            require_once('loainuoc/quanlyloainuoc.php');
            break;
        case 'themloainuoc_giaodien':
            require_once('loainuoc/them.php');
            break;
        case 'xemloainuoc':
            require_once('loainuoc/xem.php');
            break;
        case 'sualoainuoc':
            require_once('loainuoc/sua.php');
            break;
        case 'them_soluong_giaodien':
            require_once('sanpham/them_soluong.php');
            break;


            //user
            
        case 'user':
            require_once('user/quanlyuser.php');
            break;
        case 'suauser':
            require_once('user/sua.php');
            break;
        case 'themuser_giaodien':
            require_once('user/them.php');
            break;


            //  hóa đơn
            
        case 'hoadon':
            require_once('hoadon/quanlyhoadon.php');
            break;
        case 'xemhoadon':
            require_once('hoadon/xem.php');
            break;



            // giá thành

       case 'giathanh':
            require_once('giathanh/quanlygiathanh.php');
            break;
        case 'them_giathanh_giaodien':
            require_once('giathanh/them.php');
            break;
        case 'xemgiathanh':
            require_once('giathanh/xem.php');
            break;
        case 'suagiathanh':
            require_once('giathanh/sua.php');
            break;


    // ở trên xong rồi




            



   

    

    //khuyến mãi
        case 'khuyenmai':
            require_once('khuyenmai/quanlykhuyenmai.php');
            break;
        case 'suakhuyenmai_giaodien':
            require_once('khuyenmai/sua.php');
            break;
        case 'themkhuyenmai_giaodien':
            require_once('khuyenmai/them.php');
            break;
        case 'xemkhuyenmai':
            require_once('khuyenmai/xem.php');
            break;




    	default:
    		require_once('trangchu/trangchu.php');
    		break;
    }
?>