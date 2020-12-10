package id.unlink.weatherlatihanretrofit.retrofit

import id.unlink.weatherlatihanretrofit.MainActivity.Companion.BASE_URL

object ApiUtils {


    val apiService: ApiService
        get() {
            return ApiClient.getClient(BASE_URL).create(ApiService::class.java)
        }
}