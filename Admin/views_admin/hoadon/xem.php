<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database hoadon</h4>

      
      <div style="background-color: #e5e5e5; padding: 60px 50px 10px; color:gray;border-radius: 20px;">

        <table border="1" cellpadding="5">
          <tr>
            <td><h4>id hóa đơn </h4></td>
             <!-- có thể thay = $data['idUser'] là php echo "hello". $data['idUser']; -->
            <td><h4> &emsp;<?= $data['idHoaDon'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>idNuoc</h4></td>
            <td><h4> &emsp;<?= $data['idNuoc'];   ?>   </h4></td>
          </tr>
          <tr>
            <td><h4>Số Lượng</h4></td>
            <td><h4> &emsp;<?= $data['Soluong'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>Ngày</h4></td>
            <td><h4> &emsp;<?= $data['Ngay'];   ?></h4></td>
          </tr>
          
          
        </table>


        <br>
        <br>
        <br>
      </div>
     

</div>

</div>