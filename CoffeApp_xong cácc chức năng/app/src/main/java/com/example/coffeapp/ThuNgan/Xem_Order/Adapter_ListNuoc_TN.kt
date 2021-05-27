package com.example.coffeapp.ThuNgan.Xem_Order

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.coffeapp.*
import kotlinx.android.synthetic.main.item_nuoc.view.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Adapter_ListNuoc_TN(var context: Context, var mang_datnuoc: ArrayList<OBJ_Datnuoc>, var soban: Int) : BaseAdapter() {


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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder
        /* trường hợp lần đầu tiên run thì convertview có giá trị là null => tạo các giá trị ánh xạ */
        if (convertView == null) {
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.item_datban_thungan, null)




            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* gắn dữ liệu vào */
        var datnuoc: OBJ_Datnuoc = getItem(position) as OBJ_Datnuoc

        viewholder.textviewTenNuoc.text = datnuoc.tenNuoc
        viewholder.textviewSoban.text = "Số bàn: "+datnuoc.idSoban.toString()
        viewholder.textviewsoluong.text = "Số lượng: "+datnuoc.soluong.toString()
        viewholder.textviewngay.text = datnuoc.ngay
        viewholder.textviewDongia.text = datnuoc.GiaNiemYet.toString()
        var tongtien = datnuoc.GiaNiemYet * datnuoc.soluong
        viewholder.textviewTongtien.text = tongtien.toString()

        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewTenNuoc: TextView
        var textviewSoban : TextView
        var textviewsoluong : TextView
        var textviewngay : TextView
        var textviewDongia : TextView
        var textviewTongtien : TextView

        /* gán ánh xạ vào */
        init {
            textviewTenNuoc = row.findViewById(R.id.txt_tennuoc_tn) as TextView
            textviewSoban = row.findViewById(R.id.txt_soban_tn) as TextView
            textviewsoluong = row.findViewById(R.id.txt_soluong_tn) as TextView
            textviewngay = row.findViewById(R.id.txt_ngay_tn) as TextView
            textviewDongia = row.findViewById(R.id.txt_dongia_tn) as TextView
            textviewTongtien = row.findViewById(R.id.txt_tongtien_tn) as TextView

        }
    }



}