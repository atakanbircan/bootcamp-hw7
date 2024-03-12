package com.hw7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hw7.databinding.FragmentAddBinding
import com.hw7.ui.viewmodel.AddViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding : FragmentAddBinding
    private lateinit var viewModel : AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)
        binding.toolbarAddFragment.title = "Yeni Ürün Kaydet"
        binding.buttonKaydet.setOnClickListener {
            val urun_ad = binding.editTextTextUrunAdAdd.text.toString()
            val urun_fiyat = binding.editTextUrunFiyatAdd.text.toString()
            kaydet(urun_ad,urun_fiyat.toInt())
        }


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun kaydet(urun_ad : String,urun_fiyat : Int){
        viewModel.kaydet(urun_ad,urun_fiyat)


    }
}