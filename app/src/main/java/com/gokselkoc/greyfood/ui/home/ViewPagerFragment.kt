package com.gokselkoc.greyfood.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.databinding.FragmentOnboardingPageBinding


class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_onboarding_page,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        initLayout(arguments?.getInt(ARG_POSITION) ?: throw IllegalStateException())
        return binding.root
    }

    private fun initLayout(position: Int) {



            binding.imageView.apply {
                setImageResource(
                    when (position) {
                        0 -> R.drawable.slidercips
                        1 -> R.drawable.slider_drink
                        2 -> R.drawable.slider_ice_cream
                        3 -> R.drawable.slider_chocolate

                        else -> {
                            throw Exception()
                        }
                    }
                )
        }
    }

    companion object {
        private const val ARG_POSITION = "arg_position"
        fun newInstance(position: Int): ViewPagerFragment {
            return ViewPagerFragment()
                .apply {
                    arguments = Bundle().apply {
                        putInt(ARG_POSITION, position)
                    }
                }
        }
    }


}