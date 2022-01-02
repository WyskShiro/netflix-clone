package will.shiro.netflix_clone.main.domain.usecase

import io.reactivex.Observable
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.domain.repository.MovieRepository
import javax.inject.Inject

class GetTop10UseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    fun execute(): Observable<FeedItem.MovieItem> {
        return movieRepository.getTop10()
    }
}