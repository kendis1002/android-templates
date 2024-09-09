package co.nimblehq.sample.compose.domain.repositories

import co.nimblehq.sample.compose.domain.models.MediaFile
import kotlinx.coroutines.flow.Flow

interface MediaFileRepository {
    fun getMediaFiles(): Flow<List<MediaFile>>
}
