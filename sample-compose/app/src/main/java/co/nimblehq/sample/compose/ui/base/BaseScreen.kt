package co.nimblehq.sample.compose.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import co.nimblehq.sample.compose.R
import co.nimblehq.sample.compose.util.setStatusBarColor

@Composable
fun BaseScreen(
    isDarkStatusBarIcons: Boolean? = null,
    content: @Composable () -> Unit,
) {
    if (isDarkStatusBarIcons != null) {
        setStatusBarColor(
            color = colorResource(id = R.color.statusBarColor),
            darkIcons = isDarkStatusBarIcons,
        )
    }

    content()
}
