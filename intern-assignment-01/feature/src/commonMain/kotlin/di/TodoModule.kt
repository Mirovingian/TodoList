package org.example.project.feature.di


import org.example.project.feature.viewmodel.TodoViewModel
import org.koin.dsl.module
import repository.api.TodoRepository
import repository.impl.TodoRepositoryImpl



val todoModule = module {
    single<TodoRepository> { TodoRepositoryImpl() }

    factory { TodoViewModel(repository = get()) }
}


