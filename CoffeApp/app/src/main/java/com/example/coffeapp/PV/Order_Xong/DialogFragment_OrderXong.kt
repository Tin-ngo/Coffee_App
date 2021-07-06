package com.example.coffeapp.PV.Order_Xong

import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Ban
import com.example.coffeapp.OBJ_Nuoc
import com.example.coffeapp.PV.Order.CustomDialogFragment_PV
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.*

import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.view.*
import kotlinx.android.synthetic.main.phucvu_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Lấy API  - mới

// lớp này để hiển thị ra cho nhân viên phụuc vụ bàn mấy và hiển thị listview các loại nước
// phucvuactivity gọi lớp này
class DialogFragment_OrderXong(var number:Int) : DialogFragment() {

    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.fragment_custom_dialog_pv, container, false)
        var view_item_nuoc : View = inflater.inflate(R.layout.item_nuoc, container, false)

        var so:Int = number
        rootView.txt_chonnuoc.setText("Bàn ${so}")  // lấy số bàn




        //xử lý khi bấm nút submit
        rootView.submitButton.setOnClickListener {
//            val selectedID = ratingRadioGroup.checkedRadioButtonId
//            val radio = rootView.findViewById<RadioButton>(selectedID)
//            var Result = radio.text.toString()
            Log.d("Số bàn là", number.toString())
            //khi đã submit sẽ đóng hộp thoại
            dismiss()
        }

        getNuoc_OrderXong(rootView, number)


       rootView.order_more.setOnClickListener {
           Log.d("test", "gọi thêm")
           //đang
           var dialog = CustomDialogFragment_PV(number)   //hiển thị dialog khi click
           fragmentManager?.let { it1 -> dialog.show(it1, "customDialog") } //hiển thị dialog khi click
           order_more.setTransitionVisibility(View.VISIBLE)  // hiện view headerlabel
       }



        return rootView
    }




    fun getNuoc_OrderXong(rootView: View, soban:Int) {

        // Xử lý phần API
        myRetrofitAPI.getUrl_soban2(soban)?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Ban>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Ban>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }

                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Ban>>?,
                            response: Response<ArrayList<OBJ_Ban>>?
                    ) {
                        var postlist: ArrayList<OBJ_Ban>? = response?.body() as ArrayList<OBJ_Ban>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : ArrayList<OBJ_Ban> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idSoban.toString()
                            array.add(OBJ_Ban(postlist[i].idSoban, postlist[i].idDatnuoc,
                                    postlist[i].thanhtoan,postlist[i].Xong_Don,
                                    postlist[i].soluong,postlist[i].tenNuoc,
                                    postlist[i].idGiaThanh,postlist[i].GiaNiemYet, postlist[i].hinhanh))
                            rootView.listview_dialog.adapter = context?.let { CustomAdapter_ListNuoc_OrderXong(it, array, number) }
                        }

                    }


                })


    }  // ngoặc của API









//
//    fun getNuoc(rootView: View) {
//
//        // Xử lý phần API
//        myRetrofitAPI.getUrl_nuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_NUOC")?.enqueue(
//                object :
//                        Callback<ArrayList<OBJ_Nuoc>> {
//                    override fun onFailure(call: Call<ArrayList<OBJ_Nuoc>>, t: Throwable) {
//                        Log.d("onFailure API call", "error")
//                    }
//
//                    override fun onResponse(
//                            call: Call<ArrayList<OBJ_Nuoc>>?,
//                            response: Response<ArrayList<OBJ_Nuoc>>?
//                    ) {
//                        var postlist: ArrayList<OBJ_Nuoc>? = response?.body() as ArrayList<OBJ_Nuoc>
//                        var post = arrayOfNulls<String>(postlist!!.size)
//                        var array : ArrayList<OBJ_Nuoc> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
//
//                        for (i in postlist.indices) {
//                            // thêm dữ liệu vào mảng postlist
//                            post[i] = postlist[i].idNuoc.toString()
//                            array.add(OBJ_Nuoc(postlist[i].idNuoc, postlist[i].idLoaiNuoc, postlist[i].tenNuoc,postlist[i].hinhanh,
//                                    postlist[i].mota,postlist[i].idGiaThanh))  //thêm dl vào mảng array gồm id và hình bàn
////                        //hiển thị ra adapter
////                        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, post)
////                        myListView.adapter = adapter
//                            // Thêm dữ liệu- mảng vừa tạo vào GridView và tạo sự kiện khi click vào từng dòng trong gridview
//
////                            var adapter = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_dropdown_item_1line, array) }
////                            rootView.listview_dialog.adapter = adapter
//                            rootView.listview_dialog.adapter = context?.let { CustomAdapter_ListNuoc_OrderXong(it, array, number) }
////                            rootView.listview_dialog.onItemClickListener = AdapterView.OnItemClickListener {
////                                adapterView, view, position,
////                                id ->
////                                Log.d("Test", "thử nghiệm này đặt trong getBan()")
////
////                            }
//                        }
//
//                    }
//
//
//                })
//
//
//    }  // ngoặc của API
//
//
//


}