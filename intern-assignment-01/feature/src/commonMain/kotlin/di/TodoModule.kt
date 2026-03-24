package org.example.project.feature.di


import org.example.project.feature.ViewModel.TodoViewModel
import org.koin.dsl.module
import repository.api.TodoRepository
import repository.impl.TodoRepositoryImpl



val todoModule = module {
    // 1. Указываем, как создать репозиторий
    single<TodoRepository> { TodoRepositoryImpl() }

    // 2. Указываем, как создать ViewModel
    factory { TodoViewModel(repository = get()) }
}


