package com.example.coffeapp.ThuNgan

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.coffeapp.*
import com.example.coffeapp.Chat.Adapter_ListChat
import com.example.coffeapp.Chat.OBJ_Chat
import com.example.coffeapp.PV.Order.CustomDialogFragment_PV
import com.example.coffeapp.PV.Order.DialogFragmment_detailNuoc
import com.example.coffeapp.PV.Order_Xong.Adapter_XemOrder
import com.example.coffeapp.ThuNgan.Tong_Thu.Adapter_XemThunhap
import com.example.coffeapp.ThuNgan.Tong_Thu.DialogFragment_Thungan
import com.example.coffeapp.ThuNgan.Tong_Thu.OBJ_XemThunhap
import com.example.coffeapp.ThuNgan.Xem_Order.Adapter_DialogFragment_TN
import com.example.coffeapp.ThuNgan.Xem_Order.DialogFragmment_detail_datban
import kotlinx.android.synthetic.main.phucvu_activity.*
import kotlinx.android.synthetic.main.thungan_ativity.*
import kotlinx.android.synthetic.main.thungan_ativity.btn_send
import kotlinx.android.synthetic.main.thungan_ativity.edt_text
import kotlinx.android.synthetic.main.thungan_ativity.headerLabel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ThunganActivity : AppCompatActivity() {


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
    internal lateinit var myListView: GridView
    internal lateinit var adapter: ArrayAdapter<String>
    private var cosmicCategory = 0
    /*
    Populate an arraylist that will act as our data source. cosmicBodies
   TẠO DANH SÁCH MẢNG
     */
    private val dulieu: ArrayList<String>
        @SuppressLint("ResourceAsColor")
        get() {
            var data_thunngan = ArrayList<String>()
            data_thunngan.clear()
            when (cosmicCategory) {
                0 -> {
                    headerTxt.text = "Xem Order"
                    getDatnuoc()
                }
                1 -> {
                    headerTxt.text = "Thu Nhập Của Quán"
                    Thunhap()
                }
                2 -> {
                    headerTxt.text = "Liên hệ"
                    headerLabel.setTransitionVisibility(View.INVISIBLE)  // ẩn view headerlabel
                    edt_text.setTransitionVisibility(View.VISIBLE)   //hiện chỗ nhập tin nhắn
                    btn_send.setTransitionVisibility(View.VISIBLE)   //hiện nút gửi tin nhắn
                    All_Chat()
                }
                else -> {
                }
            }
            return data_thunngan
        }

    /*
    when activity is created, setContentView, initializeViews and create navigationitems
        KHỞI TẠO VIEW VÀ TẠO ĐIỀU HƯỚNG
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.thungan_ativity)

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
        myListView = findViewById(R.id.myListView_thungan_activity)  //chưa cần xài,đã dùng cách gán trực tiếp bằng id listview rồi

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
//        myListView_thungan_activity.adapter = Adapter_XemThunhap(applicationContext, dulieu)
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
        val item1 = AHBottomNavigationItem(R.string.tn_xemOrder, R.drawable.ic_order, R.color.xanhdatroi_laireu)
        val item2 = AHBottomNavigationItem(R.string.tn_thunhap, R.drawable.ic_orderxong, R.color.xanh_reu)
        val item3 = AHBottomNavigationItem(R.string.tn_lienhe, R.drawable.ic_lienhe, R.color.nau_xam)

        // Add AHNavigationItems
        bottomNavigation.addItem(item1)
        bottomNavigation.addItem(item2)
        bottomNavigation.addItem(item3)

        bottomNavigation.defaultBackgroundColor = Color.parseColor("#FEFEFE")
        bottomNavigation.accentColor = Color.parseColor("#F63D2B")
        bottomNavigation.inactiveColor = Color.parseColor("#747474")

        bottomNavigation.isForceTint = true
        bottomNavigation.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW

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


    // Lấy dữ lịeeu từ API

    // lấy dữ liệu của bảng đặt bàn từ API
    fun getDatnuoc() {
        myRetrofitAPI.getUrl_datnuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_datnuoc")?.enqueue(
                object :
                        Callback<java.util.ArrayList<OBJ_Datnuoc>> {
                    override fun onFailure(call: Call<java.util.ArrayList<OBJ_Datnuoc>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<java.util.ArrayList<OBJ_Datnuoc>>?,
                            response: Response<java.util.ArrayList<OBJ_Datnuoc>>?
                    ) {
                        var postlist: java.util.ArrayList<OBJ_Datnuoc>? = response?.body() as java.util.ArrayList<OBJ_Datnuoc>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : java.util.ArrayList<OBJ_Datnuoc> = java.util.ArrayList()

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idDatnuoc.toString()
                            array.add(OBJ_Datnuoc(postlist[i].idDatnuoc, postlist[i].idSoban, postlist[i].idNuoc,
                                    postlist[i].soluong, postlist[i].ngay, postlist[i].thanhtoan, postlist[i].Xong_Don,
                                    postlist[i].tenNuoc, postlist[i].GiaNiemYet))

                            headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                            edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                            btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn
                            // Thêm dữ liệu- mảng vừa tạo vào GridView và tạo sự kiện khi click vào từng dòng trong gridview
                            myListView_thungan_activity.adapter = Adapter_XemOrder(applicationContext, array)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
                            myListView_thungan_activity.onItemClickListener = AdapterView.OnItemClickListener {
                                adapterView, view, position,
                                id ->
//                                var dialog = Adapter_DialogFragment_TN(position, array)   //hiển thị dialog khi click
//                                dialog.show(supportFragmentManager, "customDialog") //hiển thị dialog khi click
//                                Log.d("TITLE", "Xem getDatNuoc")

                                var dialog = DialogFragmment_detail_datban(position, array)   //hiển thị dialog khi click
                                dialog.show(supportFragmentManager, "customDialog") //hiển thị dialog khi click
                            }
                        }
                    }
                })
    }
    //hết API het dat nuoc



    // Dựa vào API để lấy giao diện cho thu nhập, không cần lấy dữ liệu từ API
    fun Thunhap() {
        myRetrofitAPI.getUrl_datnuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_datnuoc")?.enqueue(
                object :
                        Callback<java.util.ArrayList<OBJ_Datnuoc>> {
                    override fun onFailure(call: Call<java.util.ArrayList<OBJ_Datnuoc>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<java.util.ArrayList<OBJ_Datnuoc>>?,
                            response: Response<java.util.ArrayList<OBJ_Datnuoc>>?
                    ) {
                        var array: java.util.ArrayList<OBJ_XemThunhap> = ArrayList()
                        array.add(OBJ_XemThunhap("Hôm nay"))
                        array.add(OBJ_XemThunhap("tháng nay"))
                        array.add(OBJ_XemThunhap("Năm nay"))


                        headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                        edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                        btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn
                        myListView_thungan_activity.adapter = Adapter_XemThunhap(applicationContext, array)
                        //hiển thị hộp thoại khi nhấn vào một dòng listview
                        myListView_thungan_activity.onItemClickListener = AdapterView.OnItemClickListener {
                                adapterView, view, position,
                                id ->
                            //hiển thị dialog khi click, position là để truyền vị trí của cái vừa click qua cho lớp Dialog...
                                var dialog = DialogFragment_Thungan(position, array[position])
                                dialog.show(supportFragmentManager, "DialogThuNgan") //hiển thị dialog khi click
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
                        Callback<java.util.ArrayList<OBJ_Chat>> {
                    override fun onFailure(call: Call<java.util.ArrayList<OBJ_Chat>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<java.util.ArrayList<OBJ_Chat>>?,
                            response: Response<java.util.ArrayList<OBJ_Chat>>?
                    ) {
                        var postlist: java.util.ArrayList<OBJ_Chat>? = response?.body() as java.util.ArrayList<OBJ_Chat>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array: java.util.ArrayList<OBJ_Chat> = java.util.ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idchat.toString()
                            array.add(OBJ_Chat(postlist[i].idchat, postlist[i].idQuyen, postlist[i].NoiDung, R.drawable.user))
                            myListView_thungan_activity.adapter = Adapter_ListChat(applicationContext, array)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
                            myListView_thungan_activity.onItemClickListener = AdapterView.OnItemClickListener {
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