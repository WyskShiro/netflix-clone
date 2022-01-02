package will.shiro.netflix_clone.main.domain.entity

import androidx.annotation.ColorInt

data class FeaturedMovie constructor(
    val image: String,
    @ColorInt
    val separatorColor: Int,
    val genres: List<String>
)