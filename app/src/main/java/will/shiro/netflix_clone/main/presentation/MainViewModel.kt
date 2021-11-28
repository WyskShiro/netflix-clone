package will.shiro.netflix_clone.main.presentation

import androidx.lifecycle.ViewModel
import will.shiro.netflix_clone.main.domain.usecase.GetMoviesUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    fun getMovies() {
        getMoviesUseCase.execute()
    }
}