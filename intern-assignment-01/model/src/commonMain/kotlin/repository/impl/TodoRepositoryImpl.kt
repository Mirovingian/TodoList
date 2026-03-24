package repository.impl


import domain.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import repository.api.TodoRepository
import kotlin.random.Random

class TodoRepositoryImpl : TodoRepository {

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    override val todos: Flow<List<TodoItem>> = _todos.asStateFlow()

    override suspend fun addTodo(text: String) {
        if (text.isBlank()) return

        val newItem = TodoItem(
            id = generateId(),
            text = text,
        )

        _todos.update { currentList ->
            currentList + newItem
        }
    }

    override suspend fun deleteTodo(id: String) {
        _todos.update { currentList ->
            currentList.filterNot { it.id == id }
        }
    }

    override suspend fun toggleTodoCompletion(id: String) {
        _todos.update { currentList ->
            currentList.map { item ->
                if (item.id == id) {
                    item.copy(isCompleted = !item.isCompleted)
                } else {
                    item
                }
            }
        }
    }

    private fun generateId(): String {
        return Random.nextLong().toString()
    }
}