package will.shiro.netflix_clone.di

import dagger.Binds
import dagger.Module
import will.shiro.netflix_clone.main.data.repository.MovieRepositoryImpl
import will.shiro.netflix_clone.main.domain.repository.MovieRepository

@Module
interface RepositoryModule {

    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}