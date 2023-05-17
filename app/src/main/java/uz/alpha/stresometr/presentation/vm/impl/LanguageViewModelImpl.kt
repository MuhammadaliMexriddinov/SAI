package uz.alpha.stresometr.presentation.vm.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.alpha.stresometr.presentation.vm.LanguageViewModel
import javax.inject.Inject


class LanguageViewModelImpl() : ViewModel(), LanguageViewModel {


    val backLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun home() {

    }


    override fun back() {
        viewModelScope.launch {
            backLiveData.postValue(Unit)
        }
    }

    override fun delaying() {
        viewModelScope.launch {
            delay(300)
          //  back()
        }
    }
}