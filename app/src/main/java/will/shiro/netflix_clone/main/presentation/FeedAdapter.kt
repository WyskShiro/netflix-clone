package will.shiro.netflix_clone.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import will.shiro.netflix_clone.databinding.ItemListFeaturedBinding
import will.shiro.netflix_clone.databinding.ItemListHorizontalMoviesBinding
import will.shiro.netflix_clone.main.domain.entity.FeedItem
import will.shiro.netflix_clone.main.presentation.featured.FeaturedViewHolder
import will.shiro.netflix_clone.main.presentation.horizontalmovies.HorizontalMoviesViewHolder

private const val FEATURED_VIEW_TYPE = 0
private const val TOP_10_VIEW_TYPE = 1

class FeedAdapter : ListAdapter<FeedItem, FeedViewHolder>(FeedDiffUtil()) {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is FeedItem.FeaturedItem -> FEATURED_VIEW_TYPE
            is FeedItem.MovieItem -> TOP_10_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return when (viewType) {
            FEATURED_VIEW_TYPE -> {
                FeaturedViewHolder(
                    ItemListFeaturedBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TOP_10_VIEW_TYPE -> {
                HorizontalMoviesViewHolder(
                    ItemListHorizontalMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                HorizontalMoviesViewHolder(
                    ItemListHorizontalMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        when (holder) {
            is FeaturedViewHolder -> holder.setUp(getItem(position) as FeedItem.FeaturedItem)
            is HorizontalMoviesViewHolder -> holder.setUp(getItem(position) as FeedItem.MovieItem)
        }
    }
}

class FeedDiffUtil : DiffUtil.ItemCallback<FeedItem>() {
    override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
        return oldItem.itemsAreSameVisually(newItem)
    }
}