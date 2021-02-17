package com.example.marvelcomics.ui.comics

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.marvelcomics.databinding.FragmentComicsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    val comicsViewModel: ComicsViewModel by viewModels()

    lateinit var _bindingComics: FragmentComicsBinding
    val bindingComics: FragmentComicsBinding get() = _bindingComics

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? {

        _bindingComics = FragmentComicsBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            comicsViewModel.getComics(15)
            comicsViewModel.comics.observe(viewLifecycleOwner, {
                Log.d("Comics", it.body()!!.data.results[14].title)
            })
        }


        return bindingComics.root

    }

}