package will.shiro.netflix_clone.main.presentation

import android.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.AndroidInjection
import will.shiro.netflix_clone.databinding.ActivityMainBinding
import javax.inject.Inject
import kotlin.math.min
import android.util.TypedValue
import will.shiro.netflix_clone.ext.toPx
import kotlin.math.max


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
        feedRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                binding.toolbarContainer.background = ColorDrawable(Color.BLACK).apply { alpha = getAlphaForAppBarLayout() }
                Log.d("WILLIAM", (-menuItemsHeight).toString())
                binding.toolbarContainer.y = max(-menuItemsHeight.toFloat(), originalY - binding.feedRecycler.computeVerticalScrollOffset().toFloat())
            }
        })
    }

    private fun setUpObservers() {
        viewModel.feedItems.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun getAlphaForAppBarLayout(): Int {
        return min(
            255f,
            (binding.feedRecycler.computeVerticalScrollOffset().toFloat() / featuredImageWidth.toFloat()) * 255
        ).toInt()
    }
}
