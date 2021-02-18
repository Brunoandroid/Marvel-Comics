package com.example.marvelcomics.ui.comics

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? {

        _bindingComics = FragmentComicsBinding.inflate(inflater, container, false)

        bindingComics.recyclerViewComics.showShimmer()

        setupRecyclerView()

        requestGetComics()

        setHasOptionsMenu(true)

        return bindingComics.root

    }

    private fun setupRecyclerView() {
        bindingComics.recyclerViewComics.adapter = adapterComics
        bindingComics.recyclerViewComics.showShimmer()
    }

    private fun requestGetComics() {
        if(!comicsViewModel.hasInternetConnection()){
            bindingComics.apply {
                recyclerViewComics.hideShimmer()
                imageNoConnection.visibility = View.VISIBLE
                textNoConnection.visibility = View.VISIBLE
            }

        }else {
            lifecycleScope.launch {
                comicsViewModel.getComics(20)
                comicsViewModel.comic.observe(viewLifecycleOwner, { comics ->
                    val comics = comics.body()!!.data.comics
                    adapterComics.setListComics(comics)
                    bindingComics.recyclerViewComics.hideShimmer()
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }
}