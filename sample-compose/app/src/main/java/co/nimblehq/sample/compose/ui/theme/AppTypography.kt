package co.nimblehq.sample.compose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf

private val Typography = Typography(
    // Custom typography here
)

internal val LocalAppTypography = staticCompositionLocalOf { Typography }
