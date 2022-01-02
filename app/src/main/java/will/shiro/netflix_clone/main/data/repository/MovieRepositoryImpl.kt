package will.shiro.netflix_clone.main.data.repository

import android.content.Context
import android.graphics.Color
import io.reactivex.Observable
import will.shiro.netflix_clone.R
import will.shiro.netflix_clone.ext.readRawJson
import will.shiro.netflix_clone.ext.toObservable
import will.shiro.netflix_clone.main.domain.entity.FeaturedMovie
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    val context: Context
) : MovieRepository {

    override fun getFeedFeatured(): Observable<FeedItem.FeaturedItem> {
        return FeedItem.FeaturedItem(
            FeaturedMovie(
                "https://image.tmdb.org/t/p/w500/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
                Color.parseColor("#FF35B8"),
                listOf("Action", "Comedy", "Drama")
            )
        ).toObservable()
    }

    override fun getTop10(): Observable<FeedItem.MovieItem> {
        return FeedItem.MovieItem(
            "Top 10",
            context.readRawJson(R.raw.popular)
        ).toObservable()
    }

    override fun getPopular(): Observable<FeedItem.MovieItem> {
        return FeedItem.MovieItem(
            "Popular",
            context.readRawJson(R.raw.popular)
        ).toObservable()
    }
}