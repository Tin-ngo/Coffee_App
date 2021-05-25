<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database nguoidung</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">
        <form action="?action=sua_xl" method="post" enctype="multipart/form-data">  <!-- model_admin/sua_xl.php -->
      	<table border="0" cellpadding="10">
          <tr>
               <td>idNuoc: </td>
               <td>
                <input disabled type="text" name="idNuoc" value=<?php echo $data['idNuoc']; ?>>
                <input type="hidden" name="idNuoc" value=<?php echo $data['idNuoc']; ?> >
              </td>
           </tr>
            <tr>
               <td>idLoaiNuoc:</td>
               <td><input  required type="text" name="idLoaiNuoc" value=<?php echo $data['idLoaiNuoc']; ?> ></td>
           </tr>
            <tr>
               <td>tên Nước:</td>
               <td><input required type="text" name="tenNuoc" value=<?php echo $data['tenNuoc']; ?>></td>
           </tr>
            <tr>
               <td>hinhanh:</td>
               <td><input required type="file" name="hinhanh" value=<?php echo $data['hinhanh']; ?>></td>
           </tr>
            <tr>
              <td>Mô Tả:</td>
              <td><input required type="text" name="mota" value=<?php echo $data['mota']; ?>></td>
           </tr>
            <tr>
               <td>id Giá Thành:</td>
               <td><input required type="text" name="idGiaThanh" value=<?php echo $data['idGiaThanh']; ?>></td>
           </tr>
          
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Sửa</button></td>
           </tr>

        </table>
        </form>
      </div>
     

</div>

</div>
