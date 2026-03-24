package domain
import kotlinx.serialization.Serializable
@Serializable
data class TodoItem(
    val id: String,
    val text: String,
    val isCompleted: Boolean = false,
)