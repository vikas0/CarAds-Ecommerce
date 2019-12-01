package com.vikaspandey.carbazar.ui.adDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vikaspandey.carbazar.R
import com.vikaspandey.carbazar.databinding.AdItemDetailFragmentBinding
import com.vikaspandey.carbazar.di.Injectable
import javax.inject.Inject

class AdItemDetailFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AdDetailViewModel
    private lateinit var binding: AdItemDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.ad_item_detail_fragment,
            container, false
        )
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(AdDetailViewModel::class.java)
        binding.car = viewModel.liveDataadItem
        val params = DeliveryDetailFragmentArgs.fromBundle(arguments!!)
        viewModel.setadItemId(params.deliveryItemId)

    }
}



