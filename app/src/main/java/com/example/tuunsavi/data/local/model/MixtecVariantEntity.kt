package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "MixtecVariant",
    foreignKeys = [
        ForeignKey(
            entity = VariantRegionEntity::class,
            parentColumns = ["idVariantRegion"],
            childColumns = ["idVariantRegion"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [Index(value = ["idVariantRegion"])]
)
data class MixtecVariantEntity(
    @PrimaryKey(autoGenerate = true) val idVariant: Int = 1,
    @ColumnInfo(name = "idVariantRegion") val idVariantRegion: Int,
    @ColumnInfo(name = "variantName") val variantName : String
)
