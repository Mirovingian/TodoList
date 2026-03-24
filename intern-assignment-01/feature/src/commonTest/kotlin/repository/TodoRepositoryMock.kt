package repository

import domain.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import repository.api.TodoRepository

class TodoRepositoryMock : TodoRepository {
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    override val todos: Flow<List<TodoItem>> = _todos

    override suspend fun addTodo(text: String) {
        _todos.update { it + TodoItem(id = "1", text = text) }
    }

    override suspend fun deleteTodo(id: String) {
        _todos.update { list -> list.filterNot { it.id == id } }
    }

    override suspend fun toggleTodoCompletion(id: String) {
        _todos.update { list ->
            list.map { if (it.id == id) it.copy(isCompleted = !it.isCompleted) else it }
        }
    }
}