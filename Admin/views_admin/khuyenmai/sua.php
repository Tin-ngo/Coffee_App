<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database sanpham</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">
        <form action="?action=suakhuyenmai_xl" method="post">  <!-- model_admin/sua_xl.php -->
      	<table border="0" cellpadding="10">
          <tr>
               <td>idKM: </td>
               <td>
                <input disabled type="text" name="idKM" value=<?php echo $data['idKM']; ?>>
                <input type="hidden" name="idKM" value=<?php echo $data['idKM']; ?> >
              </td>
           </tr>
            <tr>
               <td>Loại Khuyến Mãi:</td>
               <td><input required type="text" name="LoaiKM" value=<?php echo $data['LoaiKM']; ?> ></td>
           </tr>
            <tr>
               <td>Giá trị khuyễn mãi:</td>
               <td><input required type="text" name="GiatriKM" value=<?php echo $data['GiatriKM']; ?>></td>
           </tr>
            <tr>
               <td>Ngày bắt đầu:</td>
               <td><input type="date" name="NgayBD" value=<?php echo $data['NgayBD']; ?>></td>
           </tr>
           <tr>
               <td>Ngày kết thúc:</td>
               <td><input type="date" name="NgayKT" value=<?php echo $data['NgayKT']; ?>></td>
           </tr>
           
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Sửa</button></td>
           </tr>

        </table>
        </form>
      </div>
     

</div>

</div>