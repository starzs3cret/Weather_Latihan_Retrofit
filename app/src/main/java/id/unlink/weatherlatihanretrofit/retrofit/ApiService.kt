package id.unlink.weatherlatihanretrofit.retrofit

import id.unlink.weatherlatihanretrofit.model.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("q") q:String, @Query("APPID") app_id: String,@Query("units") units:String): Call<WeatherData>
}