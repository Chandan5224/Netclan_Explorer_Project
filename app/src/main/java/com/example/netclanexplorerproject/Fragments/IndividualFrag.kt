package com.example.netclanexplorerproject.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.netclanexplorerproject.R
import com.example.netclanexplorerproject.databinding.FragmentIndividualBinding
import com.example.netclanexplorerproject.databinding.FragmentRefineBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IndividualFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class IndividualFrag : Fragment() {

    lateinit var binding: FragmentIndividualBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentIndividualBinding.inflate(layoutInflater, container, false)


        return binding.root
    }



}