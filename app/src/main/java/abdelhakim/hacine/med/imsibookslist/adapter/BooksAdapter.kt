package abdelhakim.hacine.med.imsibookslist.adapter


import abdelhakim.hacine.med.imsibookslist.R
import abdelhakim.hacine.med.imsibookslist.models.Book
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_book.view.*


class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.titre == newItem.titre
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Book) -> Unit)? = null

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val boook = differ.currentList[position]
        holder.itemView.apply {
            //Glide.with(this).load(article.urlToImage).into(ivArticleImage)
            tvPublishedAt.text = boook.publication.toString()
            tvTitle.text = boook.titre
            tvdomain.text = boook.domaine
            tvauteur.text = boook.auteur

            setOnClickListener {
                onItemClickListener?.let { it(boook) }
            }
        }
    }

    fun setOnItemClickListener(listener: (Book) -> Unit) {
        onItemClickListener = listener
    }
}













