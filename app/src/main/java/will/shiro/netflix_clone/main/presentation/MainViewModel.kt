package will.shiro.netflix_clone.main.presentation

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import will.shiro.netflix_clone.ext.asLiveData
import will.shiro.netflix_clone.main.domain.entity.FeedFeaturedMovie
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _feedItems = MutableLiveData<List<FeedItem>>()

    val feedItems = _feedItems.asLiveData()

    fun getMovies() {
        _feedItems.postValue(
            listOf(
                FeedItem.FeaturedItem(
                    FeedFeaturedMovie(
                        "https://image.tmdb.org/t/p/w500/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
                        Color.parseColor("#FF35B8"),
                        listOf("Action", "Comedy", "Drama")
                    )
                )
            )
        )
    }
}