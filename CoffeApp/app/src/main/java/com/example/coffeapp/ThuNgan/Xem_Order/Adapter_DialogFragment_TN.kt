package com.example.coffeapp.ThuNgan.Xem_Order

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.coffeapp.*
import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.view.*
import kotlinx.android.synthetic.main.fragment_custom_dialog_thungan.view.*
import kotlinx.android.synthetic.main.fragment_custom_dialog_tn.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// lớp này để hiển thị ra cho nhân viên phụuc vụ bàn mấy và hiển thị listview các loại nước
// phucvuactivity gọi lớp này
class Adapter_DialogFragment_TN(var number:Int, var mang_datnuoc : java.util.ArrayList<OBJ_Datnuoc>) : DialogFragment() {

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
        var rootView : View = inflater.inflate(R.layout.fragment_custom_dialog_tn, container, false)
        var view_item_nuoc : View = inflater.inflate(R.layout.item_datban_thungan, container, false)

        var so:Int = number+1





        //xử lý khi bấm nút submit
        rootView.submitButton_thungan.setOnClickListener {
            Log.d("Số bàn là", number.toString())
            dismiss()
        }

        rootView.listview_dialog_thungan.adapter = context?.let { Adapter_ListNuoc_TN(it, mang_datnuoc, number) }
        Log.d("số bàn", number.toString())
//        getdatnuoc_thungan(rootView, number)


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


//
//    fun getNuoc(rootView: View) {
//
//        myRetrofitAPI.getUrl_nuoc("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_NUOC")?.enqueue(
//                object :
//                        Callback<ArrayList<OBJ_Nuoc>> {
//                    override fun onFailure(call: Call<ArrayList<OBJ_Nuoc>>, t: Throwable) {
//                        Log.d("onFailure API call", "error")
//                    }
//                    override fun onResponse(
//                            call: Call<ArrayList<OBJ_Nuoc>>?,
//                            response: Response<ArrayList<OBJ_Nuoc>>?
//                    ) {
//                        var postlist: ArrayList<OBJ_Nuoc>? = response?.body() as ArrayList<OBJ_Nuoc>
//                        var post = arrayOfNulls<String>(postlist!!.size)
//                        var array : ArrayList<OBJ_Nuoc> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
//                        for (i in postlist.indices) {
//                            // thêm dữ liệu vào mảng postlist
//                            post[i] = postlist[i].idNuoc.toString()
//                            array.add(OBJ_Nuoc(postlist[i].idNuoc, postlist[i].idLoaiNuoc, postlist[i].tenNuoc,postlist[i].hinhanh,
//                                    postlist[i].mota,postlist[i].idGiaThanh))  //thêm dl vào mảng array gồm id và hình bàn
//
//                            rootView.listview_dialog.adapter = context?.let { Adapter_ListNuoc_TN(it, array, number) }
//
//                        }
//                    }
//                })
//    }



    // Lấy dữ lịeeu từ API
//    fun getdatnuoc_thungan(rootView: View, idSoban_number: Int) {
//
//        myRetrofitAPI.get_Soban_thungan(idSoban_number)?.enqueue(
//                object :
//                        Callback<ArrayList<OBJ_Datnuoc>> {
//                    override fun onFailure(call: Call<ArrayList<OBJ_Datnuoc>>, t: Throwable) {
//                        Log.d("onFailure API call", "error")
//                    }
//                    override fun onResponse(
//                            call: Call<ArrayList<OBJ_Datnuoc>>?,
//                            response: Response<ArrayList<OBJ_Datnuoc>>?
//                    ) {
//                        var postlist: ArrayList<OBJ_Datnuoc>? = response?.body() as ArrayList<OBJ_Datnuoc>
//                        var post = arrayOfNulls<String>(postlist!!.size)
//                        var array: ArrayList<OBJ_Datnuoc> = ArrayList()    // tạo mảng để hiển thị ra bên gridview
//                        array.add(OBJ_Datnuoc(1,1,1,1, "Ngày",
//                                0,1,
//                                "nước chanh"))
//                        for (i in postlist.indices) {
//                            // thêm dữ liệu vào mảng postlist
//                            post[i] = postlist[i].idSoban.toString()
//
//
//                            rootView.listview_dialog_thungan.adapter = context?.let { Adapter_ListNuoc_TN(it, array, number) }
//                            }
//                        }
//
//                })
//    }
    // Hết API getBan()






}