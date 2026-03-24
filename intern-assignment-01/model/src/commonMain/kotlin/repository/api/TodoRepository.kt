package repository.api

import domain.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    val todos: Flow<List<TodoItem>>

    suspend fun addTodo(text: String)

    suspend fun deleteTodo(id: String)

    suspend fun toggleTodoCompletion(id: String)
}