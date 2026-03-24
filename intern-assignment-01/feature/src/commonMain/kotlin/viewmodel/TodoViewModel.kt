package org.example.project.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.TodoFilter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.feature.TodoScreenState
import repository.api.TodoRepository

class TodoViewModel(
    private val repository: TodoRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(TodoScreenState())
    val state: StateFlow<TodoScreenState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.todos.collect { todosList ->
                _state.update { currentState ->
                    currentState.copy(allTodos = todosList)
                }
            }
        }
    }

    fun onInputTextChanged(text: String) {
        _state.update { it.copy(inputText = text) }
    }

    fun onAddTodoClick() {
        val text = _state.value.inputText
        if (text.isNotBlank()) {
            viewModelScope.launch {
                repository.addTodo(text)
                _state.update { it.copy(inputText = "") }
            }
        }
    }

    fun onDeleteTodoClick(id: String) {
        viewModelScope.launch {
            repository.deleteTodo(id)
        }
    }

    fun onToggleTodoCompletion(id: String) {
        viewModelScope.launch {
            repository.toggleTodoCompletion(id)
        }
    }

    fun onFilterChanged(filter: TodoFilter) {
        _state.update { it.copy(currentFilter = filter) }
    }
}