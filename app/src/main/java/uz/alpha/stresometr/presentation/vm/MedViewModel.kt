package uz.alpha.stresometr.presentation.vm


import androidx.lifecycle.MutableLiveData

interface MedViewModel {
    // val openHomeScreenLiveData: MutableLiveData<Unit>
    val errorMessageLiveData: MutableLiveData<String>
    val notConnectionLiveData: MutableLiveData<Unit>
    val succesLiveData:MutableLiveData<String>

    // val changeButtonStatusLiveData : MutableLiveData<Boolean>
    val progressLiveData: MutableLiveData<Boolean>
    fun sendData(
        Humidity: String,
        Temperature: String,
        Step_count: String
    )



}