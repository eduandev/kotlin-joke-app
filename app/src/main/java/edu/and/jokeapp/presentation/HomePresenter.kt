package edu.and.jokeapp.presentation

import android.graphics.Color
import edu.and.jokeapp.data.CategoryRemoteDataSource
import edu.and.jokeapp.data.ListCategoryCallBack
import edu.and.jokeapp.model.Category
import edu.and.jokeapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource) : ListCategoryCallBack {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onSuccess(response: List<String>) {

        val start = 40 // matriz
        val end = 190 // matriz
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}