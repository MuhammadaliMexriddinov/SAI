package uz.alpha.stresometr.presentation.ui.screens.pages

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tapadoo.alerter.Alerter
import kotlinx.coroutines.delay
import uz.alpha.stresometr.MainActivity
import uz.alpha.stresometr.R
import uz.alpha.stresometr.databinding.ScreenStresometrBinding
import uz.alpha.stresometr.presentation.ui.dialogs.DialogLanguage
import uz.alpha.stresometr.presentation.ui.screens.MainScreenDirections
import uz.alpha.stresometr.presentation.vm.impl.MedViewModelImpl
import uz.alpha.stresometr.utils.hasConnection
import java.util.*

class StresometrPage : Fragment(R.layout.screen_stresometr) {

    private val binding by viewBinding(ScreenStresometrBinding::bind)
    private val viewModel by viewModels<MedViewModelImpl>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.progressLiveData.observe(this, progressObserver)

        viewModel.succesLiveData.observe(this) {
            if (it == "Stress Level: MEDIUM") {
                alertDialogShow(getString(R.string.str2) ,  R.drawable.yellow)
            }

            if (it == "Stress Level: HIGH") {
                alertDialogShow(getString(R.string.str3) , R.drawable.red)
            }

            if (it == "Stress Level: LOW") {
                alertDialogShow(getString(R.string.str1) , R.drawable.green)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasConnection()) {
            Alerter.create(requireActivity())
                .setText("NO INTERNET")
                .setBackgroundColorRes(R.color.purple_200)
                .setDuration(5000)
                .show()
        }

        binding.seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var num: Int = p1

                if (num >= 10000 && num <= 30000) {
                    binding.txtHumidity.setText(String.format("%.0f" , (num/1000f)))
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })


        binding.seek2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                var num: Int = p1

                if (num >= 26100 && num <= 37200) {
                        binding.txtTemperature.setText(String.format("%.0f" , (num/1000f)))
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //
            }

        })

        binding.seek3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                var num: Int = p1

                if (num >= 0 && num <= 200000) {
                    binding.txtStepCount.setText(String.format("%.0f" , (num/1000f)))
                }


            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                //
            }

        })



        binding.btnScoreStress.setOnClickListener {

            if (!hasConnection()) {
                Alerter.create(requireActivity())
                    .setText("NO INTERNET")
                    .setBackgroundColorRes(R.color.purple_200)
                    .setDuration(5000)
                    .show()
            }
            if (binding.txtHumidity.text.toString().isNotEmpty()) {
                if (binding.txtTemperature.text.toString().isNotEmpty()) {
                    if (binding.txtStepCount.text.toString().isNotEmpty()) {
                        viewModel.sendData(
                            binding.txtHumidity.text.toString(),
                            binding.txtTemperature.text.toString(),
                            binding.txtStepCount.text.toString(),
                        )
                    } else {
                        Alerter.create(requireActivity())
                            .setText(getString(R.string.txtStep))
                            .setTitle(getString(R.string.field))
                            .setBackgroundColorRes(R.color.purple_200)
                            .setDuration(5000)
                            .show()
                    }
                } else {
                    Alerter.create(requireActivity())
                        .setText(getString(R.string.txtTemperature))
                        .setTitle(getString(R.string.field))
                        .setBackgroundColorRes(R.color.purple_200)
                        .setDuration(5000)
                        .show()
                }
            } else {
                Alerter.create(requireActivity())
                    .setTitle(getString(R.string.txtHumidity))
                    .setText(getString(R.string.field))
                    .setBackgroundColorRes(R.color.purple_200)
                    .setDuration(5000)
                    .show()
            }
        }



    }

    private val progressObserver = Observer<Boolean> {
        if (it) binding.verfiedProgress.show() else binding.verfiedProgress.hide()
    }


    fun alertDialogShow(txtResponse: String ,  img:Int ) {
        val builder = AlertDialog.Builder(requireContext())
        //set title for alert dialog
        builder.setTitle(getString(R.string.sc))
        //set message for alert dialog
        builder.setMessage(txtResponse)
        builder.setIcon(img)
        //performing positive action
        builder.setPositiveButton("OK") { dialogInterface, which ->
     
            
        }
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }


}