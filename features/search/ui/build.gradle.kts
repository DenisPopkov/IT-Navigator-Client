plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "ru.popkov.navigator.features.search.ui"
}

dependencies {
    implementation(project(":core:feature:domain"))
    implementation(project(":features:search:nav"))
    implementation(project(":features:home:nav"))
    implementation(project(":features:section:ui"))
    implementation(project(":features:info:ui"))
    implementation(project(":theme"))
}
