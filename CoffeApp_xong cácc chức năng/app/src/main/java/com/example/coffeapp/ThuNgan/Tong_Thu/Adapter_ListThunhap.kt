package com.example.coffeapp.ThuNgan.Tong_Thu

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.coffeapp.OBJ_Giathanh
import com.example.coffeapp.R

// lớp này hiển thị ra thông tin từng loại thu nhập của 3 loại vào trong từng dòng listview
//lớp này là lớp con của DialogFragment_Thungan vì lớp DialogFragment_Thungan gọi lớp này
class Adapter_ListThunhap(var context: Context, var mang_thunhap: ArrayList<OBJ_Giathanh>) : BaseAdapter() {

    override fun getCount(): Int {
        return mang_thunhap.size
    }

    override fun getItem(position: Int): Any {
        return mang_thunhap.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder
        /* trường hợp lần đầu tiên run thì convertview có giá trị là null => tạo các giá trị ánh xạ */
        if (convertView == null) {
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.tn_item_chitietthunhap, null)

            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* gắn dữ liệu vào */
        viewholder.textviewTenNuoc.text = mang_thunhap[position].tenNuoc.toString()
        viewholder.textviewGiaNiemYet.text = mang_thunhap[position].GiaNiemYet.toString()
        viewholder.textviewsoluong.text = "SL"+mang_thunhap[position].soluong.toString()

        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewTenNuoc: TextView
        var textviewGiaNiemYet : TextView
        var textviewsoluong : TextView

        /* gán ánh xạ vào */
        init {
            textviewTenNuoc = row.findViewById(R.id.txt_thunhap_giathanh_tennuoc)
            textviewGiaNiemYet = row.findViewById(R.id.txt_thunhap_giathanh_gianiemyet)
            textviewsoluong = row.findViewById(R.id.txt_thunhap_giathanh_soluong)
        }
    }




}
