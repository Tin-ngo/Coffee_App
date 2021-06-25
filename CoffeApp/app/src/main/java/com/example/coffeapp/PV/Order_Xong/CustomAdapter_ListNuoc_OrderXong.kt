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
import androidx.annotation.RequiresApi
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Ban
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
class CustomAdapter_ListNuoc_OrderXong(var context: Context, var mang_nuoc: ArrayList<OBJ_Ban>, var soban: Int) : BaseAdapter() {


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

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder
        /* trường hợp lần đầu tiên run thì convertview có giá trị là null => tạo các giá trị ánh xạ */
        if (convertView == null) {
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.item_nuoc_orderxong, null)


////            var ban : View = layoutinflater.inflate(R.layout.item_ban, parent, false)
//            var ban : View = layoutinflater.inflate(R.layout.fragment_custom_dialog, parent, false)

// Lấy ảnh online và gắn vào chỗ id là img_2
//            Glide.with(view)
//                    .load("https://vntalking.com/wp-content/uploads/2019/04/hoc-react-native-tu-co-ban.png")
//                    .into(view.img_2)

// Xử lý tăng giảm khi click chô số lượgn nước


            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* gắn dữ liệu vào */
        var nuoc: OBJ_Ban = getItem(position) as OBJ_Ban

        viewholder.textviewTenNuoc.text = nuoc.tenNuoc
        viewholder.image_nuoc.setImageResource(R.drawable.nuoc_ep)

        viewholder.textviewSoluong.text = "Số Lượng "+nuoc.soluong.toString()
        viewholder.textviewGiaNiemYet.text = "Giá "+nuoc.GiaNiemYet.toString()
        viewholder.textviewTongTien.text = "Tổng tiền "+(nuoc.soluong * nuoc.GiaNiemYet)
// thông báo xong đơn
        if (nuoc.Xong_Don == 0) {
            viewholder.textviewTB_Xong_Don.text = "Đã đặt nước "
        }
        if (nuoc.Xong_Don == 1){
            viewholder.textviewTB_Xong_Don.text = "Quầy đã làm xong nước "
        }
        if (nuoc.Xong_Don == 2){
            viewholder.textviewTB_Xong_Don.text = "Đã phục vụ xong "
        }
// thông báo thanh toán
        if (nuoc.thanhtoan == 0) {
            viewholder.textviewTB_thanhtoan.text = "Chưa thanh toán "
        }
        if (nuoc.thanhtoan == 1){
            viewholder.textviewTB_thanhtoan.text = "Đã thanh toán "
        }

        // Hiển thị nước đã làm xong và bưng chưa bưng lên cho khách
        viewholder.textviewTB_Xong_Don.setOnClickListener {
            Log.d("idDatnuoc", nuoc.idDatnuoc.toString())
            update_xongnuoc(2, nuoc.idDatnuoc)
            viewholder.textviewTB_Xong_Don.setTextColor(R.color.black)
            Toast.makeText(context, "Đã xác nhận", Toast.LENGTH_SHORT).show()
        }



        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewTenNuoc: TextView
        var image_nuoc: ImageView
        var textviewSoluong : TextView
        var textviewGiaNiemYet : TextView
        var textviewTongTien : TextView
        var textviewTB_Xong_Don: TextView
        var textviewTB_thanhtoan: TextView

        /* gán ánh xạ vào */
        init {
            textviewTenNuoc = row.findViewById(R.id.txt_nuoc)
            image_nuoc = row.findViewById(R.id.img_2)
            textviewSoluong = row.findViewById(R.id.Soluong)
            textviewGiaNiemYet = row.findViewById(R.id.GiaNiemYet)
            textviewTongTien = row.findViewById(R.id.Tongtien)
            textviewTB_Xong_Don = row.findViewById(R.id.TB_Xong_Don)
            textviewTB_thanhtoan = row.findViewById(R.id.TB_thanhtoan)
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
