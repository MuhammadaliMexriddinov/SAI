package uz.alpha.stresometr

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.prongbang.localization.LocalizationAppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        block?.invoke()
//        openPrepareLocalize()
//        super.onConfigurationChanged(newConfig)
//    }
//
//    fun mySetLocate(locale: Locale, _block: (() -> Unit)) {
//        block = _block
//        setLocale(locale)
//    }

    private var block: (() -> Unit)? = null
}