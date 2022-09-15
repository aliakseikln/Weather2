package com.example.weather2.domain.repository

import com.example.weather2.domain.util.Resource
import com.example.weather2.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}