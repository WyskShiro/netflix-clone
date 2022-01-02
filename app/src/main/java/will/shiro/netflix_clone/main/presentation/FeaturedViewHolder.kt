package will.shiro.netflix_clone.main.presentation

import com.bumptech.glide.Glide
import will.shiro.netflix_clone.databinding.ItemListFeaturedBinding
import will.shiro.netflix_clone.ext.BULLET_SEPARATOR
import will.shiro.netflix_clone.ext.parseBullets
import will.shiro.netflix_clone.main.domain.entity.FeedItem

class FeaturedViewHolder constructor(
    private val binding: ItemListFeaturedBinding
) : FeedViewHolder(binding.root) {

    fun setUp(featuredItem: FeedItem.FeaturedItem) {
        val (imageUrl, separatorColor, genres) = featuredItem.movie
        binding.genresText.text = genres.joinToString(" $BULLET_SEPARATOR ").parseBullets(separatorColor)
        Glide.with(binding.root.context)
            .load(imageUrl)
            .into(binding.movieImage)

        binding.watchButton.setOnClickListener {

        }
    }
}