package com.example.weather2.data.repopsitory

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weather2.data.mappers.toWeatherInfo
import com.example.weather2.data.remoute.WeatherApi
import com.example.weather2.domain.repository.WeatherRepository
import com.example.weather2.domain.util.Resource
import com.example.weather2.domain.weather.WeatherInfo
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}