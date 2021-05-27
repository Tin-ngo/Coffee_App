package com.example.coffeapp.ThuNgan.Tong_Thu

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.coffeapp.*
import com.example.coffeapp.PV.Order_Xong.CustomAdapter_Datnuoc
import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.view.*
import kotlinx.android.synthetic.main.fragment_custom_dialog_thungan.view.*
import kotlinx.android.synthetic.main.phucvu_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Lấy API  - mới
val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
        MyAPIInterface::class.java
)

class DialogFragment_Thungan(var position: Int, var data: OBJ_XemThunhap) : DialogFragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.fragment_custom_dialog_thungan, container, false)

        rootView.txt_TTthunhap.setText("Thu nhập "+data.loai_ngay)

        rootView.submitButton_tn.setOnClickListener {
            dismiss()
        }

        var arr: ArrayList<OBJ_Giathanh> = ArrayList()
//        arr.add("hello1"+position)
//        arr.add("hêllo2"+position)
       // arr.add(data.loai_ngay)
        if(position.equals(0)){
            getGiathanh_homnay(rootView)
        }
        if(position.equals(1)){
            getGiathanh_thangnay(rootView)
        }
        if(position.equals(2)){
            getGiathanh_namnay(rootView)
        }

        rootView.listview_dialog_tn.adapter = context?.let { Adapter_ListThunhap(it, arr) }
//        rootView.listview_dialog_tn.adapter = context?.let { Adapter_ListThunhap(it, arr.toString()) }

        return rootView

    }



    fun getGiathanh_homnay(rootView: View) {
        // Xử lý phần API
        myRetrofitAPI.getUrl_Homnay("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=HOMNAY_nuoc_giathanh")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Giathanh>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Giathanh>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Giathanh>>?,
                            response: Response<ArrayList<OBJ_Giathanh>>?
                    ) {
                        var postlist: ArrayList<OBJ_Giathanh>? = response?.body() as ArrayList<OBJ_Giathanh>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : ArrayList<OBJ_Giathanh> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        var tong_toanbo:Double = 0.0
                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].tenNuoc
                            array.add(OBJ_Giathanh(postlist[i].tenNuoc, postlist[i].GiaNiemYet, postlist[i].soluong))
                            rootView.listview_dialog_tn.adapter = context?.let { Adapter_ListThunhap(it, array) }

                            tong_toanbo = tong_toanbo + postlist[i].GiaNiemYet*postlist[i].soluong
//                                rootView.listview_dialog_tn.onItemClickListener = AdapterView.OnItemClickListener {
//                                adapterView, view, position,
//                                id ->
//                                Log.d("Test", postlist[i].tenNuoc.toString())
//                            }
                        }
                        rootView.txt_tong_thunhap.setText("Tổng:" + tong_toanbo.toString())
                    }
                })
    }  // ngoặc của API



    fun getGiathanh_thangnay(rootView: View) {
        // Xử lý phần API
        myRetrofitAPI.getUrl_Homnay("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=THANGNAY_nuoc_giathanh")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Giathanh>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Giathanh>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Giathanh>>?,
                            response: Response<ArrayList<OBJ_Giathanh>>?
                    ) {
                        var postlist: ArrayList<OBJ_Giathanh>? = response?.body() as ArrayList<OBJ_Giathanh>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : ArrayList<OBJ_Giathanh> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
                        var tong:Double = 0.0
                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].tenNuoc
                            array.add(OBJ_Giathanh(postlist[i].tenNuoc, postlist[i].GiaNiemYet, postlist[i].soluong))
                            rootView.listview_dialog_tn.adapter = context?.let { Adapter_ListThunhap(it, array) }
                            tong = tong + postlist[i].GiaNiemYet*postlist[i].soluong
                        }
                        rootView.txt_tong_thunhap.setText("Tổng:" + tong.toString())
                    }
                })
    }  // ngoặc của API




    fun getGiathanh_namnay(rootView: View) {
        // Xử lý phần API
        myRetrofitAPI.getUrl_Namnay("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=NAMNAY_nuoc_giathanh")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Giathanh>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Giathanh>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Giathanh>>?,
                            response: Response<ArrayList<OBJ_Giathanh>>?
                    ) {
                        var postlist: ArrayList<OBJ_Giathanh>? = response?.body() as ArrayList<OBJ_Giathanh>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : ArrayList<OBJ_Giathanh> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
                        var tong:Double = 0.0
                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].tenNuoc
                            array.add(OBJ_Giathanh(postlist[i].tenNuoc, postlist[i].GiaNiemYet, postlist[i].soluong))
                            rootView.listview_dialog_tn.adapter = context?.let { Adapter_ListThunhap(it, array) }
                            tong = tong + postlist[i].GiaNiemYet*postlist[i].soluong
                        }
                        rootView.txt_tong_thunhap.setText("Tổng:" + tong.toString())
                    }
                })
    }  // ngoặc của API





}