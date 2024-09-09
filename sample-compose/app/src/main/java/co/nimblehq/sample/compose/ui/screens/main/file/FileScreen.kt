package co.nimblehq.sample.compose.ui.screens.main.file

import android.Manifest
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.extensions.collectAsEffect
import co.nimblehq.sample.compose.extensions.showToast
import co.nimblehq.sample.compose.lib.IsLoading
import co.nimblehq.sample.compose.ui.base.BaseScreen
import co.nimblehq.sample.compose.ui.models.UiModel
import co.nimblehq.sample.compose.ui.showToast
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@Composable
fun FileScreen(
    viewModel: FileViewModel = hiltViewModel(),
) = BaseScreen(
    isDarkStatusBarIcons = true,
) {
    val context = LocalContext.current
    viewModel.error.collectAsEffect { e -> e.showToast(context) }

    val isLoading: IsLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val uiModels: List<MediaFile> by viewModel.uiModels.collectAsStateWithLifecycle()

    FilePermissions()
    FileScreenContent()
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun FilePermissions() {
    val multiplePermissionsState =
        rememberMultiplePermissionsState(
            permissions = if (Build.VERSION.SDK_INT >= 33) listOf(
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.READ_MEDIA_VIDEO,
                Manifest.permission.READ_MEDIA_IMAGES,
            ) else listOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
    val context = LocalContext.current

    multiplePermissionsState.permissions.forEach { perm ->
        if (perm.status.isGranted) {
            context.showToast("${perm.permission} granted")
        } else {
            if (perm.status.shouldShowRationale) {
                context.showToast("${perm.permission} needs rationale")
            } else {
                context.showToast("Request cancelled, missing permissions in manifest or denied permanently")
            }

            LaunchedEffect(Unit) {
                perm.launchPermissionRequest()
            }
        }
    }
}

@Composable
fun FileScreenContent(modifier: Modifier = Modifier) {

}
