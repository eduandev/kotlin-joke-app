package edu.and.jokeapp.presentation

import edu.and.jokeapp.data.JokeCallBack
import edu.and.jokeapp.data.JokeRemoteDataSource
import edu.and.jokeapp.model.Joke
import edu.and.jokeapp.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallBack{

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}