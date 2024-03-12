package com.hw7.di

import android.content.Context
import androidx.room.Room
import com.hw7.data.datasource.UrunlerDataSource
import com.hw7.data.repo.UrunlerRepository
import com.hw7.room.UrunlerDao
import com.hw7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
class AppModule {

    @Provides
    @Singleton
    fun provideUrunlerDataSource(udao : UrunlerDao) : UrunlerDataSource {
        return UrunlerDataSource(udao)
    }

    @Provides
    @Singleton
    fun provideUrunlerRepository(uds : UrunlerDataSource) : UrunlerRepository {
        return UrunlerRepository(uds)
    }

    @Provides
    @Singleton
    fun provideUrunlerDao(@ApplicationContext context: Context) : UrunlerDao {
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"urunler.sqlite")
            .createFromAsset("urunler.sqlite").build()

        return vt.getUrunlerDao()
    }
}