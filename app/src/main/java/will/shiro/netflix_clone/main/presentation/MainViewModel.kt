package will.shiro.netflix_clone.main.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import will.shiro.netflix_clone.ext.addToDisposables
import will.shiro.netflix_clone.ext.asLiveData
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.domain.usecase.GetFeedFeaturedUseCase
import will.shiro.netflix_clone.main.domain.usecase.GetPopularUseCase
import will.shiro.netflix_clone.main.domain.usecase.GetTop10UseCase
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getFeedFeaturedUseCase: GetFeedFeaturedUseCase,
    private val getTop10UseCase: GetTop10UseCase,
    private val getPopularUseCase: GetPopularUseCase
) : ViewModel() {

    private val _feedItems = MutableLiveData<List<FeedItem>>()
    private val disposables = CompositeDisposable()

    val feedItems = _feedItems.asLiveData()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun getMovies() {
        Observable.combineLatest(
            arrayOf(
                getFeedFeaturedUseCase.execute(),
                getTop10UseCase.execute(),
                getPopularUseCase.execute()
            )
        ) { items: Array<in FeedItem> ->
            _feedItems.postValue(
                items.map { it as FeedItem }
            )
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}) {
                Log.d("MAIN_VIEW_MODEL", it.toString())
            }
            .addToDisposables(disposables)
    }
}