package co.nimblehq.sample.compose.di.modules

import co.nimblehq.sample.compose.data.local.MediaFileReader
import co.nimblehq.sample.compose.data.remote.services.ApiService
import co.nimblehq.sample.compose.data.repositories.MediaFileRepositoryImpl
import co.nimblehq.sample.compose.data.repositories.RepositoryImpl
import co.nimblehq.sample.compose.domain.repositories.MediaFileRepository
import co.nimblehq.sample.compose.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService): Repository = RepositoryImpl(apiService)

    @Provides
    fun provideMediaFileRepository(mediaFileReader: MediaFileReader): MediaFileRepository
        = MediaFileRepositoryImpl(mediaFileReader)
}
