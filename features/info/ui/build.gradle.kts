plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "ru.popkov.navigator.features.info.ui"
}

dependencies {
    implementation(project(":core:feature:domain"))
    implementation(project(":features:info:nav"))
    implementation(project(":theme"))
}
