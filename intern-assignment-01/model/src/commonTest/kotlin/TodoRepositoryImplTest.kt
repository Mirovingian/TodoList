package org.example.project.model

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import repository.impl.TodoRepositoryImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TodoRepositoryImplTest {

    @Test
    fun `addTodo should add new item to flow`() = runTest {
        val repository = TodoRepositoryImpl()

        repository.addTodo("Купить молоко")

        val todos = repository.todos.first()
        assertEquals(1, todos.size)
        assertEquals("Купить молоко", todos[0].text)
        assertEquals(false, todos[0].isCompleted)
    }

    @Test
    fun `deleteTodo should remove item from flow`() = runTest {
        val repository = TodoRepositoryImpl()
        repository.addTodo("Задача для удаления")
        val id = repository.todos.first()[0].id

        repository.deleteTodo(id)

        val todos = repository.todos.first()
        assertTrue(todos.isEmpty(), "Список должен быть пустым после удаления")
    }

    @Test
    fun `toggleTodoCompletion should change isCompleted status`() = runTest {
        val repository = TodoRepositoryImpl()
        repository.addTodo("Тестовая задача")
        val id = repository.todos.first()[0].id

        repository.toggleTodoCompletion(id)

        val todos = repository.todos.first()
        assertTrue(todos[0].isCompleted, "Статус задачи должен измениться на true")
    }
}