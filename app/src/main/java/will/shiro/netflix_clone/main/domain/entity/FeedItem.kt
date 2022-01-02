package will.shiro.netflix_clone.main.domain.entity

sealed class FeedItem {

    abstract fun <T : FeedItem> itemsAreSameVisually(other: T): Boolean

    class FeaturedItem(val movie: FeaturedMovie) : FeedItem() {
        override fun <T : FeedItem> itemsAreSameVisually(other: T): Boolean {
            if (other !is FeaturedItem) return false
            return movie == other.movie
        }
    }

    class MovieItem(val header: String, val movies: List<Movie>) : FeedItem() {
        override fun <T : FeedItem> itemsAreSameVisually(other: T): Boolean {
            if (other !is MovieItem) return false
            return movies == other.movies && header == other.header
        }
    }
}