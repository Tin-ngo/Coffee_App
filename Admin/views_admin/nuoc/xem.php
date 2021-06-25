<div id="viewport">

<div class="container-fluid row" id="noidung">
      <h4>Database nguoidung</h4>

      
      <div class="col-sm-6" style="background-color: #e5e5e5; padding: 60px 50px 10px; color:gray;border-radius: 20px; float:left;">

        <table border="1" cellpadding="5">
          <tr>
            <td><h4>idNuoc </h4></td>
             <!-- có thể thay = $data['idUser'] là php echo "hello". $data['idUser']; -->
            <td><h4> &emsp;<?= $data['idNuoc'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>tenNuoc </h4></td>
            <td><h4> &emsp;<?= $data['tenNuoc'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>id/ tenLoaiNuoc</h4></td>
            <td><h4> &emsp;<?= $data['idLoaiNuoc'];?>/ <?= $data['tenLN']; ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>Mô tả </h4></td>
            <td><h4> &emsp;<?= $data['mota'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>id/ Giá thành </h4></td>
            <td><h4> &emsp;<?= $data['idGiaThanh'];?>/ <?= number_format($data['GiaNiemYet']);?> vnd  </h4></td>
          </tr>
          
         <!--    <td><h4>Chức vụ </h4></td>
            <td><h4> &emsp;<?php if( $data['idQuyen'] == 1) echo "admin";  
                                  if($data['idQuyen'] == 0) echo "khách hàng";
                                  if($data['idQuyen'] == 2) echo "Người bán hàng"
                                   ?>  </h4></td>
          </tr> -->
        </table>


        <br>
        <br>
        <br>
      </div>


      <div class="col-sm-6" style="padding: 60px;">
        <h4> &emsp;<img src="public_admin/image/nuoc/<?= $data['hinhanh'];?>" alt=""></h4>
      </div>
     

</div>

</div>

<!--
        <h4>idUser:           <?= $data[idUser];   ?>         </h4>
        <h4>họ:               <?= $data[ho];   ?>             </h4>
        <h4>tên:              <?= $data[ten];   ?>            </h4>
        <h4>email:            <?= $data[email];   ?>          </h4>
        <h4>địa chỉ:          <?= $data[diachi];   ?>         </h4>
        <h4>giới tính:        <?= $data[gioitinh];   ?>       </h4>
        <h4>số điện thoại:    <?= $data[sodienthoai];   ?>    </h4>
        <h4>tên đăng nhập:    <?= $data[tendangnhap];   ?>    </h4>

        -->