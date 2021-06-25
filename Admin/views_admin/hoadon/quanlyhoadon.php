<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database datnuoc</h4>

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
                  <th class="theadd">ngày</th>
                  <th class="theadd">số bàn</th>
                  <th class="theadd">id Nước</th>
                  <th class="theadd">Tên Nước</th>
                  <th class="theadd">Số lượng</th>
                  <th class="theadd">Giá niêm yết</th>
                  <th class="theadd">Tổng tiền</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
            <?php foreach ($data as $value) { ?>
                 
           
              <tr>
                  <td scope="row"><?= $value['idDatnuoc'] ?></td>
                 <td><?= $value['ngay'] ?>  </td>
                  <td><?= $value['idSoban'] ?></td>
                  <td><?= $value['idNuoc'] ?></td>
                  <td><?= $value['tenNuoc'] ?></td>
                  <td><?= $value['soluong'] ?></td>
                  <td><?= number_format($value['GiaNiemYet']) ?> vnd</td>
                  <td><?= number_format($value['GiaNiemYet']*$value['soluong']) ?> vnd</td>
                  
                  <td>
                   
                
                    <a href="?action=xoahoadon&id=<?= $value['idDatnuoc'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger" title="Xóa">
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



