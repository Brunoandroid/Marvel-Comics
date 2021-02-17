package com.example.marvelcomics.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelcomics.databinding.FragmentComicsBinding

class ComicsFragment : Fragment() {

    lateinit var _bindingComics: FragmentComicsBinding
    val bindingComics: FragmentComicsBinding get() = _bindingComics

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? {

        _bindingComics = FragmentComicsBinding.inflate(inflater, container, false)

        return bindingComics.root

    }

}