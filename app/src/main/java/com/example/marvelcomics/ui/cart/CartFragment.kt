package com.example.marvelcomics.ui.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.marvelcomics.R
import com.example.marvelcomics.data.model.Comic
import com.example.marvelcomics.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    val cartViewModel: CartViewModel by viewModels()

    lateinit var _bindingCart: FragmentCartBinding
    val bindingCart: FragmentCartBinding get() = _bindingCart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingCart = FragmentCartBinding.inflate(inflater, container, false)

        cartViewModel.getCart().observe(viewLifecycleOwner, {
            Log.d("Cart", it.toString())
        })

        return bindingCart.root

    }

}