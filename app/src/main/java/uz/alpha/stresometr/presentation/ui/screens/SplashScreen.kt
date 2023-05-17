package uz.alpha.stresometr.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.coroutines.delay
import uz.alpha.stresometr.R
import uz.alpha.stresometr.databinding.ScreenSplashBinding

class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
                binding.txt.startAnimation(AnimationUtils.loadAnimation(requireContext(), R.anim.text))
            delay(1500)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }
    }


}