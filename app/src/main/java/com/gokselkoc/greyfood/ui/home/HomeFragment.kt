package com.gokselkoc.greyfood.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.base.BaseFragment
import com.gokselkoc.greyfood.databinding.FragmentHomeBinding
import com.gokselkoc.greyfood.extension.navigateSafe
import com.gokselkoc.greyfood.extension.observe
import com.gokselkoc.greyfood.models.CategoriesResponse
import com.gokselkoc.greyfood.models.CompanyResponse
import com.gokselkoc.greyfood.models.MostSellingResponse
import com.gokselkoc.greyfood.ui.home.adapter.CategoriesAdapter
import com.gokselkoc.greyfood.ui.home.adapter.CompaniesAdapter
import com.gokselkoc.greyfood.ui.home.adapter.MostSellingAdapter
import com.gokselkoc.greyfood.ui.home.adapter.OnboardingAdapter
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()

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

    private lateinit var adapter: OnboardingAdapter
    var isLastPage: Boolean = false

    override fun onFragmentCreate() {
        observe(viewModel.basketButtonClickedResponse,::basketButtonClickedNavigation)
    }

    override fun FragmentHomeBinding.initialize() {

        binding.dotCardView

        if (companiesAdapter.list.isEmpty() || categoriesAdapter.list.isEmpty() || mostSellingAdapter.list.isEmpty()) {
            observe(viewModel.companiesResponse, ::getCompanies)
            observe(viewModel.categoriesResponse, ::getCategories)
            observe(viewModel.mostSellingResponse, ::getMostSelling)

        }
        binding.companiesRecyclerView.adapter = companiesAdapter

        binding.categoriesRecyclerView.adapter = categoriesAdapter

        binding.mostSellingRecyclerView.adapter = mostSellingAdapter

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

    private fun basketButtonClickedNavigation(isClicked : Boolean){
        if (isClicked){
            navigateClickedItemFragment(R.id.basket_nav_graph)
        }
    }


    private fun navigateClickedItemFragment(clickedItem: Int) {

        navigateSafe(resId = clickedItem)
    }

}