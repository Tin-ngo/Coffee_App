<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database Nuoc</h4>
      <a class="pull-left themmoi" href="?action=them_giaodien"> Thêm mới</a>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
        <form method="POST" action="?action=taikhoan">
          <input type="text" placeholder="Search By Name" name="timkiem">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=taikhoan" style="font-size: 15px;">All</a>
        </form>

      </div>

      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>Mã Nước</th>
                  <th class="theadd">Mã Loại Nước</th>
                  <th class="theadd">Tên Nước</th>
                  <th class="theadd">Ảnh</th>
                  <th class="theadd">Mô Tả</th>
                  <th class="theadd">id Giá</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
              <?php foreach ($data as $row) { ?>
              <tr>
                  <td scope="row"><?= $row['idNuoc'] ?></td>
                  <td><?= $row['idLoaiNuoc']?></td>
                  <td><?= $row['tenNuoc'] ?></td>
                  <td><?= $row['hinhanh'] ?></td>
                  <td><?= $row['mota'] ?></td>
                  <td><?= $row['idGiaThanh'] ?></td>
                  <td>
                      <!-- để ý dấu bằng trong href -->
                      <a href="?action=xemnuoc&id=<?= $row['idNuoc'] ?>" type="button" class="btn btn-light">Chi tiết</a>

                      <a href="?action=edit&id=<?= $row['idNuoc'] ?>" type="button" class="btn  btn-light">Sửa</a>
                      <a href="?action=xoanuoc&id=<?= $row['idNuoc'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger"title="Xóa người dùng">
                        <i class="fa fa-user-times"></i></a>
                        <br>
                        <!-- phân quyền -->
                        
   
      
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



