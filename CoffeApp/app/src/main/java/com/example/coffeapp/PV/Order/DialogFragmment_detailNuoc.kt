package com.example.coffeapp.PV.Order

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.DialogFragment
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Ban
import com.example.coffeapp.OBJ_Nuoc
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.fragment_custom_dialog_detailnuoc.view.*
import kotlinx.android.synthetic.main.fragment_custom_dialog_pv.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



// lớp này để hiển thị ra cho nhân viên phụuc vụ bàn mấy và hiển thị listview các loại nước
// phucvuactivity gọi lớp này
class DialogFragmment_detailNuoc(var number:Int, var soban:Int, var details : ArrayList<OBJ_Ban>) : DialogFragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var rootView : View = inflater.inflate(R.layout.fragment_custom_dialog_detailnuoc, container, false)


        rootView.txt_banmay_detailnuoc.setText("Bàn ${soban}")

        rootView.txt_tennuoc_detail.text = details[number].tenNuoc.toString()
        rootView.txt_soluong_detail.text = "số lượng: "+details[number].soluong.toString()
        rootView.txt_giatien_detail.text = "Đơn giá: "+details[number].GiaNiemYet.toString()
        var tongtien:Double = details[number].soluong*details[number].GiaNiemYet
        rootView.txt_Tongtien_detail.text = "Tổng tiền: "+tongtien.toString()


        rootView.btn_xong_detailnuoc.setOnClickListener {
            Log.d("Số bàn là", details[number].tenNuoc.toString())
            dismiss()
        }




        return rootView
    }



}