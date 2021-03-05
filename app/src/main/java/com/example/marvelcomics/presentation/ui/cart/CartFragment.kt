package com.example.marvelcomics.presentation.ui.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.marvelcomics.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    val adapter by lazy { CartAdapter() }

    val cartViewModel: CartViewModel by viewModels()

    lateinit var _bindingCart: FragmentCartBinding
    val bindingCart: FragmentCartBinding get() = _bindingCart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingCart = FragmentCartBinding.inflate(inflater, container, false)

        bindingCart.recyclerView.adapter = adapter

        cartViewModel.getCart().observe(viewLifecycleOwner, { cartComic ->
            adapter.setListCartComics(cartComic)
        })

        return bindingCart.root

    }

}