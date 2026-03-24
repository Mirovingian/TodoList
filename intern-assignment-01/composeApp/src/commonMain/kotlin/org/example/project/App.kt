package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.koin.compose.KoinApplication
import org.example.project.feature.di.todoModule
import org.example.project.feature.view.TodoScreen
import org.example.project.feature.viewmodel.TodoViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    // Инициализация Koin для Compose Multiplatform
    KoinApplication(application = {
        modules(todoModule)
    }) {
        MaterialTheme {
            // Получаем ViewModel из Koin
            val viewModel: TodoViewModel = koinViewModel()

            // Запускаем основной экран
            TodoScreen(viewModel = viewModel)
        }
    }
}