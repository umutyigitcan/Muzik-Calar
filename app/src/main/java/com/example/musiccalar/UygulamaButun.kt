package com.example.musiccalar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.musiccalar.databinding.FragmentUygulamaButunBinding
import com.google.android.material.tabs.TabLayoutMediator

class UygulamaButun : Fragment() {

    private lateinit var fragmentListesi:ArrayList<Fragment>
    private lateinit var fragmentBaslikListesi:ArrayList<String>
    private lateinit var tasarim:FragmentUygulamaButunBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentUygulamaButunBinding.inflate(inflater,container,false)
        fragmentListesi= ArrayList()
        fragmentBaslikListesi= ArrayList()
        fragmentListesi.add(SarkilarFragment())
        fragmentListesi.add(OynatmaListeleriFragment())
        fragmentListesi.add(SarkiCalmaEkrani())
        fragmentBaslikListesi.add("Şarkılar")
        fragmentBaslikListesi.add("Oynatma Listeleri")
        fragmentBaslikListesi.add("Oynatılan Şarkı")

        tasarim.vp.adapter=myViewPagerAdapter(requireActivity())

        TabLayoutMediator(tasarim.tl,tasarim.vp){tab,position->
            tab.setText(fragmentBaslikListesi[position])
        }.attach()





        return tasarim.root
    }

    inner class myViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentListesi.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]
        }
    }

}