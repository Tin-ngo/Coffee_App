package com.example.coffeapp.Quay.Nuoc_dalam_Homnay

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


class Adapter_ListNuoc_Dalam_homnay(var context : Context, var mang_nuoc_dalam_homnay : ArrayList<OBJ_Datnuoc>) : BaseAdapter() {

    // Lấy API
    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )



    override fun getCount(): Int {
        return mang_nuoc_dalam_homnay.size
    }

    override fun getItem(position: Int): Any {
        return mang_nuoc_dalam_homnay.get(position)
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
            view = layoutinflater.inflate(R.layout.item_nuoc_dalam_homnay, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */


        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }




        /* lấy dữ liệu bảng datnuoc*/
        var ban: OBJ_Datnuoc = getItem(position) as OBJ_Datnuoc
        viewholder.textviewtenNuoc_Dalam_homnay.text = ban.tenNuoc
        viewholder.textviewsoluongNuoc_Dalam_homnay.text = "SL"+ban.soluong
        viewholder.textviewSoban_Dalam_homnay.text = "Bàn "+ban.idSoban


        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewtenNuoc_Dalam_homnay: TextView
        var textviewSoban_Dalam_homnay: TextView
        var textviewsoluongNuoc_Dalam_homnay: TextView

        /* gán ánh xạ vào */
        init {
            textviewtenNuoc_Dalam_homnay = row.findViewById(R.id.txt_tenNuoc_dalam_homnay) as TextView
            textviewSoban_Dalam_homnay = row.findViewById(R.id.txt_Soban_dalam_homnay) as TextView
            textviewsoluongNuoc_Dalam_homnay = row.findViewById(R.id.txt_soluong_dalam_homnay) as TextView

        }
    }



}
