package ru.popkov.android.core.feature.components.core.models

enum class SectionType(val sectionName: String) {
    ALL(sectionName = "все"),
    COMPANY(sectionName = "компании"),
    ARTICLE(sectionName = "новости"),
    COURSE(sectionName = "курсы");
}

data class SectionFilterItem(
    val sectionType: SectionType = SectionType.COMPANY,
    var isSectionSelected: Boolean = false,
)