plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "ru.popkov.navigator.features.home.ui"
}

dependencies {
    implementation("androidx.compose.material:material:1.6.7")
    implementation(project(":core:feature:domain"))
    implementation(project(":features:home:nav"))
    implementation(project(":features:section:ui"))
    implementation(project(":features:info:ui"))
    implementation(project(":theme"))
}
