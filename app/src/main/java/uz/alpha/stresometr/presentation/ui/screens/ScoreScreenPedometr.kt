package uz.alpha.stresometr.presentation.ui.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.stresometr.R
import uz.alpha.stresometr.databinding.ScreenScoreBinding
import uz.alpha.stresometr.utils.Extension
import kotlin.math.log

class ScoreScreenPedometr : Fragment(R.layout.screen_score) {

    var quvvat: String = ""
    var quvvat2 = 0.0
    var kaloriya: String = ""
    var tezlik: String = ""
    var tezlik2 = 0.0
    var qadam1 = 0.0
    var qadam = ""
    var soni: String = ""
    var isChecked: Boolean = false
    var index = 0.0


    private val binding by viewBinding(ScreenScoreBinding::bind)
    private val args: ScoreScreenPedometrArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val data = args.data1

        val massa1  : String = Extension.massa
        val haight1 : String = Extension.haight
        val road1  :String =  Extension.step
        val time1 : String = Extension.time

        println(massa1)
        println(haight1)

        Log.d("KKK", "MASSA = $massa1, \nBOYI=$haight1 , \nROAD = $road1 , \nVAQT = $time1")
        Log.d("OOO", "MASSA = $massa1")


        val massa :Double = massa1.toDouble()
        val haight :Double= haight1.toDouble()
        val road : Double = road1.toDouble()
        val time  : Double= time1.toDouble()

        /**
         * qadam
         * */
        qadam1 = (haight * 0.414)
        qadam = String.format("%.1f", qadam1)

        /**
         * qadam soni
         * */
        soni = String.format("%.1f", road / qadam1)


        /**
         * tezlik
         * */
        tezlik2 = (3.6 * road / time)
        tezlik = String.format("%.1f", tezlik2)

        /**
         * quvvat
         * */
        quvvat2 = (0.035 * massa + (tezlik2 * tezlik2) / (haight) * 0.029 * massa)
        quvvat = String.format("%.1f", quvvat2)

        /**
         * Kaloriya
         * */
        kaloriya = String.format("%.1f", quvvat2 * time)


        binding.apply {
            txt1.text = quvvat + getString(R.string.b2)
            txt2.text = kaloriya + getString(R.string.b1)
            txt3.text = tezlik + getString(R.string.b4)
            txt5.text = soni + getString(R.string.b3)

            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }



    }

    fun String.fullTrim() = trim().replace("\uFEFF", "")
}