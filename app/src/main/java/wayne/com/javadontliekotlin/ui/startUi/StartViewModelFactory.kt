package wayne.com.javadontliekotlin.ui.startUi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import wayne.com.javadontliekotlin.data.repository.IGameRepository

class StartViewModelFactory(private val repository: IGameRepository) : ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StartViewModel(repository) as T
    }
}