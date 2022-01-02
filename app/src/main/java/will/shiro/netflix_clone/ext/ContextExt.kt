package will.shiro.netflix_clone.ext

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Context.readRawJson(@RawRes rawResId: Int): T {
    resources.openRawResource(rawResId).bufferedReader().use {
        return Gson().fromJson(it, object : TypeToken<T>() {}.type)
    }
}