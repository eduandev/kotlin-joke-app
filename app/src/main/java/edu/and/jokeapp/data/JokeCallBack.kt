package edu.and.jokeapp.data

import edu.and.jokeapp.model.Joke

interface JokeCallBack {

    fun onSuccess(response: Joke)
    fun onError(message: String)
    fun onComplete()
}