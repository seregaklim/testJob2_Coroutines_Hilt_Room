package com.seregaklim.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.seregaklim.adapter.ResponseAdapter
import com.seregaklim.adapter.ResponseInteractionListener
import com.seregaklim.test_job2.databinding.FragmentResponseBinding
import com.seregaklim.viewmodel.ResponsePViewModel
import com.seregaklim.viewmodel.SignViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class FragmentResponse : Fragment() {
    private lateinit var binding: FragmentResponseBinding
    private val  responsePViewModel: ResponsePViewModel  by viewModels()
    private val signViewModel: SignViewModel by activityViewModels()
    private var token: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentResponseBinding.inflate(
            inflater,
            container,
            false
        )

      loadPayments()
        initAdapner()



        return binding.root
    }


    fun loadPayments() {
        token = signViewModel.tokenData.value.toString()
       // Log.d("MyLog", "fragToken ${token}")
        responsePViewModel.loadPayments(token)
    }



    fun initAdapner() {
        val adapter = ResponseAdapter(object : ResponseInteractionListener {


        })

        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())

        responsePViewModel.data.observe(viewLifecycleOwner
        ) { state ->
            adapter.submitList(state.responseX)
             //Log.d("MyLog", "state.responseX ${state.responseX}")
            if (state == null) {
                binding.emptyText.visibility = View.VISIBLE
            } else {
                binding.emptyText.visibility = View.GONE
            }
        }
    }

}