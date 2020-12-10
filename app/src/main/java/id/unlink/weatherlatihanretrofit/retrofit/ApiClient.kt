package id.unlink.weatherlatihanretrofit.retrofit

import id.unlink.weatherlatihanretrofit.MainActivity.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit:Retrofit? = null
    fun getClient(baseUrl:String):Retrofit {
        if (retrofit == null)
        {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }


}