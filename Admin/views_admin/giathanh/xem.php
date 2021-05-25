<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database Giá Thành</h4>

      
      <div style="background-color: #e5e5e5; padding: 60px 50px 10px; color:gray;border-radius: 20px;min-height: 630px;">

        <table border="1" cellpadding="5">
          <tr>
            <td><h4>idGia Thanh </h4></td>
             <!-- có thể thay = $data['idUser'] là php echo "hello". $data['idUser']; -->
            <td><h4><?= $data['idGiaThanh'];   ?>  </h4></td>
          </tr>
          <tr>
            <td><h4>Giá niêm Yết </h4></td>
            <td><h4> <?= $data['GiaNiemYet'];   ?> </h4></td>
          </tr>
          <tr>
            <td><h4>idKM</h4></td>
            <td><h4><?= $data['idKM'];   ?>  </h4></td>
          </tr>
          
        </table>


        <br>
        <br>
        <br>
 </div>
                      
          

</div>

</div>