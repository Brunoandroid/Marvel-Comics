package com.example.marvelcomics.ui.description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.marvelcomics.R
import com.example.marvelcomics.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : Fragment() {

    private val args by navArgs<DescriptionFragmentArgs>()

    lateinit var _bindingDescription: FragmentDescriptionBinding
    val bindingDescription: FragmentDescriptionBinding get() = _bindingDescription

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? {

        _bindingDescription = FragmentDescriptionBinding.inflate(inflater, container, false)

        val comic = args.comic
        bindingDescription.comic = comic

        return bindingDescription.root

    }

}