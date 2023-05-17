package uz.alpha.stresometr.presentation.ui.dialogs

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import uz.alpha.stresometr.MainActivity
import uz.alpha.stresometr.R
import uz.alpha.stresometr.data.local.SharedPref
import uz.alpha.stresometr.databinding.DialogLanuageBinding
import uz.alpha.stresometr.utils.Extension
import java.util.*

class DialogLanguage : DialogFragment(R.layout.dialog_lanuage) {

    private lateinit var engBtnClickListener: (() -> Unit)
    private lateinit var uzBtnClickListener: (() -> Unit)


    fun setEngBtnClickListener(listener: (() -> Unit)) {
        engBtnClickListener = listener
    }

    fun setUzBtnClickListener(listener: (() -> Unit)) {
        uzBtnClickListener = listener
    }

    private val binding by viewBinding(DialogLanuageBinding::bind)


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//
//        if (pos==1){
//            dialog?.cancel()
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickEvents()

//        binding.l2.setOnClickListener {
//            val language = "ru"
//            setLocate(language)
//            binding.txtUz.text = getString(R.string.uz)
//            binding.txtRu.text = getString(R.string.ru)
////            binding.txt.text = getString(R.string.language)
//            requireActivity().recreate()
//            this.dismiss()
//        }
//
//        binding.l1.setOnClickListener {
//            val language = "uz"
//            setLocate(language)
//            binding.txtUz.text = getString(R.string.uz)
//            binding.txtRu.text = getString(R.string.ru)
////            binding.txt.text = getString(R.string.language)
//            requireActivity().recreate()
//            this.dismiss()
//        }
    }


    private fun setLocate(language: String) {
        val resources: Resources = resources
        val metric: DisplayMetrics = resources.displayMetrics
        val configuration = resources.configuration
        configuration.locale = Locale(language)
        resources.updateConfiguration(configuration, metric)
        onConfigurationChanged(configuration)
        SharedPref.getInstance().language = language
    }

    override fun onResume() {
        super.onResume()
        val params = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params
    }


    private fun clickEvents() = with(binding) {
        l1.setOnClickListener {
//            setLang(Locale("uz"))
//            dialog?.dismiss()
//            dialog?.cancel()
            uzBtnClickListener.invoke()
        }
        l2.setOnClickListener {
//            dialog?.dismiss()
//            dialog?.cancel()
//            Extension.dialo = 1
            engBtnClickListener.invoke()
        }


    }

    private fun setLang(locale: Locale) {
        //  boldLangText(locale)
        val activity = (requireActivity() as MainActivity)
//        activity.mySetLocate(locale) {
//            lifecycleScope.launchWhenCreated {
//                delay(2000)
//            }
//        }
    }


}