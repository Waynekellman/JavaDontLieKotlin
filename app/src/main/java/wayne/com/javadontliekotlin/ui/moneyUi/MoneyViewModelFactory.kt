package wayne.com.javadontliekotlin.ui.moneyUi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import wayne.com.javadontliekotlin.data.repository.IGameRepository

class MoneyViewModelFactory (private val repository: IGameRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoneyViewModel(repository) as T
    }
}
