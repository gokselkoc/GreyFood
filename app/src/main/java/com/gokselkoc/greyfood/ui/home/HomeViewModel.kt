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
    val mostSellingResponse: LiveData<ArrayList<MostSellingResponse>> = _mostSellingResponse



    init {
        getCompanies()
        getCategories()
        getMostSelling()
    }

    private fun getCompanies() {
        _companiesResponse.value = getCompaniesList()
    }

    private fun getCategories() {
        _categoriesResponse.value = getCategoriesList()
    }

    private fun getMostSelling() {
        _mostSellingResponse.value = getMostSellingList()
    }


    private fun getCompaniesList(): ArrayList<CompanyResponse> {
        return arrayListOf(
            CompanyResponse("Hanuta", R.drawable.hanuta),
            CompanyResponse("Giotto", R.drawable.giotto),
            CompanyResponse("Ferrero", R.drawable.ic_ferrero_logo),
            CompanyResponse("Capri Sun", R.drawable.ic_caprisun_logo),
            CompanyResponse("Nestle", R.drawable.ic_nestle_logo),
            CompanyResponse("Nutella", R.drawable.ic_nutella_logo),
            CompanyResponse("Kinder", R.drawable.ic_kinder_logo),
            CompanyResponse("Pringles", R.drawable.ic_pringles_logo),
            CompanyResponse("Nigde Gazoz", R.drawable.ic_nigdegazoz_logo),
            CompanyResponse("Lays", R.drawable.ic_lays_logo),
        )
    }

    private fun getCategoriesList(): ArrayList<CategoriesResponse> {
        return arrayListOf(
            CategoriesResponse("Atıştırmalık", R.drawable.snacks),
            CategoriesResponse("İçecekler", R.drawable.drinks),
            CategoriesResponse("Gofret", R.drawable.wafer),
            CategoriesResponse("Dondurma", R.drawable.icecream),
            CategoriesResponse("Çikolata", R.drawable.chocolate),
            CategoriesResponse("Kahve", R.drawable.coffee)
        )
    }

    private fun getMostSellingList(): ArrayList<MostSellingResponse> {
        return arrayListOf(
            MostSellingResponse("Nutella Biscuits", R.drawable.nutellabiscuits),
            MostSellingResponse("Scoob", R.drawable.scoobsnacks),
            MostSellingResponse("Pringles", R.drawable.pringlesmostselling),
            MostSellingResponse("Milka Oreo Choco", R.drawable.milka),
            MostSellingResponse("Beyoğlu Gazozu Zencefilli", R.drawable.beyoglugazozu),
            MostSellingResponse("Fantasia Ice Cream", R.drawable.icecream)
        )
    }



}

