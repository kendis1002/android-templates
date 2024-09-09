package co.nimblehq.sample.compose.data.local.models

import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.domain.models.MediaType

data class MediaFileEntity(
    val uri: String,
    val name: String,
    val type: MediaType
)

private fun MediaFileEntity.toMediaFile() = MediaFile(
    uri = uri,
    name = name,
    type = type
)

fun List<MediaFileEntity>.toMediaFiles() = this.map { it.toMediaFile() }
