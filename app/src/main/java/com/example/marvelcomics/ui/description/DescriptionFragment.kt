package com.example.marvelcomics.ui.description

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.marvelcomics.R
import com.example.marvelcomics.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    val descriptionViewModel: DescriptionViewModel by viewModels()

    private val args by navArgs<DescriptionFragmentArgs>()

    lateinit var _bindingDescription: FragmentDescriptionBinding
    val bindingDescription: FragmentDescriptionBinding get() = _bindingDescription

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {

        _bindingDescription = FragmentDescriptionBinding.inflate(inflater, container, false)

        val comic = args.comic
        bindingDescription.comic = comic

        bindingDescription.viewModel = descriptionViewModel
        bindingDescription.lifecycleOwner = this

        descriptionViewModel.calculateInitPrice(comic.prices)

        bindingDescription.buttonCart.setOnClickListener {
            val price = (descriptionViewModel.price.value).toString()
            val plots = (descriptionViewModel.plots.value).toString()

            lifecycleScope.launch {
            val contComic = descriptionViewModel.checkComic(comic)
                if(contComic>0){
                    descriptionViewModel.updateFromComic(comic, price, plots)
                } else if (contComic == 0) {
                    descriptionViewModel.addCart(comic, price, plots)
                }
            }
        }

        setHasOptionsMenu(true)

        return bindingDescription.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

}