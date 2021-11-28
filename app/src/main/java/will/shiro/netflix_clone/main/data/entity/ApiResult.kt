package will.shiro.netflix_clone.main.data.entity

import com.google.gson.annotations.SerializedName

data class ApiResult<T>(
    @SerializedName("results") val result: T? = null
)