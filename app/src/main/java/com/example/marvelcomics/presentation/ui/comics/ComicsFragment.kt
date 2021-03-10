package com.example.marvelcomics.presentation.ui.comics

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.marvelcomics.R
import com.example.marvelcomics.databinding.FragmentComicsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    val adapterComics by lazy { ComicsAdapter() }

    val comicsViewModel: ComicsViewModel by viewModels()

    lateinit var _bindingComics: FragmentComicsBinding
    val bindingComics: FragmentComicsBinding get() = _bindingComics

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View {

        _bindingComics = FragmentComicsBinding.inflate(inflater, container, false)

        bindingComics.progressBar.progress

        setupRecyclerView()

        requestGetComics()

        setHasOptionsMenu(true)

        return bindingComics.root

    }

    private fun setupRecyclerView() {
        bindingComics.recyclerViewComics.adapter = adapterComics
    }

    private fun requestGetComics() {
        if (!comicsViewModel.hasInternetConnection()) {
            bindingComics.apply {
                bindingComics.progressBar.visibility = View.INVISIBLE
                imageNoConnection.visibility = View.VISIBLE
                textNoConnection.visibility = View.VISIBLE
            }

        } else {
            lifecycleScope.launch {
                comicsViewModel.getComics()
                comicsViewModel.comic.observe(viewLifecycleOwner, { comics ->
                    val comics = comics
                    adapterComics.submitList(comics)
                    bindingComics.progressBar.visibility = View.INVISIBLE
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.idShopping -> {
                findNavController().navigate(R.id.action_comicsFragment_to_cartFragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}