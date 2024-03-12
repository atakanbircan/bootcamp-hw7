package com.hw7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("urunler")
data class Urunler(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "urun_id") @NotNull var urun_id : Int,
                   @ColumnInfo(name = "urun_ad") @NotNull var urun_ad : String,
                   @ColumnInfo(name = "urun_fiyat") @NotNull var urun_fiyat : Int):Serializable
