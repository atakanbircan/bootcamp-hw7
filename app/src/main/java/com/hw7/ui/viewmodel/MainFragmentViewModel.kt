package com.hw7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hw7.data.entity.Urunler
import com.hw7.data.repo.UrunlerRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(var urepo : UrunlerRepository) : ViewModel() {


    var urunlerList = MutableLiveData<List<Urunler>>()

    init {
        urunleriYukle()
    }

    fun sil(urun_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            urepo.sil(urun_id)
            urunleriYukle()
        }
    }

    fun urunleriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            urunlerList.value = urepo.urunleriYukle()
        }
    }

    fun ara(aramaKelimesi: String){
        CoroutineScope(Dispatchers.Main).launch {
            urunlerList.value = urepo.ara(aramaKelimesi)
        }
    }

}