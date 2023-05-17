package uz.alpha.stresometr.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.alpha.stresometr.R
import uz.alpha.stresometr.databinding.DemoBinding

class Demo : Fragment(R.layout.demo) {

    private  val binding by viewBinding(DemoBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                var num: Int = p1

                if (num >= 10000 && num <= 30000) {
                    binding.txtHumidity.setText((num / 1000f).toString())
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Toast.makeText(requireContext(), "Muhammadali", Toast.LENGTH_SHORT).show()
            }

        })


    }
}