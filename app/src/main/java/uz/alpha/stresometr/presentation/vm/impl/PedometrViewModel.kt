package uz.alpha.stresometr.presentation.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PedometrViewModel:ViewModel() {


    val livedata: LiveData<Boolean> = MutableLiveData()

}