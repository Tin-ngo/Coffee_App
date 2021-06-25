<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database GiaThanh</h4>
      
      <a class="pull-left themmoi" href="?action=them_giathanh_giaodien"> Thêm mới</a>

      <div class="search_box pull-right" style="margin-right: 50px; margin-top: 0px;">
          <form method="POST" action="?action=giathanh">
          <input type="text" placeholder="Search By Giá" name="timkiem">&ensp;
          <button type="submit"><i class="fa fa-search"></i></button>
          <a href="?action=giathanh" style="font-size: 15px;">All </a>
        </form>
      </div>

      <br>
      <br>
   
      <table border="3" cellpadding="10" style="font-size: 15px;">
          
          <thead>
               <tr>
                  <th>ID Giá Thành</th>
                  <th class="theadd">Giá niêm yết</th>
                  <th class="theadd">id/ Khuyến mãi / giá trị</th>
                  <th>Hành động</th>
               </tr>
          </thead>
          <tbody>
            <?php foreach ($data as $value) { ?>
                 
           
              <tr>
                  <td scope="row"><?= $value['idGiaThanh'] ?></td>
                 <td><?= number_format($value['GiaNiemYet']) ?> vnd</td>
                  <td><?= $value['idKM']?>/ <?= $value['LoaiKM']?>/ <?= number_format($value['GiatriKM'])?> vnd</td>
                  <td>
                      <!-- để ý dấu bằng  trong href -->
                      <a href="?action=xemgiathanh&id=<?= $value['idGiaThanh'] ?>" type="button" class="btn btn-light">Chi tiết</a>
                      
                      <a href="?action=suagiathanh&id=<?= $value['idGiaThanh'] ?>" type="button" class="btn  btn-light">Sửa</a> 
                      <a href="?action=xoagiathanh&id=<?= $value['idGiaThanh'] ?>" onclick="return confirm('Bạn có thật sự muốn xóa ?');" type="button" class="btn btn-danger"title="Xóa  ">
                        <i class="fa fa-times"></i></a>
   


                  </td> 
              </tr>

              <?php } ?>
             
          </tbody>
      </table>
  <!--
                       <ul class="pagination">
                            <li class="active"><a href="">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href="">&raquo;</a></li>
                        </ul>
      -->

      <br>
      <br>
      <br>
     

</div>

</div>


<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}
</script>



