package abdelhakim.hacine.med.news_mvvm_coroutines.ui


import abdelhakim.hacine.med.imsibookslist.models.BooksList
import abdelhakim.hacine.med.imsibookslist.repository.BooksRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import retrofit2.Response

class BooksViewModel(
    val booksRepository: BooksRepository
) : ViewModel() {

    val bookslist: MutableLiveData<Response<BooksList>> = MutableLiveData()
    var breakingNewsPage = 1


    init {
        getBooksList()
    }

    fun getBooksList() = viewModelScope.launch {

        val response = booksRepository.getBooksList()
        bookslist.postValue(response)
    }


//    fun saveArticle(article: Article) = viewModelScope.launch {
//        newsRepository.upsert(article)
//    }
//
//    fun getSavedNews() = newsRepository.getSavedNews()
//
//    fun deleteArticle(article: Article) = viewModelScope.launch {
//        newsRepository.deleteArticle(article)
//    }
}












