<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database loaisanpham</h4>

      
      <div style="background-color: #e5e5e5; padding: 60px 50px 10px; color:gray;border-radius: 20px;">

        <table border="1" cellpadding="5">
          <tr>
            <td><h4>idLoaiNuoc </h4></td>
             <!-- có thể thay = $data['idUser'] là php echo "hello". $data['idUser']; -->
            <td><h4> &emsp;<?= $data['idLoaiNuoc'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>Tên loại nước </h4></td>
            <td><h4> &emsp;<?= $data['tenLN'];   ?> </h4></td>
          </tr>
          <!-- 
          <tr>
            <td><h4>Hình ảnh</h4></td>
            <td><h4> &emsp;<img src="./public_admin/image/loaisanpham<?= $data['hinhanh'] ?>"  height='90' > </h4></td>
          </tr> -->
          
        </table>


        <br>
        <br>
        <br>
      </div>
     

</div>

</div>