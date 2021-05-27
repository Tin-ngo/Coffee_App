package com.example.coffeapp.Chat

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
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeapp.MyAPIInterface
import com.example.coffeapp.OBJ_Nuoc
import com.example.coffeapp.R
import kotlinx.android.synthetic.main.item_nuoc.view.*
import kotlinx.android.synthetic.main.phucvu_activity.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.ArrayList

class Adapter_ListChat(var context: Context, var mang_chat: ArrayList<OBJ_Chat>) : BaseAdapter() {


    override fun getCount(): Int {
        return mang_chat.size
    }

    override fun getItem(position: Int): Any {
        return mang_chat.get(position)
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
            view = layoutinflater.inflate(R.layout.chat_item_listview, null)

//            var ban : View = layoutinflater.inflate(R.layout.item_ban, parent, false)



            viewholder = ViewHolder(view)
            view.tag = viewholder /* Lưu các ánh xạ để cho lần run sau sửu dụng mà không cần khoải tạo lại */

        } else {  /* khi người dùng run lần 2 lần 3 thì lấy các giá trị đã lưu */
            view = convertView
            viewholder = convertView.tag as ViewHolder
        }

        /* gắn dữ liệu vào */
        var chat: OBJ_Chat = getItem(position) as OBJ_Chat
        viewholder.ImageUser.setImageResource(R.drawable.user)
        viewholder.textviewNoidungChat.text = chat.NoiDung
        if(chat.idQuyen.equals(1) == true) {
            viewholder.textviewNameUser.text = "Q"
        }else {
            if (chat.idQuyen.equals(2) == true) {
                viewholder.textviewNameUser.text = "PV" + chat.idQuyen
            }else {
                if (chat.idQuyen.equals(3) == true) {
                    viewholder.textviewNameUser.text = "TN"
                }
            }
        }


        return view as View
    }

    /* Tạo class khởi tạo các giá trị ánh xạ */
    class ViewHolder(row: View) {
        var ImageUser : ImageView
        var textviewNoidungChat: TextView
        var textviewNameUser: TextView

        /* gán ánh xạ vào */
        init {
            ImageUser = row.findViewById(R.id.img_user_chat) as ImageView
            textviewNoidungChat = row.findViewById(R.id.txt_noidungChat) as TextView
            textviewNameUser= row.findViewById(R.id.txt_name_user) as TextView
        }
    }





}
