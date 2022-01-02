package will.shiro.netflix_clone.main.domain.entity

import com.google.gson.annotations.SerializedName

data class Movie constructor(
    @SerializedName("poster_path") val posterPath: String
) {

    val fullPosterPath get() = "https://image.tmdb.org/t/p/w500/$posterPath"
}