package com.example.coffeapp

// dùng tring class Phucvuactivity để hiển thị danh sách các bàn trong chỗ Order nước

//class OBJ_Ban(var idSoban: Int, var idDatnuoc:Int, var thanhtoan:Int, var Xong_Don:Int, var hinhanh : Int) {}
////}  bản2

//class OBJ_Ban(var idSoban: Int,var idDatnuoc: Int,  var tenNuoc:String) {}
////}  bản thử


//class OBJ_Ban(var idSoban: Int, var idDatnuoc:Int, var thanhtoan:Int, var Xong_Don:Int,
//              var soluong:Int, var idGiaThanh:Int, var GiaNiemYet: Double,
//              var hinhanh : Int) {}
class OBJ_Ban(var idSoban: Int, var idDatnuoc:Int, var thanhtoan:Int, var Xong_Don:Int,
              var soluong:Int,var tenNuoc:String?, var idGiaThanh:Int, var GiaNiemYet: Double,
              var hinhanh : Int) {}
// chỗ tên nước đặt dấu ? cho phép null
//} bản 3