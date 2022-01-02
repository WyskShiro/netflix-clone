package will.shiro.netflix_clone.ext

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addToDisposables(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> T.toObservable(): Observable<T> {
    return Observable.just(this)
}