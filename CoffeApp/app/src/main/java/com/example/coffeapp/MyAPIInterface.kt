package com.example.coffeapp

import com.example.coffeapp.Chat.OBJ_Chat
import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.ArrayList

interface MyAPIInterface {

    //Show dữ liệu bản User
    @GET("index.php?action=API_USER")
    fun getUsers(): Call<Any>
    @GET
    fun getUrl(@Url a:String): Call<ArrayList<OBJ_User>>


    //Show dữ liệu bản soban innerjoin
    @GET("index.php?action=API_SOBAN")
    fun getSoban(): Call<Any>
    @GET
    fun getUrl_soban(@Url a:String): Call<ArrayList<OBJ_Ban>>

    //Show dữ liệu bản soban không có innerjoin
    @GET("index.php?action=LAY_SOBAN")
    fun getSoban_Notjoin(): Call<Any>
    @GET
    fun getUrl_soban_notjoin(@Url a:String): Call<ArrayList<OBJ_BAN_notjion>>


    //Show dữ liệu bản nuoc
    @GET("index.php?action=API_NUOC")
    fun getNuoc(): Call<Any>
    @GET
    fun getUrl_nuoc(@Url a:String): Call<ArrayList<OBJ_Nuoc>>


    // Insert đặt nước
    @FormUrlEncoded
    @POST("index.php?action=insert_datnuoc")
    fun insert_datnuoc(
            @Field("idSoban") a: Int, @Field("idNuoc") b: Int, @Field("soluong") c: Int
            , @Field("ngay") d: String
    ): Call<Any>


    // delete
    @FormUrlEncoded
    @POST("index.php?action=delete_datnuoc")
    fun delete_datnuoc(
            @Field("idSoban") a: Int, @Field("idNuoc") b: Int, @Field("ngay") d: String
    ): Call<Any>


    //Show dữ liệu bản datnuoc
    @GET("index.php?action=API_datnuoc")
    fun getDatnuoc(): Call<Any>
    @GET
    fun getUrl_datnuoc(@Url a:String): Call<ArrayList<OBJ_Datnuoc>>


    // Update xong nước
    @FormUrlEncoded
    @POST("index.php?action=thanhtoan_datnuoc")
    fun update_datnuoc_tt(
            @Field("thanhtoan") a: Int, @Field("idDatnuoc") b: Int
    ): Call<Any>


    // Update đã phục vụ nước
    @FormUrlEncoded
    @POST("index.php?action=update_xongnuoc")
    fun update_xongnuoc(
            @Field("Xong_Don") a: Int, @Field("idDatnuoc") b: Int
    ): Call<Any>
    // số 0 là đã đặt nước, số 1 là quầy đã làm xong nước, số 2 là đã phục vụ nước cho khách hàng


    //Show dữ liệu bản datnuoc hôm nay
    @GET("index.php?action=HOMNAY_nuoc_giathanh")
    fun get_Homnay(): Call<Any>
    @GET
    fun getUrl_Homnay(@Url a:String): Call<ArrayList<OBJ_Giathanh>>

    //Show dữ liệu bản datnuoc tháng này
    @GET("index.php?action=THANGNAY_nuoc_giathanh")
    fun get_Thangnay(): Call<Any>
    @GET
    fun getUrl_Thangnay(@Url a:String): Call<ArrayList<OBJ_Giathanh>>

    //Show dữ liệu bản datnuoc tháng này
    @GET("index.php?action=NAMNAY_nuoc_giathanh")
    fun get_Namnay(): Call<Any>
    @GET
    fun getUrl_Namnay(@Url a:String): Call<ArrayList<OBJ_Giathanh>>


    //QUẦY

    //Show dữ liệu bản datnuoc tháng này
    @GET("index.php?action=NUOC_Canlam")
    fun get_Nuoc_canlam(): Call<Any>
    @GET
    fun getUrl_Nuoc_canlam(@Url a:String): Call<ArrayList<OBJ_Datnuoc>>



    // Update Xác nhận xong nước
    @FormUrlEncoded
    @POST("index.php?action=update_lam_xongnuoc")
    fun update_lam_xongnuoc(
            @Field("Xong_Don") a: Int, @Field("idDatnuoc") b: Int
    ): Call<Any>
    // số 0 là đã đặt nước, số 1 là quầy đã làm xong nước, số 2 là đã phục vụ nước cho khách hàng


    //Show cho quầy dữ liệu nước đã làm trong hôm nay
    @GET("index.php?action=nuoc_dalam_homnay")
    fun nuoc_dalam_homnay(): Call<Any>
    @GET
    fun getUrl_nuoc_dalam_homnay(@Url a:String): Call<ArrayList<OBJ_Datnuoc>>



//    CHAT

    //show all chat
    @GET("index.php?action=API_CHAT")
    fun all_chat(): Call<Any>
    @GET
    fun getUrl_allChat(@Url a:String): Call<ArrayList<OBJ_Chat>>


    // Insert Chat
    @FormUrlEncoded
    @POST("index.php?action=INSERT_CHAT")
    fun insert_chat(
            @Field("idQuyen") a: Int, @Field("NoiDung") b: String
    ): Call<Any>

    //HẾT CHAT

    //Show dữ liệu bản soban bên thu ngân select where
    @GET("index.php")
    fun get_Soban_thungan(@Query("idSoban") id:Int):  Call<ArrayList<OBJ_Datnuoc>>
    @GET
    fun getUrl_soban_notin(@Url a:String): Call<ArrayList<OBJ_Datnuoc>>



}