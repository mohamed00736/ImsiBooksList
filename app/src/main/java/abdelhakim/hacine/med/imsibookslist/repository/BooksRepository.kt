package abdelhakim.hacine.med.imsibookslist.repository

import abdelhakim.hacine.med.news_mvvm_coroutines.api.RetrofitInstance

class BooksRepository {

    suspend fun getBooksList() =
        RetrofitInstance.api.getBooksList()


}