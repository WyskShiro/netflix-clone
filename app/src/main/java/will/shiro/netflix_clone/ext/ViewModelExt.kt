package will.shiro.netflix_clone.ext

import android.app.Application
import androidx.annotation.RawRes
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> AndroidViewModel.readRawJson(@RawRes rawResId: Int): T {
    getApplication<Application>().resources.openRawResource(rawResId).bufferedReader().use {
        return Gson().fromJson(it, object : TypeToken<T>() {}.type)
    }
}