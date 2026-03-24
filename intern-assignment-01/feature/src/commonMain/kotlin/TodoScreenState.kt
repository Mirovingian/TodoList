package org.example.project.feature

import domain.TodoFilter
import domain.TodoItem

data class TodoScreenState(
    val inputText: String = "",
    val currentFilter: TodoFilter = TodoFilter.ALL,
    val allTodos: List<TodoItem> = emptyList(),
) {
    val filteredTodos: List<TodoItem>
        get() = when (currentFilter) {
            TodoFilter.ALL -> allTodos
            TodoFilter.ACTIVE -> allTodos.filter { !it.isCompleted }
            TodoFilter.COMPLETED -> allTodos.filter { it.isCompleted }
        }

    val completedCount: Int
        get() = allTodos.count { it.isCompleted }

    val totalCount: Int
        get() = allTodos.size
}