package com.hw7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.hw7.databinding.FragmentDetailBinding
import com.hw7.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private lateinit var viewModel : DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val bundle : DetailFragmentArgs by navArgs()
        val gelenUrun = bundle.urun

        binding.editTextTextUrunAdi.setText(gelenUrun.urun_ad)
        binding.editTextTextUrunFiyati.setText(gelenUrun.urun_fiyat.toString())

        binding.toolbarDetailFragment.title = "Ürün Güncelle"

        binding.buttonDetailGuncelle.setOnClickListener {
            val urun_ad = binding.editTextTextUrunAdi.text.toString()
            val urun_fiyat = binding.editTextTextUrunFiyati.text.toString()
            guncelle(gelenUrun.urun_id,urun_ad,urun_fiyat.toInt())
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun guncelle(urun_id:Int,urun_ad:String,urun_fiyat:Int){

        viewModel.guncelle(urun_id,urun_ad,urun_fiyat)
    }
}