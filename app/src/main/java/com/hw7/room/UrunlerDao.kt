package com.hw7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hw7.data.entity.Urunler

@Dao
interface UrunlerDao {

    @Query("SELECT * FROM urunler")
    suspend fun urunleriYukle() : List<Urunler>

    @Insert
    suspend fun kaydet(urun : Urunler)

    @Update
    suspend fun guncelle(urun : Urunler)

    @Delete
    suspend fun sil(urun : Urunler)

    @Query("SELECT * FROM urunler WHERE urun_ad LIKE '%'|| :aramaKelimesi ||'%'")
    suspend fun ara(aramaKelimesi : String) : List<Urunler>

}

