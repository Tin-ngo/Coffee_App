package com.example.coffeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
//https://admincoffeapp.000webhostapp.com/
    val BASE_URL = "http://10.0.2.2/Android/CoffeApp/Admin/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myRetrofitAPI: MyAPIInterface = retrofit.create<MyAPIInterface>(
        MyAPIInterface::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun onLogin(v: View){        //https://admincoffeapp.000webhostapp.com/index.php?action=API_USER
        myRetrofitAPI.getUrl("http://10.0.2.2/Android/CoffeApp/Admin/index.php?action=API_USER")?.enqueue(
                object :
                        Callback<ArrayList<OBJ_User>> {
                    override fun onFailure(call: Call<ArrayList<OBJ_User>>, t: Throwable) {
                        Log.d("onFailure API call", "error")
                    }
                    override fun onResponse(
                            call: Call<ArrayList<OBJ_User>>?,
                            response: Response<ArrayList<OBJ_User>>?
                    ) {
                        response?.let {
                            if (response?.isSuccessful) {
                                var i = 0
                                while (i < response.body().size) {
                                    Log.d(
                                            "User ", response.body().get(i).tendangnhap.toString() +
                                            "  " + response.body().get(i).matkhau +
                                            " Quyền " + response.body().get(i).idQuyen
                                    )
                                    var u = edt_login_user.text.toString()
                                    var p = edt_login_pass.text.toString()

                                    if (u.equals(response.body().get(i).tendangnhap) && p.equals(response.body().get(i).matkhau)) {
                                        //gửi idQuyen để bên HomeActivity xét xử
                                        val idQuyen = response.body().get(i).idQuyen
                                        val intent1 = Intent(applicationContext, HomeActivity::class.java)
                                        intent1.putExtra("namequyen", idQuyen.toString())
                                        startActivity(intent1)
//                                    finish()

                                        //Xác nhận đã nhập đúng tài khoản và thoát khỏi vòng lặp
                                        Log.d("Login", "true")
//                                        Toast.makeText(this@MainActivity, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
                                        break
                                    } else
                                        i++
                                }
                            } else {
                                Log.d("API call", "failed")
                            }
                        }
                    }
                })
    }



}