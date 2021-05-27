package com.example.coffeapp.PV.Order


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
import androidx.annotation.RequiresApi
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Nuoc
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.item_nuoc.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// lớp này hiển thị ra thông tin từng loại nước vào trong từng dòng listview
//lớp này là lớp con của CustomDialogFragment vì lớp CustomDialogFragment gọi lớp này
class CustomAdapter_ListNuoc(var context: Context, var mang_nuoc: ArrayList<OBJ_Nuoc>, var soban: Int) : BaseAdapter() {


    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
            MyAPIInterface::class.java
    )

    override fun getCount(): Int {
        return mang_nuoc.size
    }

    override fun getItem(position: Int): Any {
        return mang_nuoc.get(position)
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
            view = layoutinflater.inflate(R.layout.item_nuoc, null)


////            var ban : View = layoutinflater.inflate(R.layout.item_ban, parent, false)
//            var ban : View = layoutinflater.inflate(R.layout.fragment_custom_dialog, parent, false)

// Lấy ảnh online và gắn vào chỗ id là img_2
//            Glide.with(view)
//                    .load("https://vntalking.com/wp-content/uploads/2019/04/hoc-react-native-tu-co-ban.png")
//                    .into(view.img_2)

// Xử lý tăng giảm khi click chô số lượgn nước
            var soluong_nuoc: Int = view.txt_soluong.text.toString().toInt()

            view.tru1.setOnClickListener{
                if(soluong_nuoc > 0) {
                    soluong_nuoc--
                    view!!.txt_soluong.setText(soluong_nuoc.toString())
                }
                else{
                    view!!.txt_soluong.setText(soluong_nuoc.toString())
                }
            }

            view.cong1.setOnClickListener{
                soluong_nuoc++
                view!!.txt_soluong.setText(soluong_nuoc.toString())
            }


            var solangoi :Int = 0
// Xử lý khi click vô lưu
            view.btn_luu_nuoc.setOnClickListener {
                Log.d("Lưu Số bàn", soban.toString())
                Log.d("Lưu ID Nước", view?.txt_idNuoc_hidden?.text.toString())
                Log.d("Lưu Số lượng", soluong_nuoc.toString())
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val formatted = current.format(formatter)
                Log.d("Time", formatted)
                // gọi hàm insert vào mysql
                try {
                    var solangoi_main = ++solangoi
                    Insert_datnuoc(soban+1, view?.txt_idNuoc_hidden?.text.toString().toInt(), soluong_nuoc, formatted)
                    view?.txt_KQ?.setText("Đã gọi lần : $solangoi_main")
                    Log.d("Kiểm tra", "Đã gọi nước!!")

                }catch(e: Exception){
                    Log.d("Kiểm tra", "Gọi nước lỗi!!")
                }
            }

            view.btn_xoa_nuoc.setOnClickListener {
                Log.d("Xoá Số bàn", soban.toString())
                Log.d("Xoá ID Nước", view?.txt_idNuoc_hidden?.text.toString())
                Log.d("Xoá Số lượng", soluong_nuoc.toString())
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val formatted = current.format(formatter)
                Log.d("Time", formatted)
                // gọi hàm insert vào mysql
                try {
                    if (solangoi > 0) {
                        var solangoi_main = --solangoi
                        view?.txt_KQ?.setText("Đã gọi lần : $solangoi_main")
                        Log.d("Kiểm tra", "Đã Xoá đơn nước!!")
                        Delete_datnuoc(soban, view?.txt_idNuoc_hidden?.text.toString().toInt(), formatted)
                    }
                }catch(e: Exception){
                    Log.d("Kiểm tra", "Xoá nước lỗi!!")
                }
            }





            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* gắn dữ liệu vào */
        var nuoc: OBJ_Nuoc = getItem(position) as OBJ_Nuoc

        viewholder.textviewTenNuoc.text = nuoc.tenNuoc
        viewholder.textviewIdNuoc.text = nuoc.idNuoc.toString()
        viewholder.image_nuoc.setImageResource(R.drawable.nuoc_ep)

        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewTenNuoc: TextView
        var textviewIdNuoc : TextView
        var textviewIdBan : TextView
        var image_nuoc: ImageView

        /* gán ánh xạ vào */
        init {
            textviewTenNuoc = row.findViewById(R.id.txt_nuoc)
            textviewIdNuoc = row.findViewById(R.id.txt_idNuoc_hidden)
            textviewIdBan = row.findViewById(R.id.txt_idBan_hidden)
            image_nuoc = row.findViewById(R.id.img_2)
        }
    }


    fun Insert_datnuoc(idSoban:Int, idNuoc:Int, soluong:Int, ngay:String) {
        myRetrofitAPI.insert_datnuoc(idSoban, idNuoc, soluong, ngay)?.enqueue(object : Callback<Any> {
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

    fun Delete_datnuoc(idSoban:Int, idNuoc:Int, ngay:String) {
        myRetrofitAPI.delete_datnuoc(idSoban, idNuoc, ngay)?.enqueue(object : Callback<Any> {
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
