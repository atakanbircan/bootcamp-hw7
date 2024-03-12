package com.hw7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.hw7.data.repo.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(var urepo : UrunlerRepository) : ViewModel() {

    //var urepo = UrunlerRepository()

    fun kaydet(urun_ad : String,urun_fiyat : Int){
        CoroutineScope(Dispatchers.Main).launch {
            urepo.kaydet(urun_ad,urun_fiyat)
        }

    }
}