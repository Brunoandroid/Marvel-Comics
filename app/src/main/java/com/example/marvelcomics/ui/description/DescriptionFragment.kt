package com.example.marvelcomics.ui.description

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
            addCart()
        }

        bindingDescription.buttonPurchase.setOnClickListener {
            purchase()
        }

        setHasOptionsMenu(true)

        return bindingDescription.root

    }

    fun addCart() {
        val price = (descriptionViewModel.price.value).toString()
        val plots = (descriptionViewModel.plots.value).toString()

        lifecycleScope.launch {
            val contComic = descriptionViewModel.checkComic(args.comic)
            if (contComic > 0) {
                descriptionViewModel.updateFromComic(args.comic, price, plots)
                Toast.makeText(requireContext(), "Item atualizado com sucesso", Toast.LENGTH_SHORT)
                    .show()
                backComics()
            } else if (contComic == 0) {
                descriptionViewModel.addCart(args.comic, price, plots)
                Toast.makeText(requireContext(), "Item adicionado com sucesso", Toast.LENGTH_SHORT)
                    .show()
                backComics()
            }
        }
    }

    private fun backComics() {
        findNavController().navigate(R.id.action_descriptionFragment_to_comicsFragment)
    }

    private fun purchase() {
        findNavController().navigate(R.id.action_descriptionFragment_to_cartFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

}