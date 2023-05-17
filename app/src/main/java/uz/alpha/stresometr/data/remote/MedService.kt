package uz.alpha.stresometr.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import uz.alpha.stresometr.data.remote.response.MedResponse

interface MedService {

    @GET("/predict_stress")
    suspend fun register(
        @Query("Humidity") Humidity: String,
        @Query("Temperature") Temperature: String,
        @Query("Step_count") Step_count: String,
    ): Response<MedResponse>
}