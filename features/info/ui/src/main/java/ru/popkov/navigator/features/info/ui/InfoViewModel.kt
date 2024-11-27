package ru.popkov.navigator.features.info.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import ru.popkov.android.core.feature.components.core.models.SectionType
import ru.popkov.android.core.feature.ui.EffectsDelegate
import ru.popkov.android.core.feature.ui.EffectsProvider
import ru.popkov.android.core.feature.ui.StateDelegate
import ru.popkov.android.core.feature.ui.StateProvider
import ru.popkov.navigator.features.auth.domain.model.Article
import ru.popkov.navigator.features.auth.domain.model.Company
import ru.popkov.navigator.features.auth.domain.model.Course
import ru.popkov.navigator.features.auth.domain.repositories.FeedRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val feedRepository: FeedRepository
) : ViewModel(),
    StateProvider<InfoState> by StateDelegate(InfoState()),
    EffectsProvider<InfoViewEffect> by EffectsDelegate() {

    private val sectionId = InfoDestination.Args(savedStateHandle).sectionType
    val componentId = InfoDestination.Args(savedStateHandle).componentId
    val sectionType = SectionType.entries[(sectionId ?: 0) + 1]

    fun mockCompanies() = listOf(
        Company(
            id = 0,
            name = "7bits",
            desc = "7bits — это сплошное удовольствие от работы: lean, agile, ответственность и отличные коммуникации. Вакансии: \n"+
                    "\n"+
                    "-",
            image = "https://iili.io/2cWKYTx.md.png"
        ),
        Company(
            id = 1,
            name = "Deeplay",
            desc = "Цель deeplay — создать комфортную среду для игроков. Роботы применяют разные стратегии и характеры для сохранения баланса сил.\n"+
                    "\n"+
                    "Вакансии: \n"+
                    "\n"+
                    "-",
            image = "https://iili.io/2cWK6uf.md.png"
        ),
        Company(
            id = 2,
            name = "Live Typing",
            desc = "Мы компания «Лайв Тайпинг»! Мы занимаемся проектированием, дизайном и разработкой мобильных приложений и веб-сервисов для таких клиентов, как Sephora, ИЛЬ ДЭ БОТЭ, PepsiCo, Samsung, Mastercard, СТС. \n"+
                    "\n"+
                    "Вакансии: \n"+
                    "\n"+
                    "-",
            image = "https://iili.io/2cvaHVs.png"
        ),
        Company(
            id = 3,
            name = "Effective",
            desc = "Помогаем бизнесу создавать и масштабировать IT-департаменты.\n"+
                    "\n"+
                    "Вакансии: \n"+
                    "\n"+
                    "-",
            image = "https://iili.io/2cWBxBp.png"
        )
    )

    fun mockFeed() = listOf(
        Article(
            id = 0,
            name = "Омская область установила рекорд по участию в «Цифровом диктанте»",
            date = "24-11-2024",
            description = "Во всех регионах страны завершился пятый сезон Всероссийской акции «Цифровой диктант». Организатором мероприятия выступила Российская ассоциация электронных коммуникаций (РАЭК) при поддержке Министерства цифрового развития, связи и массовых коммуникаций России и департамента информационных технологий города Москвы.\n"+
                    "\n"+
                    "«Общий уровень цифровой грамотности повысился с 6,43 до 6,65 балла из 10. Средние показатели трех субиндексов цифровой грамотности незначительно снизились по сравнению с 2023 годом. Увеличение общего индекса цифровой грамотности связано со значительным увеличением количества участников, прошедших Диктант на «отлично», и повышенного внимания аудитории к цифровым сервисам и услугам. На рост общего индекса цифровой грамотности повлияло и введение нового блока вопросов по финансовой киберграмотности», - директор РАЭК и идеолог Цифрового диктанта Сергей Гребенников.",
            image = "https://iili.io/2cVyc92.md.png"
        ),
        Article(
            id = 1,
            name = "Омские айтишники приняли участие в «Мама, папа, я — ИТ-семья»",
            date = "24-11-2024",
            description = "На базе спортивной школы олимпийского резерва «Сибирский нефтяник» состоялось спортивное мероприятие, посвященное Году семьи, объявленному Президентом России Владимиром Владимировичем Путиным.\n"+
                    "\n"+
                    "Эти соревнования были организованы с целью пропаганды физической культуры, спорта и активного образа жизни, а также приурочены к международному празднику «День матери».\n"+
                    "\n"+
                    "«Сегодняшние соревнования посвящены Году семьи и международному празднику «День матери». Я благодарю коллег за поддержку нашей инициативы и активное участие. Мы надеемся, что такие соревнования станут традицией и будут набирать обороты с каждым годом», — сказала Наталья Шилкина, заместитель Министра цифрового развития и связи Омской области.",
            image = "https://iili.io/2cW2NQS.md.png"

        ),
    )

    fun mockCourses() = listOf(
        Course(
            id = 0,
            name = "Омская IT-академия",
            desc = "Омская IT академия– это лучшее образование в г. Омске с 75% практики на занятиях!\n"+
                    "Мы убедились на опыте, что только практика в совокупности с мотивирующей атмосферой учебы в небольшой группе (наши группы состоят из 10 - 12 студентов) позволяет освоить новую профессию за короткий срок.\n"+
                    "\n"+
                    "Курсы:\n"+
                    "\n"+
                    "Детская академия\n"+
                    "\n"+
                    "Мастер-классы\n"+
                    "\n"+
                    "Веб-дизайн\n"+
                    "\n"+
                    "Программирование",
            image = "https://iili.io/2cW3OAv.md.png"
        ),
        Course(
            id = 1,
            name = "KIBERone Омск",
            desc = "ПЕРВАЯ МЕЖДУНАРОДНАЯ КИБЕРШКОЛА БУДУЩЕГО ДЛЯ НОВОГО IT-ПОКОЛЕНИЯ 6-14 ЛЕТ\n"+
                    "\n"+
                    "Курсы:\n"+
                    "\n"+
                    "Вводный модуль \n"+
                    "\n"+
                    "Устройство компьютера\n"+
                    "\n"+
                    "Магия презентациий\n"+
                    "\n"+
                    "Создание 3D-игр\n"+
                    "\n"+
                    "Создание приложений",
            image = "https://iili.io/2cWFn0F.md.png"
        ),
    )



    fun onAction(action: InfoViewAction) {
        when (action) {
            is InfoViewAction.OnBackClick -> {
                viewModelScope.launch {
                    sendEffect(InfoViewEffect.OnBackClick)
                }
            }

        }

        suspend fun getCompanies() {
            val handler = CoroutineExceptionHandler { _, throwable ->
                Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
            }

            viewModelScope.launch(handler) {
                updateState { copy(isLoading = true) }
                val companies = feedRepository.getAuthorsFromLocal()
                updateState {
                    copy(
                        companies = mockCompanies(),
                        articles = null,
                        courses = null,
                        isLoading = false,
                    )
                }
            }.invokeOnCompletion {
                viewModelScope.launch {
                    if (it != null) {
                        updateState { copy(isLoading = false) }
                        updateState {
                            copy(
                                companies = mockCompanies(),
                                articles = null,
                                courses = null,
                                isLoading = false,
                            )
                        }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                    }
                }
            }
        }

        suspend fun getArticles() {
            val handler = CoroutineExceptionHandler { _, throwable ->
                Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
            }

            viewModelScope.launch(handler) {
                updateState { copy(isLoading = true) }
                val articles = feedRepository.getArticlesFromLocal()
                updateState {
                    copy(
                        companies = null,
                        articles = mockFeed(),
                        courses = null,
                        isLoading = false,
                    )
                }
            }.invokeOnCompletion {
                viewModelScope.launch {
                    if (it != null) {
                        updateState { copy(isLoading = false) }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                        updateState {
                            copy(
                                companies = null,
                                articles = mockFeed(),
                                courses = null,
                                isLoading = false,
                            )
                        }
                    }
                }
            }
        }

        suspend fun getCourses() {
            val handler = CoroutineExceptionHandler { _, throwable ->
                Timber.tag("Section:").d(throwable, "error occurred: %s", 0)
            }

            viewModelScope.launch(handler) {
                updateState { copy(isLoading = true) }
                val courses = feedRepository.getPoetsFromLocal()
                updateState {
                    copy(
                        companies = null,
                        articles = null,
                        courses = mockCourses(),
                        isLoading = false,
                    )
                }
            }.invokeOnCompletion {
                viewModelScope.launch {
                    if (it != null) {
                        updateState { copy(isLoading = false) }
//                    sendEffect(SectionViewEffect.ShowError("Произошла ошибка!"))
                        updateState {
                            copy(
                                companies = null,
                                articles = null,
                                courses = mockCourses(),
                                isLoading = false,
                            )
                        }
                    }
                }
            }
        }
    }
}