package com.example.motilal.ui.fragments.dashboard

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.motilal.data.repo.DataRepository
import com.example.motilal.model.DashboardResponse
import com.example.motilal.ui.base.BaseViewModel
import com.example.motilal.util.CommonResponseModel
import com.example.motilal.util.NetworkUtils
import javax.inject.Inject


class DashboardViewModel @Inject constructor(
    private var dataRepository: DataRepository
) : BaseViewModel() {

    private val TAG = "DashboardViewModel"

    val dashboardResponseLiveData: MutableLiveData<CommonResponseModel<DashboardResponse>> =
        MutableLiveData()

    fun getData(context: Context) {
        if (NetworkUtils.isNetworkAvailable(context)) {
            dashboardFromServer()
        } else {
            dashboardFromDatabase()
        }
    }


    private fun dashboardFromServer() {

        bag.add(dataRepository.getData()
            .map {
                Log.e("jhbhjbhjb", "$it")
                it.let {
                    dataRepository.insertAllDashboard(it.result ?: emptyList()).blockingAwait()
                }

                it
            }.subscribe({
                Log.d(TAG, "ResultFromServer-success:$it")
                dashboardResponseLiveData.postValue(
                    CommonResponseModel(
                        it,
                        null,
                        200,
                        true
                    )
                )
                loadingDataLiveData.postValue(false)
            }, {
                Log.d("$TAG : $it", "ResultFromServer-error")
                dashboardResponseLiveData.postValue(
                    CommonResponseModel(
                        null,
                        CommonResponseModel.Error(it.localizedMessage, it.message)
                    )
                )
                loadingDataLiveData.postValue(false)
            })
        )
    }


    fun dashboardFromDatabase() {
        bag.add(
            dataRepository.getAllDashBoard()
                .subscribe({
                    Log.d(TAG, "ResultFromDatabase-success:$it")
                    dashboardResponseLiveData.postValue(
                        CommonResponseModel(
                            DashboardResponse(it),
                            null,
                            200,
                            true
                        )
                    )
                    loadingDataLiveData.postValue(false)
                }, {
                    dashboardResponseLiveData.postValue(
                        CommonResponseModel(
                            null,
                            CommonResponseModel.Error(it.localizedMessage, it.message)
                        )
                    )
                    loadingDataLiveData.postValue(false)
                })
        )
    }
}
