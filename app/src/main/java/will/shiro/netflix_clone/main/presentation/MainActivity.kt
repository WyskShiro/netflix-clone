package will.shiro.netflix_clone.main.presentation

import android.R
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import will.shiro.netflix_clone.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getMovies()


//        val toolbar = binding.toolbar
//        setSupportActionBar(toolbar)
//        val coll_toolbar = binding.collapsingToolbar
//        coll_toolbar.title = "Test Title"
////        coll_toolbar.setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)
////        coll_toolbar.setExpandedTitleTextAppearance(R.style.exp_toolbar_title)
//        coll_toolbar.setContentScrimColor(Color.GREEN)
    }
}
