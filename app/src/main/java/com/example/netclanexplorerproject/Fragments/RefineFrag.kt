package com.example.netclanexplorerproject.Fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.get
import com.example.netclanexplorerproject.R
import com.example.netclanexplorerproject.databinding.ActivityMainBinding
import com.example.netclanexplorerproject.databinding.FragmentRefineBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RefineFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class RefineFrag : Fragment() {
    lateinit var binding: FragmentRefineBinding
    var checkedId: Int = 0
    var option = arrayOf(
        "Available | Hay Let Us Connect", "Away | Stay Discreet And Watch",
        "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRefineBinding.inflate(layoutInflater, container, false)
        spinner()
        chipGroup()

        return binding.root
    }

    private fun chipGroup() {
        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->

            if (checkedIds.count() == 1) {
                Log.d("TAG", "Count 1")
                checkedId = checkedIds[0]
                when (checkedId) {
                    R.id.chip1 -> {
                        binding.chip1.isCheckable = false
                    }
                    R.id.chip2 -> {
                        binding.chip2.isCheckable = false
                    }
                    R.id.chip3 -> {
                        binding.chip3.isCheckable = false
                    }
                    R.id.chip4 -> {
                        binding.chip4.isCheckable = false
                    }
                    R.id.chip5 -> {
                        binding.chip5.isCheckable = false
                    }
                    R.id.chip6 -> {
                        binding.chip6.isCheckable = false
                    }
                    R.id.chip7 -> {
                        binding.chip7.isCheckable = false
                    }
                    R.id.chip8 -> {
                        binding.chip8.isCheckable = false
                    }

                }
            } else {
                Log.d("TAG", "Count 2")
                when (checkedId) {
                    R.id.chip1 -> {
                        binding.chip1.isCheckable = true
                    }
                    R.id.chip2 -> {
                        binding.chip2.isCheckable = true
                    }
                    R.id.chip3 -> {
                        binding.chip3.isCheckable = true
                    }
                    R.id.chip4 -> {
                        binding.chip4.isCheckable = true
                    }
                    R.id.chip5 -> {
                        binding.chip5.isCheckable = true
                    }
                    R.id.chip6 -> {
                        binding.chip6.isCheckable = true
                    }
                    R.id.chip7 -> {
                        binding.chip7.isCheckable = true
                    }
                    R.id.chip8 -> {
                        binding.chip8.isCheckable = true
                    }
                }
            }
        }
    }

    private fun spinner() {

        val adapterCat: ArrayAdapter<String> =
            ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_dropdown_item_1line,
                option
            )
        with(binding.availabilitySpinner) {
            adapter = adapterCat
            onItemSelectedListener
            gravity = Gravity.CENTER
        }
    }


}