package com.gokselkoc.greyfood.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.models.CategoriesResponse
import com.gokselkoc.greyfood.models.CompanyResponse
import com.gokselkoc.greyfood.models.MostSellingResponse


class HomeViewModel() : ViewModel() {


    private val _companiesResponse = MutableLiveData<ArrayList<CompanyResponse>>()
    val companiesResponse: LiveData<ArrayList<CompanyResponse>> = _companiesResponse

    private val _categoriesResponse = MutableLiveData<ArrayList<CategoriesResponse>>()
    val categoriesResponse: LiveData<ArrayList<CategoriesResponse>> = _categoriesResponse

    private val _mostSellingResponse = MutableLiveData<ArrayList<MostSellingResponse>>()
    val mostSellingResponse : LiveData<ArrayList<MostSellingResponse>> = _mostSellingResponse


    init {
        getCompanies()
        getCategories()
        getMostSelling()
    }

    private fun getCompanies() {
        _companiesResponse.value = getCompaniesList()
    }

    private fun getCategories(){
        _categoriesResponse.value = getCategoriesList()
    }

    private fun getMostSelling(){
        _mostSellingResponse.value = getMostSellingList()
    }


    private fun getCompaniesList(): ArrayList<CompanyResponse> {
        return arrayListOf(
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home),
            CompanyResponse("Capri Sun", R.drawable.ic_home)
        )
    }

    private fun getCategoriesList(): ArrayList<CategoriesResponse> {
        return arrayListOf(
            CategoriesResponse("Snack", R.drawable.logo),
            CategoriesResponse("Beverages", R.drawable.logo),
            CategoriesResponse("Wafer", R.drawable.logo),
            CategoriesResponse("Ice Cream", R.drawable.logo),
            CategoriesResponse("Chocolate", R.drawable.logo),
            CategoriesResponse("Coffee", R.drawable.logo)
        )
    }

    private fun getMostSellingList() : ArrayList<MostSellingResponse>{
        return arrayListOf(
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image),
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image),
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image),
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image),
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image),
            MostSellingResponse("Nutella Biscuits", R.drawable.background_image)
        )
    }
}

