package com.example.musiccalar

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musiccalar.databinding.FragmentSarkilarBinding

class SarkilarFragment : Fragment() {
    private var mediaPlayer:MediaPlayer?=null
    private lateinit var tasarim:FragmentSarkilarBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentSarkilarBinding.inflate(inflater,container,false)
        mediaPlayer=MediaPlayer.create(requireContext(),R.raw.sevilla)
        tasarim.baslat.setOnClickListener {
            mediaPlayer?.start()
        }

        return tasarim.root
    }
}