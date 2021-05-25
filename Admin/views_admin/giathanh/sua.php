<div id="viewport">

<div class="container-fluid" id="noidung">
      <h4>Database sanpham</h4>

      
      <div style="background-color: #e5e5e5; padding: 10px 50px 10px; color:gray;">
        <form action="?action=suagiathanh_xl" method="post" enctype="multipart/form-data" >  <!-- model_admin/sua_xl.php -->
      	<table border="0" cellpadding="10">
          <input type="hidden" value="<?php echo $data['idGiaThanh'];?>" name="idGiaThanh">
            <tr>
               <td>Giá Niêm yết:</td>
               <td><input type="text" value="<?php echo $data['GiaNiemYet'];?>" name="GiaNiemYet" required></td>
           </tr>
            <tr>
               <td>idKM:</td>
               <td><input type="text" value="<?php echo $data['idKM'];?>" name="idKM" required></td>
           </tr>
                     
           <!--          <input name="ok" type="submit" value="Ok" /> -->
                </form>
              </td>
           </tr>
           



           <tr>
           	<td colspan="2"><button  style="width: 100px; background-color: darkgray;" type="submit">Sửa</button></td>
           </tr>


        </table>
        </form>

        <br>
           <br>
           <br>


      </div>
     

</div>

</div>


                      <script type="text/javascript" >
    
                           CKEDITOR.replace( 'mota' );
        
                       </script>