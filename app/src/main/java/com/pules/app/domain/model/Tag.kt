package com.pules.app.domain.model

data class Tag(
    val id: String,
    val name: String
)




fun Tag.toTagEntity(): TagEntity {
    return TagEntity(
        id = this.id.toIntOrNull() ?: 0,
        name = this.name
    )
}

