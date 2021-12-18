package com.example.motilal.ui.activitys.main

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.motilal.data.repo.DataRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Rahul on 16/12/21.
 */




class MainViewModel @Inject constructor(
    private var dataRepository: DataRepository,
    private var app: Application, @Named("app")
    private var gson: Gson
) :
    ViewModel() {

}
