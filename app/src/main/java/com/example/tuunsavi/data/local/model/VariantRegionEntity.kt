package com.example.tuunsavi.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VariantRegion" )
data class VariantRegionEntity(
    @PrimaryKey(autoGenerate = true) val idVariantRegion: Int = 1,
    @ColumnInfo(name = "regionName")val regionName: String
)
