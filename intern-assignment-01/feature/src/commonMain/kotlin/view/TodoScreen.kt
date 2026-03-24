package org.example.project.feature.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.TodoFilter
import org.example.project.feature.viewmodel.TodoViewModel


@Composable
fun TodoScreen(
    viewModel: TodoViewModel,
) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                value = state.inputText,
                onValueChange = viewModel::onInputTextChanged,
                modifier = Modifier.weight(1f),
                label = { Text("Новая задача") },
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = viewModel::onAddTodoClick) {
                Text("Добавить")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Задачи: ${state.completedCount} выполнено / ${state.totalCount} всего",
            style = MaterialTheme.typography.labelLarge,
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Фильтры
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            TodoFilter.entries.forEach { filter ->
                FilterChip(
                    selected = state.currentFilter == filter,
                    onClick = { viewModel.onFilterChanged(filter) },
                    label = { Text(filter.name) },
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = state.filteredTodos, key = { it.id }) { todo ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(
                        checked = todo.isCompleted,
                        onCheckedChange = { viewModel.onToggleTodoCompletion(todo.id) },
                    )
                    Text(
                        text = todo.text,
                        modifier = Modifier.weight(1f),
                    )
                    TextButton(onClick = { viewModel.onDeleteTodoClick(todo.id) }) {
                        Text("Удалить")
                    }
                }
            }
        }
    }
}