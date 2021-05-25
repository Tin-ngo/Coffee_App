<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database banner</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">
        <form action="?action=suauser_xl" method="post"  enctype="multipart/form-data">  <!-- model_admin/sua_xl.php -->
      	<table border="0" cellpadding="10">
          <tr>
               <td>idUser: </td>
               <td>
                <input disabled type="text" name="iduser" value=<?php echo $data['idUser']; ?>>
                <input type="hidden" name="iduser" value=<?php echo $data['idUser']; ?> >
              </td>
           </tr>
            <tr>
               <td>idQuyen:</td>
               <td><input type="text" name="idQuyen" value=<?php echo $data['idQuyen']; ?> ></td>
           </tr>
            <tr>
               <td>ho:</td>
               <td><input type="text" name="ho" value=<?php echo $data['ho']; ?> ></td>
           </tr>
            <tr>
               <td>ten:</td>
               <td><input type="text" name="ten" value=<?php echo $data['ten']; ?> ></td>
           </tr>
            <tr>
               <td>email:</td>
               <td><input type="text" name="email" value=<?php echo $data['email']; ?> ></td>
           </tr>
            <tr>
               <td>diachi:</td>
               <td><input type="text" name="diachi" value=<?php echo $data['diachi']; ?> ></td>
           </tr>
            <tr>
               <td>giơitinh:</td>
               <td><input type="text" name="gioitinh" value=<?php echo $data['gioitinh']; ?> ></td>
           </tr>
            <tr>
               <td>sdt:</td>
               <td><input type="text" name="sodienthoai" value=<?php echo $data['sodienthoai']; ?> ></td>
           </tr>
            <tr>
               <td>tendangnhap:</td>
               <td><input type="text" name="tendangnhap" value=<?php echo $data['tendangnhap']; ?> ></td>
           </tr>
            <tr>
               <td>mk:</td>
               <td><input type="text" name="matkhau" value=<?php echo $data['matkhau']; ?> ></td>
           </tr>
           
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Sửa</button></td>
           </tr>

        </table>
        </form>
      </div>
     

</div>

</div>