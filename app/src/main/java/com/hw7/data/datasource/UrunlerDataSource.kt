package com.hw7.data.datasource

import android.util.Log
import com.hw7.data.entity.Urunler
import com.hw7.room.UrunlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UrunlerDataSource(var udao : UrunlerDao) {

    suspend fun urunleriYukle() : List<Urunler> =
        withContext(Dispatchers.IO){

            return@withContext udao.urunleriYukle()
        }

    suspend fun ara(aramaKelimesi : String) : List<Urunler> =
        withContext(Dispatchers.IO){


            return@withContext udao.ara(aramaKelimesi)
        }

    suspend fun kaydet(urun_ad : String,urun_fiyat : Int){
        val yeniUrun = Urunler(0,urun_ad,urun_fiyat)
        udao.kaydet(yeniUrun)

    }

    suspend fun guncelle(urun_id:Int,urun_ad:String,urun_fiyat:Int) {
        val guncellenenUrun = Urunler(urun_id, urun_ad, urun_fiyat)
        udao.guncelle(guncellenenUrun)
    }
    suspend fun sil(urun_id : Int){
        val silinenUrun = Urunler(urun_id,"",0)
        udao.sil(silinenUrun)
    }



}