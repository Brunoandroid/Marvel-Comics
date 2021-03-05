package com.example.marvelcomics.presentation.ui.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelcomics.databinding.FragmentInformationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : Fragment() {

    lateinit var _bindingInformation: FragmentInformationBinding
    val bindingInformation: FragmentInformationBinding get() = _bindingInformation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _bindingInformation = FragmentInformationBinding.inflate(inflater, container, false)

        return bindingInformation.root

    }
}