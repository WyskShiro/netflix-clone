package will.shiro.netflix_clone.main.presentation.horizontalmovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import will.shiro.netflix_clone.databinding.ItemListMovieBinding
import will.shiro.netflix_clone.main.domain.entity.Movie

class HorizontalMoviesAdapter : ListAdapter<Movie, MovieViewHolder>(HorizontalMoviesDiffUtil()) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setUp(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}

class HorizontalMoviesDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.posterPath == newItem.posterPath
    }
}