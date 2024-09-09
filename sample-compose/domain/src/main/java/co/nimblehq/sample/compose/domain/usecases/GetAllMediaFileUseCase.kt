package co.nimblehq.sample.compose.domain.usecases

import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.domain.repositories.MediaFileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMediaFileUseCase @Inject constructor(private val mediaFileRepository: MediaFileRepository) {

    operator fun invoke(): Flow<List<MediaFile>> {
        return mediaFileRepository.getMediaFiles()
    }
}
