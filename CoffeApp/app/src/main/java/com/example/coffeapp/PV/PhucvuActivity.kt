package com.example.coffeapp.PV


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.coffeapp.*
import com.example.coffeapp.Chat.Adapter_ListChat
import com.example.coffeapp.Chat.OBJ_Chat
import com.example.coffeapp.PV.Order.CustomAdapter
import com.example.coffeapp.PV.Order.CustomDialogFragment_PV
import com.example.coffeapp.PV.Order.DialogFragmment_detailNuoc
import com.example.coffeapp.PV.Order_Xong.CustomAdapter_Datnuoc
import kotlinx.android.synthetic.main.chat_item_listview.*
import kotlinx.android.synthetic.main.phucvu_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.ArrayList

class PhucvuActivity : AppCompatActivity() {


    // Lấy API
    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )

    /*
    Instance Fields
     */
    internal lateinit var bottomNavigation: AHBottomNavigation
    internal lateinit var headerTxt: TextView
//    ListView, hoặc là GridView
    internal lateinit var myListView: GridView
    internal lateinit var adapter: ArrayAdapter<String>
    private var cosmicCategory = 0
    /*
    Populate an arraylist that will act as our data source. cosmicBodies
   TẠO DANH SÁCH MẢNG
     */
    private val dulieu: ArrayList<String>
        get() {

            var data5 = ArrayList<String>()
            data5.clear()
            when (cosmicCategory) {
                0 -> {
                    // gọi CustomAdapter để hiển thị listview các bàn và số bàn để click vào thì gọi nước
                    // gọi CustomDialogFragment để HIỂN THỊ HỘP THOẠI khi người dùng click vào từng bàn
                    // gọi CustomAdapter_nuoc để HIỂN THỊ RA CÁC LOẠI NƯỚC vào trong listview đặt trong fragment
                    headerTxt.text = "Số bàn"
                    getBan()
                }
                1 -> {
                    headerTxt.text = "Bàn đã order nước"
                    getDatnuoc()
                }
                2 -> {
                    headerTxt.text = "Liên hệ"

                    All_Chat()
                }
                else -> {
                }
            }
            return data5
        }

    /*
    when activity is created, setContentView, initializeViews and create navigationitems
        KHỞI TẠO VIEW VÀ TẠO ĐIỀU HƯỚNG
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.phucvu_activity)

        this.initializeViews()
        this.createNavigationItems()

    }

    // menu top
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menutop, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_third_item ->
                startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
    //Hết menu top

    /*
    Initialize AHBottomNavigation, TextView and Spinner
    KHỞI TẠO AHBottomNavigation, TextView and Spinner
    */
    private fun initializeViews() {
        bottomNavigation = findViewById(R.id.bottom_navigation)
        headerTxt = findViewById(R.id.headerLabel)
        myListView = findViewById(R.id.myListView_phucvu_activity)  //chưa cần xài,đã dùng cách gán trực tiếp bằng id listview rồi

        //gridview item selection events
        //Sự kiện khi click vào từng mục list view
        myListView.onItemClickListener = AdapterView.OnItemClickListener {
            adapterView, view, position,
            id ->
            Log.d("vd", "Click")
        }

    }

    /*
    Bind data to spinner using an ArrayAdapter
    Liên kết dữ liệu với spinner bằng cách sử dụng ArrayAdapter
     */
    private fun bindData() {
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dulieu)
        myListView.adapter = adapter
    }

    /*
    Create AHBottonNavigationItems, add them to BottomNavigation, setBackgroundColor, Listen to tab events
    Tạo các AHBottomNavigationItems và thêm mấy cái đó vào Bottomnavigation
    đặt màu
    lắng nghe khi click vào từng cái mục ở chỗ AHBottimNavigation
    */
    private fun createNavigationItems() {
        // Create AHNavigationItems
        //Tạo AHNavigation
        val item1 = AHBottomNavigationItem(R.string.pv_datnuoc, R.drawable.ic_table, R.color.teal_700)
        val item2 = AHBottomNavigationItem(R.string.pv_xem, R.drawable.ic_orderxong, R.color.colorPrimaryDark)
        val item3 = AHBottomNavigationItem(R.string.pv_lienhe, R.drawable.ic_lienhe, R.color.xanh_reu)

        // Add AHNavigationItems
        bottomNavigation.addItem(item1)
        bottomNavigation.addItem(item2)
        bottomNavigation.addItem(item3)

        // Set default background color for AHBottomNavigation
        bottomNavigation.defaultBackgroundColor = Color.parseColor("#FEFEFE")

        // Change colors for AHBottomNavigation
        bottomNavigation.accentColor = Color.parseColor("#F63D2B")
        bottomNavigation.inactiveColor = Color.parseColor("#747474")

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.isForceTint = true

        // Manage titles for AHBottomNavigation
        //bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        //bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);

        // Use colored navigation with circle reveal effect
        bottomNavigation.isColored = true

        // Set current item programmatically
        bottomNavigation.currentItem = 0
        bindData()

        // set On TabSelectedListener
        bottomNavigation.setOnTabSelectedListener { position, wasSelected ->
            cosmicCategory = position
            bindData()
            true
        }
    }



