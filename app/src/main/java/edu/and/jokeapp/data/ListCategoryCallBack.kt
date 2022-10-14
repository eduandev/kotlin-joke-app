package edu.and.jokeapp.data

interface ListCategoryCallBack {

    fun onSuccess(response: List<String>)
    fun onError(message: String)
    fun onComplete()
}