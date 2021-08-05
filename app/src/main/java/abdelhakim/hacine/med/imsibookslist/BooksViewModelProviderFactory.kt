package abdelhakim.hacine.med.news_mvvm_coroutines.ui

import abdelhakim.hacine.med.imsibookslist.repository.BooksRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BooksViewModelProviderFactory(
    val booksRepository: BooksRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BooksViewModel(booksRepository) as T
    }
}