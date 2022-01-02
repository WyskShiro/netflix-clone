package will.shiro.netflix_clone.main.presentation.horizontalmovies

import androidx.recyclerview.widget.LinearLayoutManager
import will.shiro.netflix_clone.databinding.ItemListHorizontalMoviesBinding
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.presentation.FeedViewHolder

class HorizontalMoviesViewHolder constructor(
    private val binding: ItemListHorizontalMoviesBinding
) : FeedViewHolder(binding.root) {

    private val adapter by lazy {
        HorizontalMoviesAdapter()
    }

    fun setUp(featuredItem: FeedItem.MovieItem) {
        binding.headerTitle.text = featuredItem.header
        binding.moviesRecycler.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.moviesRecycler.adapter = adapter
        adapter.submitList(featuredItem.movies)
    }
}