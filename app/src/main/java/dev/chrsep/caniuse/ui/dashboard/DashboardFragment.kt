package dev.chrsep.caniuse.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatDialogFragment
import dev.chrsep.caniuse.databinding.FragmentDasboardBinding
import javax.inject.Inject

class DashboardFragment : DaggerAppCompatDialogFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //
    private val viewModel by viewModels<DashboardViewModel> { viewModelFactory }
    private lateinit var binding: FragmentDasboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDasboardBinding.inflate(layoutInflater)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it.eras.toString()
        })
        return binding.root
    }
}
