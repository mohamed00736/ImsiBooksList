package abdelhakim.hacine.med.imsibookslist

import abdelhakim.hacine.med.imsibookslist.adapter.BooksAdapter
import abdelhakim.hacine.med.imsibookslist.models.BooksList
import abdelhakim.hacine.med.imsibookslist.repository.BooksRepository
import abdelhakim.hacine.med.news_mvvm_coroutines.ui.BooksViewModel
import abdelhakim.hacine.med.news_mvvm_coroutines.ui.BooksViewModelProviderFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: BooksViewModel
    lateinit var booksAdapter: BooksAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val booksRepos = BooksRepository()
        val viewModelProviderFactory = BooksViewModelProviderFactory(booksRepos)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(BooksViewModel::class.java)

        setupRecyclerView()


        viewModel.bookslist.observe(this , Observer { response ->

           var statisSucces = response.isSuccessful

            when(statisSucces){

                true -> {
                    showProgressBar()

                    hideProgressBar()
                        response.body()?.items.let { booksrespons ->
                            booksAdapter.differ.submitList(booksrespons)
                        }
                }

                false ->{




                }


            }







        })
    }





















    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        booksAdapter = BooksAdapter()
        rvBooksList.apply {
            adapter = booksAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}