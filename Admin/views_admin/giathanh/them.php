<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database giathanh</h4>

  
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">

        <form action="?action=them_giathanh" method="POST" enctype="multipart/form-data">
      	<table border="0" cellpadding="10" >
          
            <tr>
               <td>Giá niêm yết:</td>
               <td><input type="text" value="" name="GiaNiemYet" required></td> 
           </tr>
            <tr>
               <td>idKM:</td>
               <td>
                    <select name = "idKM" required>
                     <?php foreach($data_km as $value){ ?>
                        <option value = "<?= $value['idKM'] ?>"><?= $value['LoaiKM'] ?></option>
                     <?php } ?>
                  </select>
                </td> 
           </tr>
           <tr>
           	<td colspan="2" style="padding-bottom: 90px; padding-top: 20px;"><button style="width: 100px; background-color: darkgray;" type="submit">Lưu</button></td>
           </tr>

        </table>
      </form>
      </div>
     

</div>

</div>
  <script type="text/javascript" >
    
                       CKEDITOR.replace( 'mota' );
        
                       </script>
