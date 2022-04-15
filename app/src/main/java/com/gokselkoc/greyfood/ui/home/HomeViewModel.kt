package com.gokselkoc.greyfood.ui.home

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokselkoc.greyfood.R
import com.gokselkoc.greyfood.models.CompanyResponse
import com.gokselkoc.greyfood.ui.home.adapter.CompaniesAdapter
import kotlin.coroutines.coroutineContext

class HomeViewModel( ) : ViewModel() {


    private val _companiesResponse = MutableLiveData<ArrayList<CompanyResponse>>()
    val companiesResponse: LiveData<ArrayList<CompanyResponse>> = _companiesResponse


    init {
        getCompanies()

    }

    private fun getCompanies() {
        _companiesResponse.value = getCompaniesList()
    }


    private fun getCompaniesList(): ArrayList<CompanyResponse> {
        return arrayListOf(
            CompanyResponse("Capri Sun", "R.drawable.kitkat_logo"),
            CompanyResponse("Capri Sun", "R.drawable.logo"),
            CompanyResponse("Capri Sun", "R.drawable.ic_home"),
            CompanyResponse("Capri Sun", "R.drawable.ic_person"),
            CompanyResponse("Capri Sun", "R.drawable.ic_shopping"),
            CompanyResponse("Capri Sun", " R.drawable.ic_person"),
            CompanyResponse("Capri Sun",  "R.drawable.ic_person"),
        )

    }
}

