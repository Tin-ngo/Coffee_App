<div id="viewport">

<div class="container-fluid" id="noidung">


      <h1>THỐNG KÊ</h1>
      
      <br><br>
  
    
     <div class="col-sm-4">
          <div class="div1">
               <?php
               $sum_user = 0;
                      foreach( $data_user as $value )
                     {
                       $sum_user +=1;
                        }
                        echo "Tổng số nhân viên là: "."<br><span style='color:orange;'> $sum_user</span>";
                ?>
          </div>
     </div>

     <div class="col-sm-4">
          <div class="div1">
               <?php
               $sum_nuoc = 0;

                      foreach( $data_nuoc as $value )
                     {
                       $sum_nuoc +=1;
                        }
                        echo "Tổng số nước trong kho là: "."<br><span style='color:orange;'>$sum_nuoc</span>";
                      ?>
          </div>
     </div>
     <div class="col-sm-4">
          <div class="div1">
               <?php
               $sum_loainuoc = 0;

                      foreach( $data_loainuoc as $value )
                     {
                       $sum_loainuoc +=1;
                        }
                        echo "Số Loại nước trong kho là: "."<br><span style='color:orange;'>$sum_loainuoc</span>";
                      ?>
          </div>
     </div>
     <div class="col-sm-4">
          <div class="div1">
               <?php
               $sum_hoadon = 0;

                      foreach( $data_hoadon as $value )
                     {
                       $sum_hoadon +=1;
                        }
                        echo "Tổng hóa đơn là: "."<br><span style='color:orange;'>$sum_hoadon</span>";
                      ?>
          </div>
     </div>
     <div class="col-sm-4">
          <div class="div1">
                <?php
               $sum_giathanh = 0;

                      foreach( $data_giathanh as $value )
                     {
                       $sum_giathanh +=1;
                        }
                        echo "Số giá thành hiện có là: "."<br><span style='color:orange;'>$sum_giathanh</span>";
                      ?>
          </div>
     </div>
     <div class="col-sm-4">
          <div class="div1">
               <?php
               $sum_khuyenmai = 0;

                      foreach( $data_khuyenmai as $value )
                     {
                       $sum_khuyenmai +=1;
                        }
                        echo "Tổng các khuyến mãi là: "."<br><span style='color:orange;'>$sum_khuyenmai</span>";
                      ?>
          </div>
     </div>



</div>



</div>