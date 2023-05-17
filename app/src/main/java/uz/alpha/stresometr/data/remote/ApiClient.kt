package uz.alpha.stresometr.data.remote

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.alpha.stresometr.app.App
import java.util.concurrent.TimeUnit

object ApiClient {

//    private val myClient = OkHttpClient.Builder()
//        .addInterceptor(ChuckInterceptor(App.context))
//        .readTimeout(60, TimeUnit.SECONDS)
//        .connectTimeout(60, TimeUnit.SECONDS)
//        .build()
//

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.43:6788/")
    //    .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofit2: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.100.12:6788/")
    //    .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMedApi(): MedService = retrofit.create(MedService::class.java)
    fun getMedApi2(): MedService = retrofit2.create(MedService::class.java)

}