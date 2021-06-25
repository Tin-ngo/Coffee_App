<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database User</h4>
      <a class="pull-left themmoi" href="?action=themuser_giaodien"> Thêm mới</a>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
           <form method="POST" action="?action=user">
          <input type="text" placeholder="Search By Name" name="timkiem_bn">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=user" style="font-size: 15px;">All</a>
        </form>
      </div>

      <br>
      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>idUser</th>
                  <th>id/ Quyền</th>
                  <th>ho</th>
                  <th>ten</th>
                  <th>email</th>
                  <th>diachi</th>
                  <th>gioitinh</th>
                  <th>sdt</th>
                  <th>ten Nhân viên</th>
                  <th>matkhau</th>
                  <th>hành động</th>
               </tr>
          </thead>
          <tbody>
              <?php foreach ($data as $row) { ?>
              <tr>
                  <td scope="row"><?= $row['idUser'] ?></td>
                 <td><?= $row['idQuyen'] ?>/ <?= $row['tenquyen'] ?></td>
                 <td><?= $row['ho'] ?></td>
                 <td><?= $row['ten'] ?></td>
                 <td><?= $row['email'] ?></td>
                 <td><?= $row['diachi'] ?></td>
                 <td>
                      <?php 
                      $gioitinh = '';
                            if($row['gioitinh'] == 0)
                            { 
                              $gioitinh = 'Nam';
                            }
                            if ($row['gioitinh'] == 1) {
                              $gioitinh = 'Nữ';
                            }
                            if ($row['gioitinh'] != 1 && $row['gioitinh'] != 0) {
                              $gioitinh = 'Khác';
                            }
                            echo $gioitinh;
                        ?>
                  </td>
                 <td><?= $row['sodienthoai'] ?></td>
                 <td><?= $row['tendangnhap'] ?></td>
                 <td><?= $row['matkhau'] ?></td>
                  <td>
                      <!-- để ý dấu bằng trong href -->
                      <a href="?action=suauser&id=<?= $row['idUser'] ?>" type="button" class="btn  btn-light">Sửa</a>
                      <a href="?action=xoauser&id=<?= $row['idUser'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger"title="Xóa">
                        <i class="fa fa-times"></i></a>
       
        
                  </td> 
              </tr>
              <?php } ?>
          </tbody>
      </table>

      <br>
      <br>
      <br>
     

</div>

</div>