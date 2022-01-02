package will.shiro.netflix_clone.main.presentation.horizontalmovies

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import will.shiro.netflix_clone.R
import will.shiro.netflix_clone.databinding.ItemListMovieBinding
import will.shiro.netflix_clone.main.domain.entity.Movie

class MovieViewHolder constructor(
    private val binding: ItemListMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setUp(movie: Movie) {
        Glide.with(binding.root.context)
            .load(movie.fullPosterPath)
            .placeholder(R.drawable.ic_three_dots_24)
            .apply(RequestOptions().transform(RoundedCorners(16)))
            .into(binding.movieImage)
    }
}