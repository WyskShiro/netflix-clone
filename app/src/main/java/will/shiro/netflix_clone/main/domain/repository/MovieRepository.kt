package will.shiro.netflix_clone.main.domain.repository

import io.reactivex.Observable
import will.shiro.netflix_clone.main.domain.entity.FeedItem

interface MovieRepository {

    fun getFeedFeatured(): Observable<FeedItem.FeaturedItem>
    fun getTop10(): Observable<FeedItem.MovieItem>
    fun getPopular(): Observable<FeedItem.MovieItem>
}