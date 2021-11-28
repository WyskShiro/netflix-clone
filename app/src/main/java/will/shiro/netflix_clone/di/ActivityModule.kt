package will.shiro.netflix_clone.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import will.shiro.netflix_clone.main.presentation.MainActivity

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity
}