package com.example.musiccalar

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.musiccalar.databinding.FragmentSarkiCalmaEkraniBinding

class SarkiCalmaEkrani : Fragment() {

    var sure=0
    private lateinit var handler:Handler
    private var mediaPlayer:MediaPlayer?=null
    private lateinit var tasarim:FragmentSarkiCalmaEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentSarkiCalmaEkraniBinding.inflate(inflater,container,false)
        mediaPlayer=MediaPlayer.create(requireContext(),R.raw.sevilla)


        mediaPlayer?.let {
            val uzunlukMilisaniye = it.duration
            val uzunlukSaniye = uzunlukMilisaniye / 1000

            tasarim.seekbar.max=uzunlukSaniye
        }

        handler= Handler(Looper.getMainLooper())



        tasarim.loop.setOnCheckedChangeListener{compoundButton,p->
            if(p){
                tasarim.loop.setBackgroundResource(R.drawable.looptrue)
                mediaPlayer?.isLooping=true
            }else{
                tasarim.loop.setBackgroundResource(R.drawable.loopfalse)
                mediaPlayer?.isLooping=false
            }
        }

        tasarim.begen.setOnCheckedChangeListener{compoundButton,p->
            if(p){
                tasarim.begen.setBackgroundResource(R.drawable.hearttrue)
            }else{
                tasarim.begen.setBackgroundResource(R.drawable.heartfalse)
            }
        }

        tasarim.play.setOnCheckedChangeListener { compoundButton, p ->
            if (p) {
                mediaPlayer?.start()
                start()
            } else {
                mediaPlayer?.pause()
            }
        }

        tasarim.solbuton.setOnClickListener {
            mediaPlayer?.reset()
            mediaPlayer=MediaPlayer.create(requireContext(),R.raw.sevilla)
            mediaPlayer?.start()
        }







        return tasarim.root
    }
    fun start(){
        handler.postDelayed(runnable,1000)
    }

    var runnable: Runnable = object : Runnable {
        override fun run() {
            sure++
            tasarim.seekbar.progress = sure
            tasarim.deger.text = sure.toString()
            handler.postDelayed(this, 1000)
        }
    }


}