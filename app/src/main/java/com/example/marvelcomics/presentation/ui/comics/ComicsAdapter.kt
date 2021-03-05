package com.example.marvelcomics.presentation.ui.comics

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.databinding.RowItemComicsBinding

class ComicsAdapter : RecyclerView.Adapter<ComicsAdapter.ComicsViewHolder>() {

    var list: List<Comic> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val binding =
            RowItemComicsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ComicsViewHolder(private val binding: RowItemComicsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comic: Comic) {
            binding.comic = comic
            binding.cardRowItem.setOnClickListener {
                val action =
                    ComicsFragmentDirections.actionComicsFragmentToDescriptionFragment(comic)
                binding.cardRowItem.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun setListComics(listComics: List<Comic>) {
        this.list = listComics
        notifyDataSetChanged()
    }

}