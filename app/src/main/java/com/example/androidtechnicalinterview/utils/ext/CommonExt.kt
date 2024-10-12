package com.example.androidtechnicalinterview.utils.ext

import com.example.androidtechnicalinterview.domain.model.networkResult.NetworkResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException


/**Convert simple object to String with Gson*/
inline fun <reified T : Any> T.toSimpleJson() : String =  Gson().toJson(this, T::class.java)

/**Convert String Json to Object*/
inline fun <reified T : Any> String.fromJsonToObject() : T =  Gson().fromJson(this ,  T::class.java)

/**Convert String List Json to Object*/
inline fun <reified T : Any> String.fromJsonToObjectList() : MutableList <T> =  when( this.isNotEmpty()){
    true -> Gson().fromJson(this, object : TypeToken<MutableList<T>>() {}.type)
    false -> mutableListOf()
}

fun JSONArray.toMutableList(): MutableList<Any> = MutableList(length(), this::get)

inline fun <T> safeNetworkCall(action: () -> NetworkResult<T>): NetworkResult<T> {
    return try {
        action()
    } catch (e: Exception) {
        e.printStackTrace()
        NetworkResult.Failure(message = e.getThrowableError(), throwable = e)
    }
}

fun Throwable.getThrowableError(): String {
    when (this) {
        is HttpException -> {
            /*val responseBody = this.response()?.errorBody()
            responseBody?.let {
                return getErrorMessage(it)
            }*/
            return this.message!!
        }
        is SocketTimeoutException -> return this.message!!
        is IOException -> return this.message!!
        else -> return this.message!!
    }
    return ""
}
