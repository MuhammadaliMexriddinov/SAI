package uz.alpha.stresometr.presentation.ui.screens.pages

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tapadoo.alerter.Alerter
import uz.alpha.stresometr.R
import uz.alpha.stresometr.data.local.PedoData
import uz.alpha.stresometr.databinding.ScreenPedometrBinding
import uz.alpha.stresometr.presentation.ui.screens.MainScreenDirections
import uz.alpha.stresometr.presentation.vm.impl.PedometrViewModel
import uz.alpha.stresometr.utils.Extension

class PedometrPage : Fragment(R.layout.screen_pedometr) {


    private val binding by viewBinding(ScreenPedometrBinding::bind)
    private val viewModel by viewModels<PedometrViewModel>()

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            binding.seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    var num: Int = p1

                    if (num >= 40000 && num <= 150000) {
                        binding.inputWeight.setText(String.format("%.0f" , (num/1000f)))
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
            binding.seek2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    var num: Int = p1

                    if (num >= 100000 && num <= 220000) {
                        binding.inputHeight.setText(String.format("%.0f" , (num/1000f)))
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
            binding.seek3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    var num: Int = p1

                    if (num >= 1000 && num <= 50000000) {
                        binding.inputRoad.setText(String.format("%.0f" , (num/1000f)))
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })
            binding.seek4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    var num: Int = p1

                    if (num >= 1000 && num <= 360000) {
                        binding.inputTime.setText(String.format("%.0f" , (num/1000f)))
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }

            })



            btnScore.setOnClickListener {
                if (binding.inputWeight.text.toString().toDouble()>0.0) {
                    if (binding.inputHeight.text.toString().toDouble()>0.0) {
                        if (binding.inputRoad.text.toString().toDouble()>0.0) {
                            if (binding.inputTime.text.toString().toDouble()>0.0) {

                                Extension.massa = binding.inputWeight.text.toString()
                                Extension.haight = binding.inputHeight.text.toString()
                                Extension.step = binding.inputRoad.text.toString()
                                Extension.time = binding.inputTime.text.toString()


                                findNavController().navigate(
                                    MainScreenDirections.actionMainScreenToScoreScreen(
                                        PedoData(
                                            massa = binding.inputWeight.toString(),
                                            haight = binding.inputHeight.toString(),
                                            step = binding.inputRoad.toString(),
                                            time = binding.inputTime.toString()
                                        )
                                    )
                                )
                            } else {
                                Alerter.create(requireActivity())
                                    .setText(getString(R.string.txtTime))
                                    .setTitle(getString(R.string.field))
                                    .setBackgroundColorRes(R.color.purple_200)
                                    .setDuration(5000)
                                    .show()
                            }
                        } else {
                            Alerter.create(requireActivity())
                                .setText(getString(R.string.txtRoad))
                                .setTitle(getString(R.string.field))
                                .setBackgroundColorRes(R.color.purple_200)
                                .setDuration(5000)
                                .show()
                        }
                    } else {
                        Alerter.create(requireActivity())
                            .setText(getString(R.string.txtHeight))
                            .setTitle(getString(R.string.field))
                            .setBackgroundColorRes(R.color.purple_200)
                            .setDuration(5000)
                            .show()
                    }
                } else {
                    Alerter.create(requireActivity())
                        .setText(getString(R.string.txtWeight))
                        .setTitle(getString(R.string.field))
                        .setBackgroundColorRes(R.color.purple_200)
                        .setDuration(5000)
                        .show()
                }

            }
            }
        }
    }


