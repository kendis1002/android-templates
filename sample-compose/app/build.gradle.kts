plugins {
    id("com.android.application")

    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")

    id("dagger.hilt.android.plugin")

    id("org.jetbrains.kotlinx.kover")
}

val keystoreProperties = rootDir.loadGradleProperties("signing.properties")

android {
    namespace = "co.nimblehq.sample.compose"

    signingConfigs {
        create(BuildType.RELEASE) {
            // Remember to edit signing.properties to have the correct info for release build.
            storeFile = file("../config/release.keystore")
            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD") as String
            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD") as String
            keyAlias = keystoreProperties.getProperty("KEY_ALIAS") as String
        }

        getByName(BuildType.DEBUG) {
            storeFile = file("../config/debug.keystore")
            storePassword = "oQ4mL1jY2uX7wD8q"
            keyAlias = "debug-key-alias"
            keyPassword = "oQ4mL1jY2uX7wD8q"
        }
    }

    compileSdk = Versions.ANDROID_COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = "co.nimblehq.sample.compose"
        minSdk = Versions.ANDROID_MIN_SDK_VERSION
        targetSdk = Versions.ANDROID_TARGET_SDK_VERSION
        versionCode = Versions.ANDROID_VERSION_CODE
        versionName = Versions.ANDROID_VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs[BuildType.RELEASE]
            buildConfigField("String", "BASE_API_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }

        getByName(BuildType.DEBUG) {
            // For quickly testing build with proguard, enable this
            isMinifyEnabled = false
            signingConfig = signingConfigs[BuildType.DEBUG]
            buildConfigField("String", "BASE_API_URL", "\"https://jsonplaceholder.typicode.com/\"")
        }
    }

    flavorDimensions += Flavor.DIMENSION_VERSION
    productFlavors {
        create(Flavor.STAGING) {
            applicationIdSuffix = ".staging"
        }

        create(Flavor.PRODUCTION) {}
    }

    sourceSets["test"].resources {
        srcDir("src/test/resources")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER_VERSION
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packagingOptions {
        jniLibs {
            // Resolve "libmockkjvmtiagent.so" https://github.com/mockk/mockk/issues/297#issuecomment-901924678
            useLegacyPackaging = true
        }
    }

    lint {
        checkDependencies = true
        xmlReport = true
        xmlOutput = file("build/reports/lint/lint-result.xml")
    }

    testOptions {
        unitTests {
            // Robolectric resource processing/loading https://github.com/robolectric/robolectric/pull/4736
            isIncludeAndroidResources = true
        }
        // Disable device's animation for instrument testing
        // animationsDisabled = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(Module.DATA))
    implementation(project(Module.DOMAIN))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX_VERSION}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_LIFECYCLE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:${Versions.ANDROIDX_LIFECYCLE_VERSION}")

    implementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM_VERSION}"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3:${Versions.COMPOSE_VERSION}")

    implementation("io.coil-kt:coil-compose:${Versions.COIL_VERSION}")

    implementation("androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION_VERSION}")
    implementation("com.google.accompanist:accompanist-permissions:${Versions.ACCOMPANIST_VERSION}")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${Versions.ACCOMPANIST_VERSION}")

    implementation("androidx.datastore:datastore-preferences:${Versions.ANDROIDX_DATASTORE_PREFERENCES_VERSION}")

    implementation("com.google.dagger:hilt-android:${Versions.HILT_VERSION}")
    implementation("androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE_VERSION}")

    implementation("com.jakewharton.timber:timber:${Versions.TIMBER_LOG_VERSION}")

    implementation("com.github.nimblehq:android-common-ktx:${Versions.ANDROID_COMMON_KTX_VERSION}")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES_VERSION}")

    kapt("com.google.dagger:hilt-compiler:${Versions.HILT_VERSION}")

    debugImplementation("com.github.chuckerteam.chucker:library:${Versions.CHUCKER_VERSION}")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:${Versions.CHUCKER_VERSION}")

    // Unit test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLINX_COROUTINES_VERSION}")
    testImplementation("io.kotest:kotest-assertions-core:${Versions.TEST_KOTEST_VERSION}")
    testImplementation("junit:junit:${Versions.TEST_JUNIT_VERSION}")
    testImplementation("io.mockk:mockk:${Versions.TEST_MOCKK_VERSION}")
    testImplementation("app.cash.turbine:turbine:${Versions.TEST_TURBINE_VERSION}")

    // UI test with Robolectric
    testImplementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM_VERSION}"))
    testImplementation("androidx.compose.ui:ui-test-junit4")
    testImplementation("androidx.test:rules:${Versions.TEST_RULES_VERSION}")
    testImplementation("org.robolectric:robolectric:${Versions.TEST_ROBOLECTRIC_VERSION}")

    // UI test
    androidTestImplementation(platform("androidx.compose:compose-bom:${Versions.COMPOSE_BOM_VERSION}"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("androidx.test:rules:${Versions.TEST_RULES_VERSION}")
    androidTestImplementation("io.mockk:mockk-android:${Versions.TEST_MOCKK_VERSION}")
}

/*
 * Kover configs
 */
dependencies {
    kover(project(":data"))
    kover(project(":domain"))
}

koverReport {
    defaults {
        mergeWith("stagingDebug")
        filters {
            val excludedFiles = listOf(
                "*.BuildConfig.*",
                "*.BuildConfig",
                // Enum
                "*.*\$Creator*",
                // DI
                "*.di.*",
                // Hilt
                "*.*_ComponentTreeDeps*",
                "*.*_HiltComponents*",
                "*.*_HiltModules*",
                "*.*_MembersInjector*",
                "*.*_Factory*",
                "*.Hilt_*",
                "dagger.hilt.internal.*",
                "hilt_aggregated_deps.*",
                // Jetpack Compose
                "*.ComposableSingletons*",
                "*.*\$*Preview\$*",
                "*.ui.preview.*",
            )

            excludes {
                classes(excludedFiles)
            }
        }
    }
}
