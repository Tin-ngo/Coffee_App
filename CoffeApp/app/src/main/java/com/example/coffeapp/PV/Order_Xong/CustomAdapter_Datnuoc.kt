package com.example.coffeapp.PV.Order_Xong

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Ban
import com.example.coffeapp.OBJ_Datnuoc
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.item_ban.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList


class CustomAdapter_Datnuoc(var context : Context, var mang_datnuoc : ArrayList<OBJ_Datnuoc>) : BaseAdapter() {

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
            view = layoutinflater.inflate(R.layout.item_datban, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */


        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* lấy dữ liệu bảng datnuoc*/
        var ban: OBJ_Datnuoc = getItem(position) as OBJ_Datnuoc
        viewholder.textviewSoban.text = "Bàn:" + ban.idSoban.toString()
//        viewholder.textviewTennuoc.text = "Tên nước:" + ban.idNuoc.toString()
        viewholder.textviewTennuoc.text = ban.tenNuoc.toString()
        viewholder.textviewSoluong.text = "SL: " + ban.soluong.toString()
        if (ban.Xong_Don.equals(0) == true){
            viewholder.textviewXongdon.text = "Đã đặt Nước"
        }
        if (ban.Xong_Don.equals(1) == true){
            viewholder.textviewXongdon.text = "Quầy đã làm Xong"

            // Hiển thị nước đã làm xong và bưng chưa bưng lên cho khách
            viewholder.textviewXongdon.setOnClickListener {
                Log.d("idDatnuoc", ban.idDatnuoc.toString())
                update_xongnuoc(2, ban.idDatnuoc)
                viewholder.textviewXongdon.setTextColor(R.color.red)
                Toast.makeText(context, "Đã xác nhận", Toast.LENGTH_SHORT).show()
            }
        }
        if (ban.Xong_Don.equals(2) == true){
            viewholder.textviewXongdon.setTextColor(R.color.xanh_duong)
            viewholder.textviewXongdon.text = "Đã Phục vụ xong"
        }




        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewSoban: TextView
        var textviewTennuoc: TextView
        var textviewSoluong: TextView
        var textviewXongdon: TextView

        /* gán ánh xạ vào */
        init {
            textviewSoban = row.findViewById(R.id.txt_soban_dagoi) as TextView
            textviewTennuoc = row.findViewById(R.id.txt_tennuoc_dagoi) as TextView
            textviewSoluong = row.findViewById(R.id.txt_soluong_dagoi) as TextView
            textviewXongdon = row.findViewById(R.id.txt_xong_don) as TextView
        }
    }


    //API update thanh toán => thay số 1 là số 2 trong cột Xong_Don
    fun update_xongnuoc(Xong_Don: Int, idDatnuoc:Int) {
        myRetrofitAPI.update_xongnuoc(Xong_Don, idDatnuoc)?.enqueue(object : Callback<Any> {
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
