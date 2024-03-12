package com.hw7.ui.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.hw7.R
import android.widget.SearchView
import com.hw7.databinding.FragmentMainBinding
import com.hw7.ui.adapter.UrunlerAdapter
import com.hw7.ui.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.toolbarMainFragment.title = "Ürünler"

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.urunlerList.observe(viewLifecycleOwner){
            val urunlerAdapter = UrunlerAdapter(requireContext(), it , viewModel)
            binding.rv.adapter = urunlerAdapter
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

        })


        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.add_transition)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.urunleriYukle()
    }


}