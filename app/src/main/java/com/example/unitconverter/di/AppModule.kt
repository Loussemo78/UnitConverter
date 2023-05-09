package com.example.unitconverter.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverter.data.ConverterDataBase
import com.example.unitconverter.data.ConverterRepository
import com.example.unitconverter.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app:Application):ConverterDataBase{
        return Room.databaseBuilder(
            app,
            ConverterDataBase::class.java,
            "converter_data_database"
        ).build()
    }
    @Provides
    @Singleton
    fun provideConverterRepository(db : ConverterDataBase) : ConverterRepository{
        return ConverterRepositoryImpl(db.converterDao)
    }
}