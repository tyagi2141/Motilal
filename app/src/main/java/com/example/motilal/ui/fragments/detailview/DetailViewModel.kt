package com.example.motilal.ui.fragments.detailview

import androidx.lifecycle.ViewModel
import com.example.motilal.AppApplication
import com.example.motilal.data.repo.DataRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Named

class DetailViewModel @Inject constructor(
    @Named("app") private var gson: Gson,
    private var dataRepository: DataRepository
) : ViewModel() {

    private val TAG = "DetailViewModel"


}
