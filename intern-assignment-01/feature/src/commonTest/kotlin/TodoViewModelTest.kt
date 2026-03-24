import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.example.project.feature.viewmodel.TodoViewModel
import repository.TodoRepositoryMock
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TodoViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `onInputTextChanged should update inputText in state`() {
        val viewModel = TodoViewModel(TodoRepositoryMock())

        viewModel.onInputTextChanged("Новый текст")

        assertEquals("Новый текст", viewModel.state.value.inputText)
    }

    @Test
    fun `onAddTodoClick should clear input text and trigger repository`() = runTest {
        val viewModel = TodoViewModel(TodoRepositoryMock())

        viewModel.onInputTextChanged("Новая задача")
        viewModel.onAddTodoClick()

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("", viewModel.state.value.inputText)
        assertEquals(1, viewModel.state.value.allTodos.size)
        assertEquals("Новая задача", viewModel.state.value.allTodos[0].text)
    }
}