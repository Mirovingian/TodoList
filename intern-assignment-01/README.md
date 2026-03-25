# Kotlin Multiplatform Todo List
## 1. Описание задания

**Цель проекта:** Разработка кроссплатформенного приложения «Список задач» (Todo List) с использованием Kotlin Multiplatform (KMP) и архитектурного паттерна MVVM.

**Реализованный функционал:**
* Добавление новых задач.
* Удаление существующих задач.
* Изменение статуса задачи (выполнено / не выполнено) с помощью чекбоксов.
* Фильтрация списка (Все / Активные / Выполненные).
* Динамический подсчет количества выполненных и общего числа задач.

**Технологический стек:**
* **Язык и платформа:** Kotlin Multiplatform (Android, iOS, Desktop)
* **UI-фреймворк:** Compose Multiplatform
* **Архитектура:** MVVM (Model-View-ViewModel) + StateFlow
* **Внедрение зависимостей (DI):** Koin
* **Асинхронная работа:** Kotlinx Coroutines

---

## 2. Скриншоты экрана

<img width="312" height="693" alt="image" src="https://github.com/user-attachments/assets/6280fde5-8280-4a58-a371-f5032793078f" /><img width="312" height="694" alt="image" src="https://github.com/user-attachments/assets/353a318d-c824-4b3c-a3cf-f74e66c25d20" />
<img width="313" height="692" alt="image" src="https://github.com/user-attachments/assets/124e173f-79bf-464e-b0e9-d4cc49bd16c3" />


---

## 3. Ссылка на видео

* Посмотрите демонстрацию работы приложения:
📺 https://www.youtube.com/shorts/s0IKR7uOm5s
---

## 4. Ссылка на APK

* Готовую сборку для Android можно скачать в разделе Releases:
📦 https://github.com/Mirovingian/TodoList/releases/tag/v1.0.0

---

## 5. Инструкция по запуску

### 1. Загрузка и установка apk приложения на android устройство
* Скачайте актуальную версию приложения releases и установить на android устройство

### 2. Сборка и запуск
#### Требования
* **JDK 17 или 21** (обязательно настройте переменную `JAVA_HOME`).
* **Android Studio** (последней версии, например, Ladybug).
* **Xcode** (только если планируете запуск под iOS).

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Mirovingian/TodoList.git
   ```
2. Откройте проект в Android Studio.

3. Дождитесь завершения Gradle Sync (пока не скачаются все зависимости).

4. Выберите нужную конфигурацию запуска (Run Configuration) на верхней панели.

5. Нажмите кнопку Run (зеленый треугольник).

### Сборка APK
1. Введите команду:
 ```bash
   ./gradlew :composeApp:assembleRelease
   ```
2. APK будет находиться в: composeApp/build/outputs/apk/release/

## 6. Использованные ИИ-инструменты

* Gemini