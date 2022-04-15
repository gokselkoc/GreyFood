package com.gokselkoc.greyfood.ui.home

import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.base.BaseFragment
import com.gokselkoc.greyfood.databinding.FragmentHomeBinding
import com.gokselkoc.greyfood.extension.observe
import com.gokselkoc.greyfood.models.CompanyResponse
import com.gokselkoc.greyfood.ui.home.adapter.CompaniesAdapter
import com.gokselkoc.greyfood.ui.home.adapter.OnboardingAdapter



class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

    val companiesAdapter: CompaniesAdapter by lazy {
        CompaniesAdapter(
            ArrayList()
        )
    }

    private lateinit var adapter: OnboardingAdapter
    var isLastPage: Boolean = false



    override fun FragmentHomeBinding.initialize() {

        observe(viewModel.companiesResponse,::getCompanies)
        binding.companiesRecyclerView.adapter = companiesAdapter

        adapter = OnboardingAdapter(
            childFragmentManager, 4
        )

        binding.viewPager.adapter = adapter
        binding.dotIndicator.setViewPager(binding.viewPager)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }
        })

    }

    private fun getCompanies(data : ArrayList<CompanyResponse>){
        companiesAdapter.addToAdapter(data)
    }

}