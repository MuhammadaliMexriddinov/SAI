package uz.alpha.stresometr.presentation.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.alpha.stresometr.presentation.ui.screens.pages.OthersPage
import uz.alpha.stresometr.presentation.ui.screens.pages.PedometrPage
import uz.alpha.stresometr.presentation.ui.screens.pages.StresometrPage

class MainAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StresometrPage()
            1-> PedometrPage()
            else -> OthersPage()
        }
    }

}