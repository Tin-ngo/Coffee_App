package com.example.coffeapp.Quay

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
import com.example.coffeapp.Chat.Adapter_ListChat
import com.example.coffeapp.Chat.OBJ_Chat
import com.example.coffeapp.MainActivity
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Datnuoc
import com.example.coffeapp.Quay.Nuoc_dalam_Homnay.Adapter_ListNuoc_Dalam_homnay
import com.example.coffeapp.Quay.Xem_Nuoc_Canlam.Adapter_ListNuoc_Canlam
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.phucvu_activity.*
import kotlinx.android.synthetic.main.quay_activity.*
import kotlinx.android.synthetic.main.quay_activity.btn_send
import kotlinx.android.synthetic.main.quay_activity.edt_text
import kotlinx.android.synthetic.main.quay_activity.headerLabel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuayActivity : AppCompatActivity() {


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
                    headerTxt.text = "Nước cần làm"
                    get_Nuoc_canlam()
                }
                1 -> {
                    headerTxt.text = "Nước đã làm hôm nay"
                    get_Nuoc_dalam_homnay()
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
        setContentView(R.layout.quay_activity)

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
        bottomNavigation = findViewById(R.id.bottom_navigation_quay)
        headerTxt = findViewById(R.id.headerLabel)
        myListView = findViewById(R.id.myListView_quay_activity)  //chưa cần xài,đã dùng cách gán trực tiếp bằng id listview rồi
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
        val item1 = AHBottomNavigationItem(R.string.Q_Nuoccanlam, R.drawable.ic_order, R.color.xanhdatroi_laireu)
        val item2 = AHBottomNavigationItem(R.string.Q_Nuoclamxong, R.drawable.ic_orderxong, R.color.xanh_reu)
        val item3 = AHBottomNavigationItem(R.string.Q_lienhe, R.drawable.ic_lienhe, R.color.nau_xam)
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



    // lấy dữ liệu nước cần làm cho quầy XOng_nuoc = 0
    fun get_Nuoc_canlam() {
        myRetrofitAPI.getUrl_Nuoc_canlam("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=NUOC_Canlam")?.enqueue(
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
                        var array_nuoc_canlam : java.util.ArrayList<OBJ_Datnuoc> = java.util.ArrayList()

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idDatnuoc.toString()
                            array_nuoc_canlam.add(OBJ_Datnuoc(postlist[i].idDatnuoc, postlist[i].idSoban,
                                    postlist[i].idNuoc, postlist[i].soluong, postlist[i].ngay,
                                    postlist[i].thanhtoan, postlist[i].Xong_Don, postlist[i].tenNuoc))


                            headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                            edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                            btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn

                            myListView_quay_activity.adapter = Adapter_ListNuoc_Canlam(applicationContext, array_nuoc_canlam)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
//                            myListView_quay_activity.onItemClickListener = AdapterView.OnItemClickListener {
//                                adapterView, view, position,
//                                id ->
//                                Log.d("TITLE", "Xem get_Nuoc_canlam")
//                            }
                        }
                    }
                })
    }
    //hết API het dat nuoc



    // lấy dữ liệu nước đã làm trong hôm nay
    fun get_Nuoc_dalam_homnay() {
        myRetrofitAPI.getUrl_Nuoc_canlam("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=nuoc_dalam_homnay")?.enqueue(
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
                        var array_nuoc_dalam : java.util.ArrayList<OBJ_Datnuoc> = java.util.ArrayList()

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idDatnuoc.toString()
                            array_nuoc_dalam.add(OBJ_Datnuoc(postlist[i].idDatnuoc, postlist[i].idSoban,
                                    postlist[i].idNuoc, postlist[i].soluong, postlist[i].ngay,
                                    postlist[i].thanhtoan, postlist[i].Xong_Don, postlist[i].tenNuoc))


                            headerLabel.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
                            edt_text.setTransitionVisibility(View.INVISIBLE)   //ẩn chỗ nhập tin nhắn
                            btn_send.setTransitionVisibility(View.INVISIBLE)   //ẩn nút gửi tin nhắn

                            myListView_quay_activity.adapter = Adapter_ListNuoc_Dalam_homnay(applicationContext, array_nuoc_dalam)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
//                            myListView_quay_activity.onItemClickListener = AdapterView.OnItemClickListener {
//                                adapterView, view, position,
//                                id ->
//                                Log.d("TITLE", "Xem get_Nuoc_canlam")
//                            }
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
                            myListView_quay_activity.adapter = Adapter_ListChat(applicationContext, array)
                            //hiển thị hộp thoại khi nhấn vào một dòng listview
                            myListView_quay_activity.onItemClickListener = AdapterView.OnItemClickListener {
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