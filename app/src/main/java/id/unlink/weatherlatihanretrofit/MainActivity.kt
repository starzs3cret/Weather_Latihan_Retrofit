package id.unlink.weatherlatihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.unlink.weatherlatihanretrofit.databinding.ActivityMainBinding
import id.unlink.weatherlatihanretrofit.model.WeatherData
import id.unlink.weatherlatihanretrofit.retrofit.ApiService
import id.unlink.weatherlatihanretrofit.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mApiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        // load tapi kepriwe njir?????
        mApiService = ApiUtils.apiService

    }

    override fun onStart() {
        super.onStart()
        mApiService.getCurrentWeatherData(CITY, APP_ID, UNITS).enqueue(object : Callback<WeatherData>{
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.code()==200){
                    // ok gaes
                    buildResponse(response.body())
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {

            }

        })
    }

    private fun buildResponse(weatherResponse: WeatherData?) {
        val temperature = weatherResponse?.main!!.temp
        val stringBuilder = "Country: " +
                weatherResponse.sys.country +
                "\n" +
                "Temperature: " +
                weatherResponse.main.temp +
                "\n" +
                "Temperature(Min): " +
                weatherResponse.main.temp_min +
                "\n" +
                "Temperature(Max): " +
                weatherResponse.main.temp_max +
                "\n" +
                "Humidity: " +
                weatherResponse.main.humidity +
                "\n" +
                "Pressure: " +
                weatherResponse.main.pressure
        binding.txMain.text = stringBuilder
    }

    companion object{
        val BASE_URL = "https://api.openweathermap.org/"
        val APP_ID = "b32d480065846e8735df7dff37346b88"
        val CITY = "Kroya,ID"
        val UNITS = "metric"
    }
}