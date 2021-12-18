package com.example.motilal.ui.fragments.dashboard

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import com.example.motilal.AppApplication
import com.example.motilal.data.works.SyncWorker
import com.example.motilal.databinding.FragmentFirstBinding
import com.example.motilal.model.DashboardResponse
import com.example.motilal.ui.fragments.dashboard.adapter.DashboardAdapter
import com.example.motilal.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class DashboardFragment : DaggerFragment(), DashboardAdapter.DbAdapterCallback {



    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var viewModel: DashboardViewModel

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: DashboardAdapter

    var jobScheduler: JobScheduler? = null

    private  val TAG = "DashboardFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jobScheduler = requireActivity().getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler?;
        viewModel = ViewModelProvider(this, providerFactory)[DashboardViewModel::class.java]
        viewModel.getData(requireContext())
        binding.progressBar.visibility = View.VISIBLE

        startWork()
        viewModel.loadingDataLiveData.observe(viewLifecycleOwner, {
            if (!it) {
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }
        })

        viewModel.dashboardResponseLiveData.observe(viewLifecycleOwner, {

            if (it.success) {
                it.responseData?.let { it1 -> initRecyclerView(it1.list) }
            } else {
                Toast.makeText(requireContext(), "${it.error?.ErrorCause}", Toast.LENGTH_LONG).show()
            }
        })
    }


    private fun initRecyclerView(listData: List<DashboardResponse>) {
        adapter = DashboardAdapter(requireContext())
        adapter.adapterCallback = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.differ.submitList(listData)
    }


    fun startWork(){

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED).build()

        val periodicWorkRequest = PeriodicWorkRequest.Builder(
            SyncWorker::class.java, 15, TimeUnit.MINUTES
        ).setConstraints(constraints).build()


        val workManager = WorkManager.getInstance(requireActivity().applicationContext)
        workManager.enqueueUniquePeriodicWork(
            SyncWorker.TAG,
            ExistingPeriodicWorkPolicy.KEEP,
            periodicWorkRequest

        )

        workManager.getWorkInfoByIdLiveData(periodicWorkRequest.id).observeForever {
            if (it != null) {

                Log.d("periodicWorkRequest", "Status changed to ${it.state}")

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTab(dashboardData: DashboardResponse?) {

        val nav_action =
            dashboardData?.let {
                DashboardFragmentDirections.actionFirstFragmentToSecondFragment(
                    it
                )
            }
        if (nav_action != null) {
            Navigation.findNavController(requireView()).navigate(nav_action)
        }

    }
}