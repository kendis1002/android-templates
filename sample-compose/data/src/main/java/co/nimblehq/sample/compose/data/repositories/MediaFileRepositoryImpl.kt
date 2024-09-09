package co.nimblehq.sample.compose.data.repositories

import co.nimblehq.sample.compose.data.extensions.flowTransform
import co.nimblehq.sample.compose.data.local.MediaFileReader
import co.nimblehq.sample.compose.data.local.models.toMediaFiles
import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.domain.repositories.MediaFileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MediaFileRepositoryImpl @Inject constructor(
    private val mediaFileReader: MediaFileReader
): MediaFileRepository {
    override fun getMediaFiles(): Flow<List<MediaFile>> = flowTransform {
        mediaFileReader.getAllMediaFiles().toMediaFiles()
    }
}
