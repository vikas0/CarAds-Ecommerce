package com.vikaspandey.carbazar.ui.adList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.vikaspandey.carbazar.databinding.AdListFragmentBinding
import com.vikaspandey.carbazar.db.Car
import com.vikaspandey.carbazar.di.Injectable
import javax.inject.Inject



class AdListFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AdListViewModel

    private lateinit var adapter: AdListAdapter
    private lateinit var binding:AdListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding= AdListFragmentBinding.inflate(layoutInflater, container, false)

binding.setLifecycleOwner { lifecycle }
      adapter = activity?.let { AdListAdapter(it,
          ItemClickListner { itemId -> viewModel.onAdItemClicked(itemId)})


      }!!

        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.list.addItemDecoration(decoration)
        binding.list.adapter = adapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       viewModel = ViewModelProviders.of(this,viewModelFactory).get(AdListViewModel::class.java)

      viewModel.cars.observe(viewLifecycleOwner, Observer<List<Car>> {

if(it==null || it.size==0)
    viewModel.addDummyAds()
                adapter.submitList(it)

        }
        )

        viewModel.navigateToAdDetail.observe(this, Observer { adItemID ->
            adItemID?.let {

                this.findNavController().navigate(
                    CarListFragmentDirections.showDeliveryDetail(adItemID))
                // Reset state to make sure we only navigate once, even if the device
                // has a configuration change.
                viewModel.onAdDetailNavigated()
            }
        })
    }

    private fun showToast(s: String) = Toast.makeText(activity, s, Toast.LENGTH_LONG).show()



}
