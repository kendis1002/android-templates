package co.nimblehq.sample.compose.ui.screens.main.file

import androidx.lifecycle.viewModelScope
import co.nimblehq.sample.compose.domain.models.MediaFile
import co.nimblehq.sample.compose.domain.usecases.GetAllMediaFileUseCase
import co.nimblehq.sample.compose.ui.base.BaseViewModel
import co.nimblehq.sample.compose.util.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FileViewModel @Inject constructor(
    getAllMediaFileUseCase: GetAllMediaFileUseCase,
    private val dispatchersProvider: DispatchersProvider
) : BaseViewModel() {

    private val _uiModels = MutableStateFlow<List<MediaFile>>(listOf())
    val uiModels: StateFlow<List<MediaFile>> = _uiModels.asStateFlow()

    init {
        getAllMediaFileUseCase()
            .injectLoading()
            .onEach { result ->
                val uiModels = result.map { it }
                _uiModels.emit(uiModels)
            }
            .flowOn(dispatchersProvider.io)
            .catch { e -> _error.emit(e) }
            .launchIn(viewModelScope)
    }
}