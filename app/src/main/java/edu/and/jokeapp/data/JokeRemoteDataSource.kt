package edu.and.jokeapp.data

import edu.and.jokeapp.model.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException

class JokeRemoteDataSource {

    fun findBy(categoryName: String, callBack: JokeCallBack) {
        HTTPClient.retrofit()
        .create(ChuckNorrisApi::class.java)
        .findBy(categoryName).enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful) {
                        val joke = response.body()
                        callBack.onSuccess(joke ?: throw RuntimeException("Piada não encontrada!"))
                    } else {
                        val error = response.errorBody()?.string()
                        callBack.onError(error ?: "ERRO DESCONHECIDO")
                    }
                    callBack.onComplete()
                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callBack.onError(t.message ?: "ERRO INTERNO!")
                    callBack.onComplete()

                }

            })
    }

    fun findByJokeDay(callDay: JokeCallBack) {
        HTTPClient.retrofit()
        .create(ChuckNorrisApi::class.java)
        .findBy().enqueue(object : Callback<Joke> {
                override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                    if(response.isSuccessful) {
                        val joke = response.body()
                        callDay.onSuccess(joke ?: throw RuntimeException("Piada não encontrada!"))
                    } else {
                        val error = response.errorBody()?.string()
                        callDay.onError(error ?: "ERRO DESCONHECIDO")
                    }

                }

                override fun onFailure(call: Call<Joke>, t: Throwable) {
                    callDay.onError(t.message ?: "ERRO INTERNO!")

                }

            })

    }

}