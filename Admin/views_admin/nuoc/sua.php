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
               <td>
                    <select style="padding: 5px;" name = "idLoaiNuoc" required>
                     <?php foreach($data_loainuoc as $value){ ?>
                        <option value = "<?= $value['idLoaiNuoc'] ?>"><?= $value['tenLN'] ?></option>
                     <?php } ?>
                  </select>
                    <input  disabled type="text" name="idLoaiNuoc" size='10' 
                        value="<?php echo $data['idLoaiNuoc']; ?>/ <?php echo $data['tenLN']; ?>" >
                    
                </td>
           </tr>
            <tr>
               <td>tên Nước:</td>
               <td><input required type="text" name="tenNuoc" value="<?php echo $data['tenNuoc']; ?>"></td>
           </tr>
            <tr>
               <td>hinhanh:</td>
               <td><input required type="file" name="hinhanh" value="<?php echo $data['hinhanh']; ?>"></td>
                <td> <img src="public_admin/image/nuoc/<?= $data['hinhanh']?>" width="40" height="40" /></td>
           </tr>
            <tr>
              <td>Mô Tả:</td>
              <td><input required type="text" name="mota" value="<?php echo $data['mota']; ?>"></td>
           </tr>
            <tr>
               <td>id Giá Thành:</td>
               <td>
                    <select style="padding: 5px;" name = "idGiaThanh" required>
                     <?php foreach($data_giathanh as $value2){ ?>
                        <option value = "<?= $value2['idGiaThanh'] ?>">
                           <?= number_format($value2['GiaNiemYet'])?> vnd 
                        </option>
                     <?php } ?>
                  </select>

                    <input disabled type="text" size="10" name="idGiaThanh" 
                    value="<?php echo $data['idGiaThanh'];?>/ <?php echo $data['GiaNiemYet']; ?>">
                </td>
           </tr>
          
           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Sửa</button></td>
           </tr>

        </table>
        </form>
      </div>
     

</div>

</div>
