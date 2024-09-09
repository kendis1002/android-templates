package co.nimblehq.sample.compose.ui.theme

import androidx.compose.material3.*
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Base colors here
internal val Primary0 = Color(0xFF000000)
internal val Primary10 = Color(0xFF002106)
internal val Primary20 = Color(0xFF00390F)
internal val Primary30 = Color(0xFF005319)
internal val Primary40 = Color(0xFF006E24)
internal val Primary50 = Color(0xFF148933)
internal val Primary60 = Color(0xFF39A54B)
internal val Primary70 = Color(0xFF56C063)
internal val Primary80 = Color(0xFF72DD7B)
internal val Primary90 = Color(0xFFB4F2B1)
internal val Primary95 = Color(0xFFC7FFC3)
internal val Primary99 = Color(0xFFF6FFF0)
internal val Primary100 = Color(0xFFFFFFFF)

internal val Secondary0 = Color(0xFF000000)
internal val Secondary10 = Color(0xFF0B200D)
internal val Secondary20 = Color(0xFF203520)
internal val Secondary30 = Color(0xFF364C35)
internal val Secondary40 = Color(0xFF4D644B)
internal val Secondary50 = Color(0xFF657D63)
internal val Secondary60 = Color(0xFF7F977B)
internal val Secondary70 = Color(0xFF99B295)
internal val Secondary80 = Color(0xFFB4CEAF)
internal val Secondary90 = Color(0xFFCFEACA)
internal val Secondary95 = Color(0xFFDDF8D8)
internal val Secondary99 = Color(0xFFF6FFF0)
internal val Secondary100 = Color(0xFFFFFFFF)

internal val Tertiary0 = Color(0xFF000000)
internal val Tertiary10 = Color(0xFF001F23)
internal val Tertiary20 = Color(0xFF00363C)
internal val Tertiary30 = Color(0xFF004F57)
internal val Tertiary40 = Color(0xFF226770)
internal val Tertiary50 = Color(0xFF3F8089)
internal val Tertiary60 = Color(0xFF5A9AA3)
internal val Tertiary70 = Color(0xFF75B5BF)
internal val Tertiary80 = Color(0xFF91D1DA)
internal val Tertiary90 = Color(0xFFACEDF7)
internal val Tertiary95 = Color(0xFFCDF8FF)
internal val Tertiary99 = Color(0xFFF5FEFF)
internal val Tertiary100 = Color(0xFFFFFFFF)

internal val Error0 = Color(0xFF000000)
internal val Error10 = Color(0xFF410002)
internal val Error20 = Color(0xFF690005)
internal val Error30 = Color(0xFF93000A)
internal val Error40 = Color(0xFFBA1A1A)
internal val Error50 = Color(0xFFDE3730)
internal val Error60 = Color(0xFFFF5449)
internal val Error70 = Color(0xFFFF897D)
internal val Error80 = Color(0xFFFFB4AB)
internal val Error90 = Color(0xFFFFDAD6)
internal val Error95 = Color(0xFFFFEDEA)
internal val Error99 = Color(0xFFFFFBFF)
internal val Error100 = Color(0xFFFFFFFF)

internal val Neural0 = Color(0xFF000000)
internal val Neural10 = Color(0xFF1A1C19)
internal val Neural20 = Color(0xFF2F312D)
internal val Neural30 = Color(0xFF454743)
internal val Neural40 = Color(0xFF5D5F5B)
internal val Neural50 = Color(0xFF767873)
internal val Neural60 = Color(0xFF8F918C)
internal val Neural70 = Color(0xFFAAACA6)
internal val Neural80 = Color(0xFFC6C7C1)
internal val Neural90 = Color(0xFFE2E3DD)
internal val Neural92 = Color(0xFFE6E9E1)
internal val Neural94 = Color(0xFFEBEFE6)
internal val Neural95 = Color(0xFFF0F1EB)
internal val Neural96 = Color(0xFFF1F5EC)
internal val Neural99 = Color(0xFFF6FFF0)
internal val Neural100 = Color(0xFFFFFFFF)

