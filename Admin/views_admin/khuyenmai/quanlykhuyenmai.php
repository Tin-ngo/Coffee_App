<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database khuyenmai</h4>
      <a class="pull-left themmoi" href="?action=themkhuyenmai_giaodien"> Thêm mới</a>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
        <form method="POST" action="?action=khuyenmai">
          <input type="text" placeholder="Search By loại KM" name="timkiem_km">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=khuyenmai" style="font-size: 15px;">All</a>
        </form>
      </div>

      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>idKM</th>
                  <th class="theadd">Loại KM</th>
                  <th class="theadd">Giá trị KM(%)</th>
                  <th class="theadd">Ngày bắt đầu</th>
                  <th class="theadd">Ngày kết thúc</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
            <?php foreach ($data as $value) { ?>
                 
           
              <tr>
                  <td scope="row"><?= $value['idKM'] ?></td>
                 <td><?= $value['LoaiKM'] ?></td>
                  <td><?= $value['GiatriKM'] ?></td>
                  <td><?= $value['NgayBD'] ?></td>
                  <td><?= $value['NgayKT'] ?></td>
                  <td>
                      <!-- để ý dấu bằng trong href -->
                      <a href="?action=xemkhuyenmai&id=<?= $value['idKM'] ?>" type="button" class="btn btn-light">Chi tiết</a>

                      <a href="?action=suakhuyenmai_giaodien&id=<?= $value['idKM'] ?>" type="button" class="btn  btn-light">Sửa</a>
                      <a href="?action=xoakhuyenmai&id=<?= $value['idKM'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger"title="Xóa  ">
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



