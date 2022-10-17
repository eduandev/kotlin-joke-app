package edu.and.jokeapp.presentation

import edu.and.jokeapp.view.JokeDayFragment
import edu.and.jokeapp.data.JokeCallBack
import edu.and.jokeapp.data.JokeRemoteDataSource
import edu.and.jokeapp.model.Joke

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallBack{

    fun findJokeDay() {
        dataSource.findByJokeDay(this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
    }
}