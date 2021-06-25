package com.example.coffeapp.PV.Order


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coffeapp.OBJ_BAN_notjion
import com.example.coffeapp.OBJ_Ban
import com.example.coffeapp.OBJ_Datnuoc
import com.example.coffeapp.PV.Order_Xong.CustomAdapter_Datnuoc
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.phucvu_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

// lớp này để hiển thị ra danh sách các bàn
// PhucvuActivity gọi lớp này
class CustomAdapter(var context : Context, var mang_ban : ArrayList<OBJ_Ban>) : BaseAdapter() {
    override fun getCount(): Int {
        return mang_ban.size
    }

    override fun getItem(position: Int): Any {
        return mang_ban.get(position)
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
            view = layoutinflater.inflate(R.layout.item_ban, null)
            viewholder = ViewHolder(view)

            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder

        }

        /* gawsn dữ liệu vào */
        var ban: OBJ_Ban = getItem(position) as OBJ_Ban
        viewholder.textviewtenmonan.text = ban.idSoban.toString()
        viewholder.imageviewmonan.setImageResource(ban.hinhanh)



        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewtenmonan: TextView
        var imageviewmonan: ImageView
        /* gán ánh xạ vào */
        init {
            textviewtenmonan = row.findViewById(R.id.id_ban) as TextView
            imageviewmonan = row.findViewById(R.id.image_ban) as ImageView
        }
    }


}