//  // Lấy dữ lịệu từ API
//    fun getBan() {
//      myRetrofitAPI.getUrl_soban("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_SOBAN")?.enqueue(
//              object :
//                      Callback<ArrayList<OBJ_Ban>> {
//                  override fun onFailure(call: Call<ArrayList<OBJ_Ban>>, t: Throwable) {
//                      Log.d("onFailure API call", "error")
//                  }
//                  override fun onResponse(
//                          call: Call<ArrayList<OBJ_Ban>>?,
//                          response: Response<ArrayList<OBJ_Ban>>?
//                  ) {
//                      var postlist: ArrayList<OBJ_Ban>? = response?.body() as ArrayList<OBJ_Ban>
//                      var post = arrayOfNulls<String>(postlist!!.size)
//                      var array: ArrayList<OBJ_Ban> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
//                      for (i in postlist.indices) {
//                          // thêm dữ liệu vào mảng postlist
//                          post[i] = postlist[i].idSoban.toString()
//                          array.add(OBJ_Ban(i+1, postlist[i].idDatnuoc, postlist[i].thanhtoan, postlist[i].Xong_Don,
//                                  postlist[i].soluong, postlist[i].tenNuoc, postlist[i].idGiaThanh, postlist[i].GiaNiemYet, R.drawable.table))
////                          array.add(OBJ_Ban(i,  postlist[i].tenNuoc, postlist[i].idDatnuoc))  //thêm dl vào mảng array gồm id và hình bàn
////                        //hiển thị ra adapter
////                        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, post)
////                        myListView.adapter = adapter
//                          // Thêm dữ liệu- mảng vừa tạo vào GridView và tạo sự kiện khi click vào từng dòng trong gridview
//
//                          headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
//                          edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
//                          btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn
//                          // có thể dùng myListView đã khai báo ở trên
//                          myListView_phucvu_activity.adapter = CustomAdapter(applicationContext, array)
//                          myListView_phucvu_activity.onItemClickListener = AdapterView.OnItemClickListener {
//                              adapterView, view, position, id ->
//                              if (postlist[position].idDatnuoc.equals(0)) {// || postlist[position].thanhtoan.equals(1)
//                                  //nếu bàn chưa được đặt hoặc bàn đã thanh toán thì chưa có khách
//                                  var dialog = CustomDialogFragment_PV(position)   //hiển thị dialog khi click
//                                  dialog.show(supportFragmentManager, "customDialog") //hiển thị dialog khi click
//                              } else {  //khi bàn đã có khách
//                                  var dialog = DialogFragmment_detailNuoc(position, array)   //hiển thị dialog khi click
//                                  dialog.show(supportFragmentManager, "customDialog") //hiển thị dialog khi click
//                              }
//                          }
//                      }
//                  }
//              })
//  }
//    // Hết API getBan()


    // Lấy dữ lịệu từ API
    fun getBan() {
        myRetrofitAPI.getUrl_soban_notjoin("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=LAY_SOBAN")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_BAN_notjion>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_BAN_notjion>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_BAN_notjion>>?,
                            response: Response<ArrayList<OBJ_BAN_notjion>>?
                    ) {
                        var postlist: ArrayList<OBJ_BAN_notjion>? = response?.body() as ArrayList<OBJ_BAN_notjion>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array: ArrayList<OBJ_BAN_notjion> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idSoban.toString()
                            array.add(OBJ_BAN_notjion(postlist[i].idSoban, R.drawable.table))

                            headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                            edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                            btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn
                            // có thể dùng myListView đã khai báo ở trên
                            myListView_phucvu_activity.setNumColumns(2)
                            myListView_phucvu_activity.adapter = CustomAdapter(applicationContext, array)
                            myListView_phucvu_activity.onItemClickListener = AdapterView.OnItemClickListener {
                                adapterView, view, position, id ->

                                // HIỂN THỊ LIST VIEW
                                var dialog = CustomDialogFragment_PV(position)   //hiển thị dialog khi click
                                dialog.show(supportFragmentManager, "customDialog") //hiển thị dialog khi click

                                //SỬ HIỂN THỊ CHI TIẾT MỘT DIALOGFRAGMENT

                            }
                        }
                    }
                })
    }
    // Hết API getBan()



    // lấy dữ liệu của bảng đặt bàn từ API
    fun getDatnuoc() {
        myRetrofitAPI.getUrl_datnuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_datnuoc")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Datnuoc>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Datnuoc>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Datnuoc>>?,
                            response: Response<ArrayList<OBJ_Datnuoc>>?
                    ) {
                        var postlist: ArrayList<OBJ_Datnuoc>? = response?.body() as ArrayList<OBJ_Datnuoc>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array: ArrayList<OBJ_Datnuoc> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idDatnuoc.toString()
                            array.add(OBJ_Datnuoc(postlist[i].idDatnuoc, postlist[i].idSoban, postlist[i].idNuoc,
                                    postlist[i].soluong, postlist[i].ngay, postlist[i].thanhtoan, postlist[i].Xong_Don,
                                    postlist[i].tenNuoc, postlist[i].GiaNiemYet))

//                        //hiển thị ra adapter
//                        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, post)
//                        myListView.adapter = adapter

                            headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                            edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                            btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn
                            myListView_phucvu_activity.setNumColumns(1)
                            // Thêm dữ liệu- mảng vừa tạo vào GridView và tạo sự kiện khi click vào từng dòng trong gridview
                            myListView_phucvu_activity.adapter = CustomAdapter_Datnuoc(applicationContext, array)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
                            myListView_phucvu_activity.onItemClickListener = AdapterView.OnItemClickListener {
                                adapterView, view, position,
                                id ->
                                var text: String? = null
                                if(postlist[position].Xong_Don.equals(0)){
                                    text = "Khách hàng đã đặt nước"
                                }
                                if(postlist[position].Xong_Don.equals(1)){
                                    text = "Quầy đã làm xong nước KH Order"
                                }
                                if(postlist[position].Xong_Don.equals(2)){
                                    text = "Đã phục vụ nước thành công"
                                }
                                Toast.makeText(this@PhucvuActivity, text, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
    }
    //hết API het dat nuoc





    fun All_Chat() {

        headerLabel.setTransitionVisibility(View.INVISIBLE)  // ẩn view headerlabel
        edt_text.setTransitionVisibility(View.VISIBLE)   //hiện chỗ nhập tin nhắn
        btn_send.setTransitionVisibility(View.VISIBLE)   //hiện nút gửi tin nhắn

        //Nhận idQuyen từ HomeActivity
        var intent2 =intent
        var idQuyen:String
        if(intent2 != null){
            idQuyen = intent2.getStringExtra("idQuyen").toString()

            btn_send.setOnClickListener {
                Log.d("test", "Đã gửi idQuyen ${idQuyen} Nội dung ${edt_text.text}")
                Insert_Chat(idQuyen.toInt(), edt_text.text.toString())
                edt_text.setText("")
            }

        }

        myRetrofitAPI.getUrl_allChat("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_CHAT")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Chat>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Chat>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Chat>>?,
                            response: Response<ArrayList<OBJ_Chat>>?
                    ) {
                        var postlist: ArrayList<OBJ_Chat>? = response?.body() as ArrayList<OBJ_Chat>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array: ArrayList<OBJ_Chat> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idchat.toString()
                            array.add(OBJ_Chat(postlist[i].idchat, postlist[i].idQuyen, postlist[i].NoiDung, R.drawable.user))
                            myListView_phucvu_activity.adapter = Adapter_ListChat(applicationContext, array)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
                            myListView_phucvu_activity.setNumColumns(1)
                            myListView_phucvu_activity.onItemClickListener = AdapterView.OnItemClickListener {
                                adapterView, view, position,
                                id ->
                            }


                        }
                    }
                })
    }
    //hết API het dat nuoc




    fun Insert_Chat(idQuyen:Int, NoiDung:String) {
        myRetrofitAPI.insert_chat(idQuyen, NoiDung)?.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.d("API call", "Lỗi <=> error")
            }
            override fun onResponse(
                    call: Call<Any>?, response: Response<Any>?) {response?.let {
                if (response?.isSuccessful) {
                    Log.d("API call", "succeed")
                } else {
                    Log.d("API call", "failed")
                }
            }
            }
        })
    }










    //Hết
}