package uz.alpha.stresometr.app

import android.app.Application
import android.content.Context
import com.prongbang.localization.LocalizationApplication

class App: Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}