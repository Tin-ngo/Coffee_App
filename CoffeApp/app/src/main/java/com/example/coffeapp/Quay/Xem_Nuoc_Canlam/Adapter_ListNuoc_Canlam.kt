package com.example.coffeapp.Quay.Xem_Nuoc_Canlam

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


class Adapter_ListNuoc_Canlam(var context : Context, var mang_nuoc_canlam : ArrayList<OBJ_Datnuoc>) : BaseAdapter() {

    // Lấy API
    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )



    override fun getCount(): Int {
        return mang_nuoc_canlam.size
    }

    override fun getItem(position: Int): Any {
        return mang_nuoc_canlam.get(position)
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
            view = layoutinflater.inflate(R.layout.item_nuoc_canlam, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */


        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }




        /* lấy dữ liệu bảng datnuoc*/
        var ban: OBJ_Datnuoc = getItem(position) as OBJ_Datnuoc
        viewholder.textviewtenNuoc_Canlam.text = ban.tenNuoc
        viewholder.textviewsoluongNuoc_Canlam.text = "SL"+ban.soluong
        viewholder.textviewSoban.text = "Bàn "+ban.idSoban
        viewholder.textviewXacnhanXong.text = "Xác Nhận đã làm Xong?"

        viewholder.textviewXacnhanXong.setOnClickListener {
            update_lam_xongnuoc(1,ban.idDatnuoc)
            Toast.makeText(context, "Đã xác nhận làm xong nước!!", Toast.LENGTH_SHORT).show()
        }



        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewtenNuoc_Canlam: TextView
        var textviewsoluongNuoc_Canlam: TextView
        var textviewSoban: TextView
        var textviewXacnhanXong: TextView

        /* gán ánh xạ vào */
        init {
            textviewtenNuoc_Canlam = row.findViewById(R.id.txt_tenNuoc_canlam) as TextView
            textviewsoluongNuoc_Canlam = row.findViewById(R.id.txt_soluong_canlam) as TextView
            textviewSoban = row.findViewById(R.id.txt_soban) as TextView
            textviewXacnhanXong = row.findViewById(R.id.txt_Xacnhan_lamxong) as TextView

        }
    }


    //API update thanh toán => thay số 0 là số 1 trong cộ thanh toán
    fun update_lam_xongnuoc(Xong_Don: Int, idDatnuoc:Int) {
        myRetrofitAPI.update_lam_xongnuoc(Xong_Don, idDatnuoc)?.enqueue(object : Callback<Any> {
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
