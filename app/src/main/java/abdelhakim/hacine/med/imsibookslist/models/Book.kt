package abdelhakim.hacine.med.imsibookslist.models

data class Book(
    val auteur: String,
    val cote: String,
    val domaine: String,
    val isbn: Any,
    val nbrexmpl: Int,
    val publication: Any,
    val stock: Int,
    val titre: String
)