package will.shiro.netflix_clone.main.domain.entity

sealed class FeedItem {

    abstract fun <T : FeedItem> itemsAreSameVisually(other: T): Boolean

    class FeaturedItem(val movie: FeedFeaturedMovie) : FeedItem() {
        override fun <T : FeedItem> itemsAreSameVisually(other: T): Boolean {
            if (other !is FeaturedItem) return false
            return movie == other.movie
        }
    }
}