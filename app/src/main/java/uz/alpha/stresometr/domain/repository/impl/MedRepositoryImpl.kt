package uz.alpha.stresometr.domain.repository.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import uz.alpha.stresometr.data.remote.ApiClient
import uz.alpha.stresometr.domain.repository.MedRepository

class MedRepositoryImpl:MedRepository {

    private val api = ApiClient.getMedApi()
    private val api2 = ApiClient.getMedApi2()

    override fun sendData(
        Humidity: String,
        Temperature: String,
        Step_count: String
    ): Flow<Result<String>> = flow <Result<String>> {


        val response = withTimeoutOrNull(1500) {
            val response = api.register(Humidity, Temperature, Step_count)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }
        if (response != null) {
            // Handle response
        } else {
            val response2 = api2.register(Humidity, Temperature, Step_count)

            if (response2.isSuccessful) {
                response2.body()?.let {
                    emit(Result.success(it.result))
                }
            }
        }



    }.catch {
        emit(Result.failure(Exception(it.message)))

    }.flowOn(Dispatchers.IO)
}