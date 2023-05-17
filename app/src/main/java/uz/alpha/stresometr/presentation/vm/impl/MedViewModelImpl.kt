package uz.alpha.stresometr.presentation.vm.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uz.alpha.stresometr.domain.repository.impl.MedRepositoryImpl
import uz.alpha.stresometr.presentation.vm.MedViewModel
import uz.alpha.stresometr.utils.hasConnection

class MedViewModelImpl: MedViewModel,  ViewModel() {
    private  val repo= MedRepositoryImpl()
    override val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    override val notConnectionLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val succesLiveData: MutableLiveData<String> =  MutableLiveData()
    override val progressLiveData: MutableLiveData<Boolean> =  MutableLiveData()

    override fun sendData(
        Humidity: String,
        Temperature: String,
        Step_count: String
    ) {
        progressLiveData.value = true
        if (!hasConnection()) {
            progressLiveData.value = false
            notConnectionLiveData.value = Unit
            return
        }


        viewModelScope.launch {
          repo.sendData(Humidity ,  Temperature ,  Step_count).flowOn(Dispatchers.Main).collect{
              it.onSuccess {
                 progressLiveData.value=false
                  succesLiveData.value=it.toString()
              }

              it.onFailure {
                  progressLiveData.value = true
                  errorMessageLiveData.value = "NO INTERNET"
              }
          }
        }
    }
}