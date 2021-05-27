package com.example.coffeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeapp.PV.PhucvuActivity
import com.example.coffeapp.Quay.QuayActivity
import com.example.coffeapp.ThuNgan.ThunganActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        var intent2 = intent
        if (intent2 != null) {
            val idQuyen = intent2.getStringExtra("namequyen")

            var Quyen: String? = null
            if(idQuyen == "1") Quyen = "Nhân viên quầy"
            if(idQuyen == "2") Quyen = "Nhân viên phục vụ"
            if(idQuyen == "3") Quyen = "Nhân viên thu ngân"

            if(idQuyen == "1"){
                Toast.makeText(this, "Đăng nhập thành công idQuyen: ${idQuyen}=> ${Quyen}", Toast.LENGTH_LONG).show()
                Log.d("Test", "id Quyền ${idQuyen}")

                val intent = Intent(this, QuayActivity::class.java)
                intent.putExtra("idQuyen", idQuyen.toString())
                startActivity(intent)
            }
            if(idQuyen == "2"){
                Toast.makeText(this, "Đăng nhập thành công idQuyen: ${idQuyen}=> ${Quyen}", Toast.LENGTH_LONG).show()
                Log.d("Test", "id Quyền ${idQuyen}")

                val intent = Intent(this, PhucvuActivity::class.java)
                intent.putExtra("idQuyen", idQuyen.toString())
                startActivity(intent)
            }
            if(idQuyen == "3"){
                Toast.makeText(this, "Đăng nhập thành công idQuyen: ${idQuyen}=> ${Quyen}", Toast.LENGTH_LONG).show()
                Log.d("Test", "id Quyền ${idQuyen}")

                val intent = Intent(this, ThunganActivity::class.java)
                intent.putExtra("idQuyen", idQuyen.toString())
                startActivity(intent)
            }

        }
    }

//    fun PhucVu() {
//        startActivity(Intent(applicationContext, PhucvuActivity::class.java))
//    }
//
//    fun Quay(){
//        startActivity(Intent(applicationContext, QuayActivity::class.java))
  //      Toast.makeText(this, "Quầy", Toast.LENGTH_SHORT).show()
//    }
//
//    fun ThuNgan(){
//        startActivity(Intent(applicationContext, ThunganActivity::class.java))
//        Toast.makeText(this, "Thu Ngân", Toast.LENGTH_SHORT).show()
//    }

}