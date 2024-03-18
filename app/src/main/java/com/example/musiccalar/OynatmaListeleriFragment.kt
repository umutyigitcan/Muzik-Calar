package com.example.musiccalar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musiccalar.databinding.FragmentOynatmaListeleriBinding

class OynatmaListeleriFragment : Fragment() {

    private lateinit var tasarim:FragmentOynatmaListeleriBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentOynatmaListeleriBinding.inflate(inflater,container,false)

        return tasarim.root
    }


}