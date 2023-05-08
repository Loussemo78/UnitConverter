package com.example.unitconverter.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {

    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAllResults()
    fun getSavedResults(): Flow<List<ConversionResult>>

}