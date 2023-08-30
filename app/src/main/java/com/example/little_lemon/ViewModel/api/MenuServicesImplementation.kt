package com.example.little_lemon.ViewModel.api

import android.view.MenuItem
import com.example.little_lemon.Model.MenuResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class MenuServicesImplementation(
    private val menuRepo:MenuServiceInterface=RetrofitObject.menuRepository
) {

    suspend fun getMenuItems(): Flow<Resource<MenuResponse>> {
        return flow {

            emit(Resource.Loading(true))
            val response = try {
                menuRepo.getMenuItems()
            } catch (e: HttpException) {
                emit(Resource.Error(e.message.toString()))
                null
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
                null
            }

            response?.let {
                emit(Resource.Success(data = response))
                emit(Resource.Loading(false))
            }

            emit((Resource.Loading(false)))


        }
    }
}