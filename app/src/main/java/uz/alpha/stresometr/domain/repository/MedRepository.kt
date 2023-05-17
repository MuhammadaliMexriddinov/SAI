package uz.alpha.stresometr.domain.repository

import java.util.concurrent.Flow

interface MedRepository {
        fun sendData(Humidity:String ,  Temperature:String ,  Step_count:String):kotlinx.coroutines.flow.Flow<Result<String>>
}