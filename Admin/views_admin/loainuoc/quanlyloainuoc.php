<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database loainuoc</h4>
      <a class="pull-left themmoi" href="?action=themloainuoc_giaodien"> Thêm mới</a>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
          <form method="POST" action="?action=loainuoc">
          <input type="text" placeholder="Search By Name" name="timkiem_lsp">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=loainuoc" style="font-size: 15px;">All</a>
        </form>
      </div>

      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>idLoaiNuoc</th>
                  <th class="theadd">Tên loại Nước</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
            <?php foreach ($data as $value) { ?>
                 
           
              <tr>
                  <td scope="row"><?= $value['idLoaiNuoc'] ?></td>
                 <td><?= $value['tenLN'] ?></td>
                 
                  <td>
                      <!-- để ý dấu bằng trong href -->
                      <a href="?action=xemloainuoc&id=<?= $value['idLoaiNuoc'] ?>" type="button" class="btn btn-light">Chi tiết</a>

                      <a href="?action=sualoainuoc&id=<?= $value['idLoaiNuoc'] ?>" type="button" class="btn  btn-light">Sửa</a>
                      <a href="?action=xoaloainuoc&id=<?= $value['idLoaiNuoc'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger"title="Xóa ">
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



