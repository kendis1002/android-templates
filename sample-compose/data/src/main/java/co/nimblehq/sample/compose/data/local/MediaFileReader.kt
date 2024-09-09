package co.nimblehq.sample.compose.data.local

import android.content.ContentUris
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import co.nimblehq.sample.compose.data.local.models.MediaFileEntity
import co.nimblehq.sample.compose.domain.models.MediaType
import javax.inject.Inject

class MediaFileReader @Inject constructor(
    private val context: Context
) {
    fun getAllMediaFiles(): List<MediaFileEntity> {
        val mediaFiles = mutableListOf<MediaFileEntity>()

        val queryUri = if (Build.VERSION.SDK_INT >= 29) {
            MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            MediaStore.Files.getContentUri("external")
        }

        val projection = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.DISPLAY_NAME,
            MediaStore.Files.FileColumns.MIME_TYPE
        )
        context.contentResolver.query(
            queryUri,
            projection,
            null,
            null,
            null
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME)
            val typeColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val mimeType = cursor.getString(typeColumn)

                if (name != null && mimeType != null) {
                    val contentUri = ContentUris.withAppendedId(
                        queryUri,
                        id
                    )
                    val mediaType = when {
                        mimeType.startsWith("audio/") -> MediaType.AUDIO
                        mimeType.startsWith("video/") -> MediaType.VIDEO
                        else -> MediaType.IMAGE
                    }
                    mediaFiles.add(
                        MediaFileEntity(
                            uri = contentUri.path.toString(),
                            name = name,
                            type = mediaType
                        )
                    )
                }
            }
        }

        return mediaFiles.toList()
    }
}
