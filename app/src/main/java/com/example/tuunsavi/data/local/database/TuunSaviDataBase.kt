package com.example.tuunsavi.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tuunsavi.data.local.dao.MixtecVariantDAO
import com.example.tuunsavi.data.local.dao.MixtecWordDAO
import com.example.tuunsavi.data.local.dao.SemanticFieldDAO
import com.example.tuunsavi.data.local.dao.SpanishAudioDAO
import com.example.tuunsavi.data.local.dao.SpanishWordDAO
import com.example.tuunsavi.data.local.dao.VariantRegionDAO
import com.example.tuunsavi.data.local.dao.WordAudioDAO
import com.example.tuunsavi.data.local.dao.WordImageDAO
import com.example.tuunsavi.data.local.model.MixtecVariantEntity
import com.example.tuunsavi.data.local.model.MixtecWordEntity
import com.example.tuunsavi.data.local.model.SemanticFieldEntity
import com.example.tuunsavi.data.local.model.SpanishAudioEntity
import com.example.tuunsavi.data.local.model.SpanishWordEntity
import com.example.tuunsavi.data.local.model.VariantRegionEntity
import com.example.tuunsavi.data.local.model.WordAudioEntity
import com.example.tuunsavi.data.local.model.WordImageEntity

@Database(
    entities = [
        MixtecVariantEntity::class,
        MixtecWordEntity::class,
        SemanticFieldEntity::class,
        SpanishAudioEntity::class,
        SpanishWordEntity::class,
        VariantRegionEntity::class,
        WordAudioEntity::class,
        WordImageEntity::class
               ],
    version = 1)
abstract class TuunSaviDataBase : RoomDatabase() {
    abstract fun mixtecVariantDao():MixtecVariantDAO
    abstract fun mixtecWordDao():MixtecWordDAO
    abstract fun semanticFieldDao(): SemanticFieldDAO
    abstract fun spanishAudioDao(): SpanishAudioDAO
    abstract fun spanishWordDao(): SpanishWordDAO
    abstract fun variantRegionDao(): VariantRegionDAO
    abstract fun wordAudioDao(): WordAudioDAO
    abstract fun wordImageDao(): WordImageDAO
}