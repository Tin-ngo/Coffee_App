<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database user</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">

        <form action="?action=themuser" method="POST" enctype="multipart/form-data">
      	<table border="0" cellpadding="10">
          
            <tr>
               <td>idQuyen:</td>
               <td>
                  <select name="idQuyen" required>
                  <?php foreach($data_phanquyen as $value){ ?>
                        <option value = "<?= $value['idQuyen'] ?>"><?= $value['tenquyen'] ?></option>
                  <?php } ?>
                  </select>
               </td>
           </tr>
            <tr>
               <td>ho</td>
               <td><input  type="text" value="" name="ho" required></td>
           </tr>
           <tr>
               <td>ten:</td>
               <td><input type="text" value="" name="ten" required></td>
           </tr>
            <tr>
               <td>email:</td>
               <td><input type="text" value="" name="email" required></td>
           </tr>
            <tr>
               <td>diachi:</td>
               <td>
                  <textarea name="diachi"  rows="2" cols="60" required></textarea>
               </td>
           </tr>
            <tr>
               <td>gioitinh:</td>
               <td>
                  <!-- <input type="text" value="" name="gioitinh" required> -->
                  <input type="radio" value="0" name="gioitinh" required> Nam
                  &emsp;
                  <input type="radio" value="1" name="gioitinh" required> Nữ
                  &emsp;
                  <input type="radio" value="2" name="gioitinh" required> Khác
               </td>
           </tr>
            <tr>
               <td>sodienthoai:</td>
               <td><input type="text" value="" name="sodienthoai" required></td>
           </tr>
            <tr>
               <td>tendangnhap:</td>
               <td><input type="text" value="" name="tendangnhap" required></td>
           </tr>
           <tr>
               <td>Mật khẩu:</td>
               <td><input type="text" value="" name="matkhau" required></td>
           </tr>
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Submit</button></td>
           </tr>

        </table>
      </form>
      </div>
     

</div>

</div>