package will.shiro.netflix_clone.ext

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt

const val BULLET_SEPARATOR = '•'

fun String.parseBullets(@ColorInt color: Int): Spannable {
    val spannableString = SpannableString(this)

    forEachIndexed { i, c ->
        if (c == BULLET_SEPARATOR) {
            spannableString.setSpan(ForegroundColorSpan(color), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
    return spannableString
}