<div id="viewport">
  <!-- Sidebar -->
  <div id="sidebar">
    <header>
      <a href="#" title="xem trang web">
        <div style="color:white;" href="#">Quản Trị Viên<br> </div> 
      	<div style="line-height: 1px; color:white;font-size: 10px;"><span style="color:orange;">COFFEE</span> APP</div>
      </a>
      
    </header>
    <ul class="nav">
      <li>
        <a href="?action=trangchu">
         <i class="fa fa-home"></i>Trang chủ
        </a>
      </li>
      <li>
        <a href="?action=nuoc">  <!-- href="?action=taikhoan"-->
          <i class="fa fa-table"></i>Quản lý Nước
        </a>
      </li>
      <li>
        <a href="?action=loainuoc">
         <i class="fa fa-table"></i>Quản lý Loại nước
        </a>
      </li>
      <li>
        <a href="?action=user">
          <i class="fa fa-table"></i>Quản lý User
        </a>
      </li>
      <li>
        <a href="?action=hoadon">
         <i class="fa fa-table"></i>Hóa đơn
        </a>
      </li>
      <li>
        <a href="?action=giathanh">
         <i class="fa fa-table"></i> Quản lý Giá thành
        </a>
      </li>
      <li>
        <a href="?action=khuyenmai">
          <i class="fa fa-table"></i>Quản lý khuyến mãi
        </a>
      </li>


       



    </ul>
  </div>
  <!-- Content -->
  <div id="content">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
      	<ul class="nav navbar-nav navbar-left">
      		<li>
      			


<!--
                        <div class="search_box pull-right">
                            
                            <input type="text" placeholder="Search"/>&ensp;
                            <a href="#"><i class="fa fa-search" id="i1"></i></a>

                              <span style="font-size: 20px;padding-left: 10px;"> |</span>
                        </div>
-->



          </li>
          <li>
            <a href="#" style="margin-right: 30px;">
          	<img class="anhuser" src="https://tse3.mm.bing.net/th?id=OIP.2hAVCZRMcBjsE8AGQfWCVQHaHa&pid=Api&P=0&w=300&h=300" alt="">&emsp;
            <?php
            if(isset($_SESSION['tendangnhap'])){
              echo "Xin chào ". $_SESSION['tendangnhap'];
            }else{
              echo "Xin Chào";
            }

            ?>
            </a>
            
          </li>
          
        </ul>
<!--
        <ul class="nav navbar-nav navbar-right" style="padding-right: 30px;">
          <li class="nav2">

            <a href="#"><i class="fa fa-bell nav1"></i></a>
          </li>
           <li>
            <a href="#"><i class="fa fa-envelope nav1"></i></a>
          </li>
        </ul>
-->
      </div>
    </nav>


    


  </div>
</div>