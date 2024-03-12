package com.hw7.data.repo

import com.hw7.data.datasource.UrunlerDataSource
import com.hw7.data.entity.Urunler

class UrunlerRepository(var uds : UrunlerDataSource) {




    suspend fun kaydet(urun_ad : String,urun_fiyat : Int) = uds.kaydet(urun_ad,urun_fiyat)

    suspend fun guncelle(urun_id:Int,urun_ad:String,urun_fiyat:Int) = uds.guncelle(urun_id,urun_ad,urun_fiyat)

    suspend fun sil(urun_id : Int) = uds.sil(urun_id)

    suspend fun urunleriYukle() : List<Urunler> = uds.urunleriYukle()

    suspend fun ara(aramaKelimesi: String) : List<Urunler> = uds.ara(aramaKelimesi)
}