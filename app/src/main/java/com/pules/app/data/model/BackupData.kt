package com.pules.app.data.model

import com.pules.app.domain.model.Favorite
import com.pules.app.domain.model.Source
import kotlinx.serialization.Serializable

@Serializable
data class BackupData(
    val sources: List<Source>,
    val favorites: List<Favorite>
)


