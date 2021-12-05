package will.shiro.netflix_clone.main.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.AndroidInjection
import will.shiro.netflix_clone.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        FeedAdapter()
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
    }

    private fun setUpObservers() {
        viewModel.feedItems.observe(this) {
            adapter.submitList(it)
        }
    }
}
