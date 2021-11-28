package will.shiro.netflix_clone.main.data.service

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import will.shiro.netflix_clone.main.data.entity.ApiMovie
import will.shiro.netflix_clone.main.data.entity.ApiResult

typealias ObservableApiResponse<T> = Observable<Response<ApiResult<T>>>

interface MoviesService {

    @GET("movie/popular?language=en-US&region=US&page=1")
    fun fetchMoviesByType(): ObservableApiResponse<List<ApiMovie>>
}