package co.nimblehq.sample.compose.di.modules

import android.content.Context
import co.nimblehq.sample.compose.data.local.MediaFileReader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MediaReaderModule {

    @Provides
    fun provideMediaReader(@ApplicationContext context: Context): MediaFileReader = MediaFileReader(context)
}
