package com.example.tuunsavi.di

import android.content.Context
import androidx.room.Room
import com.example.tuunsavi.data.local.dao.MixtecVariantDAO
import com.example.tuunsavi.data.local.dao.MixtecWordDAO
import com.example.tuunsavi.data.local.dao.SemanticFieldDAO
import com.example.tuunsavi.data.local.dao.SpanishAudioDAO
import com.example.tuunsavi.data.local.dao.SpanishWordDAO
import com.example.tuunsavi.data.local.dao.VariantRegionDAO
import com.example.tuunsavi.data.local.dao.WordAudioDAO
import com.example.tuunsavi.data.local.dao.WordImageDAO
import com.example.tuunsavi.data.local.database.TuunSaviDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesTuunSaviRoomDataBase(@ApplicationContext app:Context): TuunSaviDataBase{
        val database = Room.databaseBuilder(
            app,
            TuunSaviDataBase::class.java,
            name = "Tu'unSaviDB.db"
        ).createFromAsset("database/Tu'unSaviDB.db").build()
        return database
    }

    @Provides
    @Singleton
    fun providesMixtecVariantDao(tuunSaviDataBase: TuunSaviDataBase) : MixtecVariantDAO = tuunSaviDataBase.mixtecVariantDao()

    @Provides
    @Singleton
    fun providesMixtecWordDao(tuunSaviDataBase: TuunSaviDataBase) : MixtecWordDAO = tuunSaviDataBase.mixtecWordDao()

    @Provides
    @Singleton
    fun providesSemanticFieldDao(tuunSaviDataBase: TuunSaviDataBase) : SemanticFieldDAO = tuunSaviDataBase.semanticFieldDao()

    @Provides
    @Singleton
    fun providesSpanishAudioDao(tuunSaviDataBase: TuunSaviDataBase) : SpanishAudioDAO = tuunSaviDataBase.spanishAudioDao()

    @Provides
    @Singleton
    fun providesSpanishWordDao(tuunSaviDataBase: TuunSaviDataBase) : SpanishWordDAO = tuunSaviDataBase.spanishWordDao()

    @Provides
    @Singleton
    fun providesVariantRegionDao(tuunSaviDataBase: TuunSaviDataBase) : VariantRegionDAO = tuunSaviDataBase.variantRegionDao()

    @Provides
    @Singleton
    fun providesWordAudioDao(tuunSaviDataBase: TuunSaviDataBase): WordAudioDAO = tuunSaviDataBase.wordAudioDao()

    @Provides
    @Singleton
    fun providesWordImageDao(tuunSaviDataBase: TuunSaviDataBase) : WordImageDAO = tuunSaviDataBase.wordImageDao()
    
}