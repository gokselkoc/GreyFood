package com.gokselkoc.greyfood.ui.home

import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.base.BaseFragment
import com.gokselkoc.greyfood.databinding.FragmentHomeBinding
import com.gokselkoc.greyfood.extension.observe
import com.gokselkoc.greyfood.models.CategoriesResponse
import com.gokselkoc.greyfood.models.CompanyResponse
import com.gokselkoc.greyfood.models.MostSellingResponse
import com.gokselkoc.greyfood.ui.home.adapter.CategoriesAdapter
import com.gokselkoc.greyfood.ui.home.adapter.CompaniesAdapter
import com.gokselkoc.greyfood.ui.home.adapter.MostSellingAdapter
import com.gokselkoc.greyfood.ui.home.adapter.ViewPagerAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var adapter: ViewPagerAdapter

    private val companiesAdapter: CompaniesAdapter by lazy {
        CompaniesAdapter(
            requireContext(),
            ArrayList()
        )
    }

    private val categoriesAdapter: CategoriesAdapter by lazy {
        CategoriesAdapter(
            requireContext(),
            ArrayList()
        )
    }

    private val mostSellingAdapter: MostSellingAdapter by lazy {
        MostSellingAdapter(
            requireContext(),
            ArrayList()
        )
    }

    override fun onFragmentCreate() {
    }

    override fun FragmentHomeBinding.initialize() {

        if (companiesAdapter.list.isEmpty() || categoriesAdapter.list.isEmpty() || mostSellingAdapter.list.isEmpty()) {
            observe(viewModel.companiesResponse, ::getCompanies)
            observe(viewModel.categoriesResponse, ::getCategories)
            observe(viewModel.mostSellingResponse, ::getMostSelling)

        }

        binding.companiesRecyclerView.adapter = companiesAdapter

        binding.categoriesRecyclerView.adapter = categoriesAdapter

        binding.mostSellingRecyclerView.adapter = mostSellingAdapter

        adapter = ViewPagerAdapter(
            childFragmentManager, 4
        )

        binding.viewPager.adapter = adapter
        binding.dotIndicator.setViewPager(binding.viewPager)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
            }

            override fun onPageSelected(position: Int) {

            }
        })

    }

    private fun getCompanies(data: ArrayList<CompanyResponse>) {
        companiesAdapter.addToAdapter(data)
    }

    private fun getCategories(data: ArrayList<CategoriesResponse>) {
        categoriesAdapter.addToAdapter(data)
    }

    private fun getMostSelling(data: ArrayList<MostSellingResponse>) {
        mostSellingAdapter.addToAdapter(data)
    }


}