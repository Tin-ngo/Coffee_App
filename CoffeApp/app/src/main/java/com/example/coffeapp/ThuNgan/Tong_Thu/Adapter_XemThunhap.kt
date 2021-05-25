package com.example.coffeapp.ThuNgan.Tong_Thu


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.coffeapp.OBJ_Ban

import com.example.coffeapp.R

import java.util.ArrayList

// chỉ dùng để hiển thị ra hôm nay, tháng này, năm này
class Adapter_XemThunhap(var context : Context, var mang_thunhap : ArrayList<OBJ_XemThunhap>) : BaseAdapter() {

    override fun getCount(): Int {
        return mang_thunhap.size
    }

    override fun getItem(position: Int): Any {
        return mang_thunhap.get(position)
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
            view = layoutinflater.inflate(R.layout.tn_item_loaithunhap, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }
        var thunhap: OBJ_XemThunhap = getItem(position) as OBJ_XemThunhap
        viewholder.textviewThunhap.text = thunhap.loai_ngay.toString()


        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var textviewThunhap: TextView

        /* gán ánh xạ vào */
        init {
            textviewThunhap = row.findViewById(R.id.tn_txt_thunhap) as TextView
        }
    }




}
