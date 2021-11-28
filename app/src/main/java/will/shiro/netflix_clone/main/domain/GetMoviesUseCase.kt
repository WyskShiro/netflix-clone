package will.shiro.netflix_clone.main.domain

import javax.inject.Inject

class GetMoviesUseCase @Inject constructor() {

    fun execute(): List<String> {
        return listOf("a")
    }
}