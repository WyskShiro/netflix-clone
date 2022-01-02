package will.shiro.netflix_clone.main.presentation

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import will.shiro.netflix_clone.R
import will.shiro.netflix_clone.ext.asLiveData
import will.shiro.netflix_clone.main.domain.entity.FeaturedMovie
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.domain.usecase.GetMoviesUseCase
import javax.inject.Inject
import will.shiro.netflix_clone.ext.readRawJson
import will.shiro.netflix_clone.main.domain.entity.Movie


class MainViewModel @Inject constructor(
    application: Application,
    private val getMoviesUseCase: GetMoviesUseCase
) : AndroidViewModel(application) {

    private val _feedItems = MutableLiveData<List<FeedItem>>()

    val feedItems = _feedItems.asLiveData()

    fun getMovies() {
        _feedItems.postValue(
            listOf(
                getFeedFeatured(),
                getTop10(),
                getPopular(),
                getTop10(),
                getPopular()
            )
        )
    }

    private fun getFeedFeatured(): FeedItem.FeaturedItem {
        getTop10()
        return FeedItem.FeaturedItem(
            FeaturedMovie(
                "https://image.tmdb.org/t/p/w500/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
                Color.parseColor("#FF35B8"),
                listOf("Action", "Comedy", "Drama")
            )
        )
    }

    private fun getTop10(): FeedItem.MovieItem {
        return FeedItem.MovieItem(
            "Top 10",
            readRawJson(R.raw.popular)
        )
    }

    private fun getPopular(): FeedItem.MovieItem {
        return FeedItem.MovieItem(
            "Popular",
            readRawJson(R.raw.popular)
        )
    }
}