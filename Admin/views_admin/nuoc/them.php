<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database nuoc</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">

        <form action="?action=them" method="POST" enctype="multipart/form-data">
      	<table border="0" cellpadding="10">
            <tr>
               <td>idLoaiNuoc:</td>
               <td>
                  <select name = "idLoaiNuoc" required>
                     <?php foreach($data_loainuoc as $value){ ?>
                        <option value = "<?= $value['idLoaiNuoc'] ?>"><?= $value['tenLN'] ?></option>
                     <?php } ?>
                  </select>
               </td>
           </tr>
            <tr>
               <td>tenNuoc:</td>
               <td><input type="text" value="" name="tenNuoc" required></td>
           </tr>
            <tr>
               <td>hinhanh:</td>
               <td><input  type="file" value="" name="hinhanh" required></td>
           </tr>
            <tr>
               <td>mota:</td>
               <td>
                  <textarea name="mota"  rows="3" cols="60" required></textarea>
               </td>
           </tr>
            <tr>
               <td>idGiaThanh:</td>
               <td>
                  <select name = "idGiaThanh" required>
                     <?php foreach($data_giathanh as $value2){ ?>
                        <option value = "<?= $value2['idGiaThanh'] ?>">
                           <?= number_format($value2['GiaNiemYet'])?> vnd 
                        </option>
                     <?php } ?>
                  </select>
               </td>
           </tr>
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Submit</button></td>
           </tr>

        </table>
      </form>
      </div>
     

</div>

</div>                     
