package com.example.coffeapp.PV.Order

import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Nuoc
import com.example.coffeapp.R

import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Lấy API  - mới

// lớp này để hiển thị ra cho nhân viên phụuc vụ bàn mấy và hiển thị listview các loại nước
// phucvuactivity gọi lớp này
class CustomDialogFragment_PV(var number:Int) : DialogFragment() {

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

        var so:Int = number+1
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

        getNuoc(rootView)


        // đang làm chỗ này
//        rootView.listview_dialog.onItemClickListener = AdapterView.OnItemClickListener {
//            adapterView, view, position,
//            id ->
//            Log.d("Test", "thử nghiệm này đặt trong getBan()")
//
//            var view_item_nuoc : View = inflater.inflate(R.layout.item_nuoc, container, false)
//
//            Log.d("Test_lấy id nước và SL", view_item_nuoc.txt_idNuoc_hidden.text as String)
//
//        }



        return rootView
    }









    fun getNuoc(rootView: View) {

        // Xử lý phần API
        myRetrofitAPI.getUrl_nuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_NUOC")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_Nuoc>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_Nuoc>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }

                    override fun onResponse(
                            call: Call<ArrayList<OBJ_Nuoc>>?,
                            response: Response<ArrayList<OBJ_Nuoc>>?
                    ) {
                        var postlist: ArrayList<OBJ_Nuoc>? = response?.body() as ArrayList<OBJ_Nuoc>
                        var post = arrayOfNulls<String>(postlist!!.size)
                        var array : ArrayList<OBJ_Nuoc> = ArrayList()    // tạo mảng để hiển thị ra bên gridview

                        for (i in postlist.indices) {
                            // thêm dữ liệu vào mảng postlist
                            post[i] = postlist[i].idNuoc.toString()
                            array.add(OBJ_Nuoc(postlist[i].idNuoc, postlist[i].idLoaiNuoc, postlist[i].tenNuoc,postlist[i].hinhanh,
                                    postlist[i].mota,postlist[i].idGiaThanh))  //thêm dl vào mảng array gồm id và hình bàn
//                        //hiển thị ra adapter
//                        var adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_dropdown_item_1line, post)
//                        myListView.adapter = adapter
                            // Thêm dữ liệu- mảng vừa tạo vào GridView và tạo sự kiện khi click vào từng dòng trong gridview

//                            var adapter = context?.let { ArrayAdapter<String>(it, android.R.layout.simple_dropdown_item_1line, array) }
//                            rootView.listview_dialog.adapter = adapter
                            rootView.listview_dialog.adapter = context?.let { CustomAdapter_ListNuoc(it, array, number) }
//                            rootView.listview_dialog.onItemClickListener = AdapterView.OnItemClickListener {
//                                adapterView, view, position,
//                                id ->
//                                Log.d("Test", "thử nghiệm này đặt trong getBan()")
//
//                            }
                        }

                    }


                })


    }  // ngoặc của API





}