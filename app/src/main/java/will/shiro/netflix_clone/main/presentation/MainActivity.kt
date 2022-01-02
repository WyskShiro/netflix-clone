package will.shiro.netflix_clone.main.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection
import will.shiro.netflix_clone.databinding.ActivityMainBinding
import will.shiro.netflix_clone.ext.toPx
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min


class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        FeedAdapter()
    }
    private val featuredImageWidth by lazy {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        displayMetrics.widthPixels
    }
    private val originalY by lazy {
        binding.toolbarContainer.y
    }
    private val menuItemsHeight by lazy {
        60.toPx
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpObservers()
        viewModel.getMovies()
    }

    private fun setUpUI() = binding.run {
        feedRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
        feedRecycler.adapter = adapter
        feedRecycler.addOnScrollListener(getFeedRecyclerScrollListener())
    }

    private fun setUpObservers() {
        viewModel.feedItems.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun getFeedRecyclerScrollListener(): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                with(binding.toolbarContainer) {
                    background = ColorDrawable(Color.BLACK).apply { alpha = getAlphaForAppBarLayout() }
                    y = max(-menuItemsHeight, originalY - binding.feedRecycler.computeVerticalScrollOffset().toFloat())
                }
            }
        }
    }

    private fun getAlphaForAppBarLayout(): Int {
        return min(
            255f,
            (binding.feedRecycler.computeVerticalScrollOffset().toFloat() / featuredImageWidth.toFloat()) * 255
        ).toInt()
    }
}
