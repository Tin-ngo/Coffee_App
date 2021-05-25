<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database hoadon</h4>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
          <form method="POST" action="?action=hoadon">
          <input type="text" placeholder="Search By idUser" name="timkiem_hd">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=hoadon" style="font-size: 15px;">All</a>
        </form>
      </div>

      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>idhoadon</th>
                  <th class="theadd">idNuoc</th>
                  <th class="theadd">Soluong</th>
                  <th class="theadd">Ngày</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
            <?php foreach ($data as $value) { ?>
                 
           
              <tr>
                  <td scope="row"><?= $value['idHoaDon'] ?></td>
                 <td><?= $value['idNuoc'] ?>  </td>
                  <td><?= $value['Soluong'] ?></td>
                  <td><?= $value['Ngay'] ?></td>
                  
                  <td>
                      <!-- để ý dấu bằng trong href -->
                       <a href="?action=xemhoadon&id=<?= $value['idHoaDon'] ?>&idNuoc=<?= $value['idNuoc'] ?>" type="button" class="btn btn-light">Chi tiết</a>
<!-- 
                    <a href="?action=duyethoadon&id=<?= $value['idhoadon'] ?>&idSP=<?= $value['idSP'] ?>&soluongmua=<?php echo $value['soluongmua'] ?>" type="button" class="btn btn-primary">Duyệt hóa đơn</a> -->
                
                    <a href="?action=xoahoadon&id=<?= $value['idHoaDon'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger" title="Xóa">
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



