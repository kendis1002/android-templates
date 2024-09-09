package co.nimblehq.sample.compose.ui.screens.main.file

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.domain.models.MediaType
import co.nimblehq.sample.compose.ui.theme.AppTheme.dimensions
import co.nimblehq.sample.compose.ui.theme.ComposeTheme
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Item(
    file: MediaFile,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { },
                onLongClick = { expanded = true }
            )
    ) {
        Row {
            when (file.type) {
                MediaType.IMAGE -> {
                    AsyncImage(
                        model = file.uri,
                        contentDescription = null,
                        modifier = Modifier
                            .width(100.dp)
                    )
                }

                MediaType.VIDEO -> {
                    Icon(
                        imageVector = Icons.Rounded.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.width(100.dp)
                    )
                }

                MediaType.AUDIO -> {
                    Image(
                        imageVector = Icons.Rounded.Face,
                        contentDescription = null,
                        modifier = Modifier.width(100.dp)
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(dimensions.spacingMedium)
                    .weight(1f),
                text = "${file.name} - ${file.type}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    ComposeTheme {
        Item(
            file = MediaFile("", "name", MediaType.AUDIO)
        )
    }
}
