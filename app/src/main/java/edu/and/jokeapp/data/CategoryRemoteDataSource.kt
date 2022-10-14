package edu.and.jokeapp.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callBack: ListCategoryCallBack) {
      HTTPClient.retrofit()
          .create(ChuckNorrisApi::class.java)
          .findAllCategories()
          .enqueue(object : Callback<List<String>> {

              override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                  if(response.isSuccessful) {
                      val categories = response.body()
                      callBack.onSuccess(categories ?: emptyList())
                  } else {
                      val error = response.errorBody()?.string()
                      callBack.onError(error ?: "ERRO DESCONHECIDO")
                  }
                  callBack.onComplete()
              }

              override fun onFailure(call: Call<List<String>>, t: Throwable) {
                  callBack.onError(t.message ?: "ERRO INTERNO!")
                  callBack.onComplete()
              }

          })
    }


}