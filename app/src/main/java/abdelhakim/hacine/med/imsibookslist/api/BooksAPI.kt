package abdelhakim.hacine.med.news_mvvm_coroutines.api

import abdelhakim.hacine.med.imsibookslist.models.BooksList
import retrofit2.Response
import retrofit2.http.GET


interface BooksAPI {


    //get list of books from spredsheet
    @GET("/macros/s/AKfycbxkMBc9UqxmHpzx3PWIGGyA-cIWo_1BhBoEQRr3cd2KAjeiMKmsWOs6hSWbbPfsgZXtEg/exec?action=read_user_details")
    suspend fun getBooksList(): Response<BooksList>


}