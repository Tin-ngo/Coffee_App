package com.example.coffeapp.PV.Order_Xong

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.coffeapp.MyAPIInterface

import com.example.coffeapp.OBJ_Datnuoc
import com.example.coffeapp.R

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList


class Adapter_XemOrder(var context : Context, var mang_datnuoc : ArrayList<OBJ_Datnuoc>) : BaseAdapter() {

    // Lấy API
    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )



    override fun getCount(): Int {
        return mang_datnuoc.size
    }

    override fun getItem(position: Int): Any {
        return mang_datnuoc.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ResourceAsColor")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder
        /* trường hợp lần đầu tiên run thì convertview có giá trị là null => tạo các giá trị ánh xạ */
        if (convertView == null) {
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.tn_item_xemorder, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */


        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }



        /* gawsn dữ liệu vào */
        var ban: OBJ_Datnuoc = getItem(position) as OBJ_Datnuoc
        viewholder.textviewSoban.text = "Bàn:" + ban.idSoban.toString()

        if (ban.thanhtoan.equals(0) == true){
            viewholder.textviewThanhtoan.text = "Chưa tt"
        }
        if (ban.thanhtoan.equals(1) == true){
            viewholder.textviewThanhtoan.text = "Đã tt"
            viewholder.textviewThanhtoan.setTextColor(R.color.xanh_duong)
//            viewholder.textviewThanhtoan.setBackgroundColor(R.color.xanh_duong)
        }

//         xác nhận khách hàng đã thanh toán - việc này đã chuyển cho bên thu ngân
        viewholder.textviewXacNhanThanhToan.setOnClickListener {
            Log.d("idDatnuoc", ban.idDatnuoc.toString())
            update_thanhtoan(1, ban.idDatnuoc)
            Toast.makeText(context, "Xác Nhận thanh toán id ${ban.idDatnuoc}", Toast.LENGTH_SHORT).show()
        }

        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewSoban: TextView
        var textviewThanhtoan: TextView
        var textviewXacNhanThanhToan: TextView

        /* gán ánh xạ vào */
        init {
            textviewSoban = row.findViewById(R.id.txt_soban_dagoi_thungan) as TextView
            textviewThanhtoan = row.findViewById(R.id.txt_thanhtoan_thungan) as TextView
            textviewXacNhanThanhToan = row.findViewById(R.id.txt_xacnhantt_thungan) as TextView
        }
    }


    //API update thanh toán => thay số 0 là số 1 trong cộ thanh toán
    fun update_thanhtoan(thanhtoan: Int, idDatnuoc:Int) {
        myRetrofitAPI.update_datnuoc_tt(thanhtoan, idDatnuoc)?.enqueue(object : Callback<Any> {
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


}
