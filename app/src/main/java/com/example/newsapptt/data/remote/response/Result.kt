package com.example.newsapptt.data.remote.response

//Holds value or exception

sealed class Result<out R>{
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: String) : Result<Nothing>()

}
fun <T>Result<T>.successOr(fallback: T): T{
    return (this as? Result.Success<T>)?.data?: fallback
}