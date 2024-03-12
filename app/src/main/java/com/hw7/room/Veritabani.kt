package com.hw7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hw7.data.entity.Urunler

@Database(entities = [Urunler::class],version = 1)
abstract class Veritabani : RoomDatabase(){
    abstract fun getUrunlerDao() : UrunlerDao
}