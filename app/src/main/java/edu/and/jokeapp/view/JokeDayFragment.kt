package edu.and.jokeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import edu.and.jokeapp.R
import edu.and.jokeapp.model.Joke
import edu.and.jokeapp.presentation.JokeDayPresenter

class JokeDayFragment : Fragment() {

    private lateinit var txtJokeDay: TextView
    private lateinit var imgJokeDay: ImageView
    private lateinit var presenterDay: JokeDayPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterDay = JokeDayPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_joke_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtJokeDay = view.findViewById(R.id.txt_joke_day)
        imgJokeDay = view.findViewById(R.id.img_joke_day)

        presenterDay.findJokeDay()
    }

    fun showJoke(joke: Joke) {
        txtJokeDay.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imgJokeDay)
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}