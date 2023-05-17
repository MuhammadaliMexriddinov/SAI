    package uz.alpha.stresometr.presentation.ui.screens

    import android.os.Bundle
    import android.view.View
    import androidx.activity.addCallback
    import androidx.fragment.app.Fragment
    import androidx.viewpager2.widget.ViewPager2
    import by.kirich1409.viewbindingdelegate.viewBinding
    import com.google.android.material.tabs.TabLayoutMediator
    import uz.alpha.stresometr.R
    import uz.alpha.stresometr.databinding.ScreenMainBinding
    import uz.alpha.stresometr.presentation.ui.adapter.MainAdapter
    import uz.alpha.stresometr.presentation.ui.dialogs.DialogLanguage
    import uz.alpha.stresometr.utils.CubeTransformer
    import uz.alpha.stresometr.utils.Extension


    class MainScreen : Fragment(R.layout.screen_main) {

        private val binding by viewBinding(ScreenMainBinding::bind)



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)


            binding.pageMain.adapter = MainAdapter(requireActivity())


            /**
             * TabLayout
             * */
            TabLayoutMediator(binding.mainTab, binding.pageMain) { tab, pos ->
                when (pos) {
                    0 -> {
                        tab.setText(getString(R.string.stressometr))
                    }
                    1->{
                        tab.setText(getString(R.string.pedometr))
                    }
                    else -> {
                        tab.setText(getString(R.string.settings))
                    }
                }


            }.attach()

            binding.pageMain.setPageTransformer(CubeTransformer())

            requireActivity().onBackPressedDispatcher.addCallback(this) {
                requireActivity().finish()
            }

            /**
             * VP2
             * */
            binding.pageMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> {
    //                        val x: String = getString(R.string.main1)
    //                        binding.txtCategory.text = x
                        }
                        1->{
                            //
                        }
                        else -> {
    //                        val z: String = getString(R.string.main3)
    //                        binding.txtCategory.text = z
                        }
                    }
                }
            }
            )


        }
    }