internal val NeuralVariant0 = Color(0xFF000000)
internal val NeuralVariant10 = Color(0xFF171D16)
internal val NeuralVariant20 = Color(0xFF2C322A)
internal val NeuralVariant30 = Color(0xFF424940)
internal val NeuralVariant40 = Color(0xFF596057)
internal val NeuralVariant50 = Color(0xFF72796F)
internal val NeuralVariant60 = Color(0xFF8C9388)
internal val NeuralVariant70 = Color(0xFFA6ADA2)
internal val NeuralVariant80 = Color(0xFFC2C9BD)
internal val NeuralVariant90 = Color(0xFFDEE5D9)
internal val NeuralVariant95 = Color(0xFFECF3E7)
internal val NeuralVariant99 = Color(0xFFF6FFF0)
internal val NeuralVariant100 = Color(0xFFFFFFFF)

/**
 * Expand the final [Colors] class to provide more custom app colors.
 */
data class AppColors(
    val themeColors: ColorScheme,

    // Custom colors here
//    val topAppBarBackground: Color = GreenCitrus
)

internal val LightColorPalette = AppColors(
    themeColors = lightColorScheme(
        primary = Primary40,
        onPrimary = Primary100,
        primaryContainer = Primary90,
        onPrimaryContainer = Primary10,

        secondary = Secondary40,
        onSecondary = Secondary100,
        secondaryContainer = Secondary90,
        onSecondaryContainer = Secondary10,

        tertiary = Tertiary40,
        onTertiary = Tertiary100,
        tertiaryContainer = Tertiary90,
        onTertiaryContainer = Tertiary10,

        error = Error40,
        onError = Error100,
        errorContainer = Error90,
        onErrorContainer = Error10,

        surfaceDim = Neural90,
        surface = Neural99,
        surfaceBright = Neural99,
        surfaceContainerLowest = Neural100,
        surfaceContainerLow = Neural96,
        surfaceContainer = Neural94,
        surfaceContainerHigh = Neural92,
        surfaceContainerHighest = Neural90,
        onSurface = Neural10,
        onSurfaceVariant = NeuralVariant30,
        outline = NeuralVariant50,
        outlineVariant = NeuralVariant80,
        inverseSurface = Neural20,
        inverseOnSurface = Neural95,
        inversePrimary = Primary80,
        scrim = Neural0
    )
)

internal val DarkColorPalette = AppColors(
    themeColors = lightColorScheme(
        primary = Primary40,
        onPrimary = Primary100,
        primaryContainer = Primary90,
        onPrimaryContainer = Primary10,

        secondary = Secondary40,
        onSecondary = Secondary100,
        secondaryContainer = Secondary90,
        onSecondaryContainer = Secondary10,

        tertiary = Tertiary40,
        onTertiary = Tertiary100,
        tertiaryContainer = Tertiary90,
        onTertiaryContainer = Tertiary10,

        error = Error40,
        onError = Error100,
        errorContainer = Error90,
        onErrorContainer = Error10,

        surfaceDim = Neural90,
        surface = Neural99,
        surfaceBright = Neural99,
        surfaceContainerLowest = Neural100,
        surfaceContainerLow = Neural96,
        surfaceContainer = Neural94,
        surfaceContainerHigh = Neural92,
        surfaceContainerHighest = Neural90,
        onSurface = Neural10,
        onSurfaceVariant = NeuralVariant30,
        outline = NeuralVariant50,
        outlineVariant = NeuralVariant80,
        inverseSurface = Neural20,
        inverseOnSurface = Neural95,
        inversePrimary = Primary80,
        scrim = Neural0
    )
)

internal val LocalAppColors = staticCompositionLocalOf { LightColorPalette }
