plugins {
    id("com.android.library")
    id("kotlin-android")

    id("org.jetbrains.kotlinx.kover")
}

android {
    namespace = "co.nimblehq.sample.compose.data"

    compileSdk = Versions.ANDROID_COMPILE_SDK_VERSION
    defaultConfig {
        minSdk = Versions.ANDROID_MIN_SDK_VERSION
        targetSdk = Versions.ANDROID_TARGET_SDK_VERSION

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            )
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    lintOptions {
        isCheckDependencies = true
        xmlReport = true
        xmlOutput = file("build/reports/lint/lint-result.xml")
    }
}

dependencies {
    implementation(project(Module.DOMAIN))

    implementation("androidx.core:core-ktx:${Versions.ANDROIDX_CORE_KTX_VERSION}")
    implementation("androidx.datastore:datastore-preferences:${Versions.ANDROIDX_DATASTORE_PREFERENCES_VERSION}")
    implementation("androidx.security:security-crypto:${Versions.ANDROID_CRYPTO_VERSION}")
    implementation("com.google.dagger:hilt-android:${Versions.HILT_VERSION}")
    implementation("com.squareup.moshi:moshi:${Versions.MOSHI_VERSION}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}")
    implementation("javax.inject:javax.inject:${Versions.JAVAX_INJECT_VERSION}")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES_VERSION}")

    api("com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT_VERSION}")
    api("com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}")

    api("com.squareup.moshi:moshi-adapters:${Versions.MOSHI_VERSION}")
    api("com.squareup.moshi:moshi-kotlin:${Versions.MOSHI_VERSION}")

    api("com.squareup.okhttp3:okhttp:${Versions.OKHTTP_VERSION}")
    api("com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_VERSION}")

    // Testing
    testImplementation("junit:junit:${Versions.TEST_JUNIT_VERSION}")
    testImplementation("io.mockk:mockk:${Versions.TEST_MOCKK_VERSION}")
    testImplementation("io.kotest:kotest-assertions-core:${Versions.TEST_KOTEST_VERSION}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.KOTLINX_COROUTINES_VERSION}")
    testImplementation("androidx.test:core:${Versions.TEST_ANDROIDX_CORE_VERSION}")
    testImplementation("org.robolectric:robolectric:${Versions.TEST_ROBOLECTRIC_VERSION}")
    testImplementation("app.cash.turbine:turbine:${Versions.TEST_TURBINE_VERSION}")
}
