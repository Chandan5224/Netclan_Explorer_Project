package com.example.netclanexplorerproject.Fragments

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.netclanexplorerproject.Adapter.VPAdapter
import com.example.netclanexplorerproject.R
import com.example.netclanexplorerproject.databinding.FragmentExploreBinding
import com.google.android.material.tabs.TabLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFrag.newInstance] factory method to
 * create an instance of this fragment.
 */

class ExploreFrag : Fragment() {

    lateinit var binding: FragmentExploreBinding
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_close_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.to_bottom_anim
        )
    }
    private var clicked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExploreBinding.inflate(layoutInflater, container, false)

        setupViewPager()
        binding.viewpager.setDisableSwipe(false)
        binding.floatingActionButton.setOnClickListener {
            onAddButtonClicked()
        }
        binding.view.setOnClickListener {
            onAddButtonClicked()
        }
        binding.matrimonyBtn.setOnClickListener {
            Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.datingBtn.setOnClickListener {
            Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.buyBtn.setOnClickListener {
            Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
        }
        binding.cardBtn.setOnClickListener {
            Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.floatingActionButton.startAnimation(rotateOpen)
            binding.buyBtn.startAnimation(fromBottom)
            binding.cardBtn.startAnimation(fromBottom)
            binding.datingBtn.startAnimation(fromBottom)
            binding.jobBtn.startAnimation(fromBottom)
            binding.hastagBtn.startAnimation(fromBottom)
            binding.matrimonyBtn.startAnimation(fromBottom)
            binding.noteBtn.startAnimation(fromBottom)
        } else {
            binding.floatingActionButton.startAnimation(rotateClose)
            binding.buyBtn.startAnimation(toBottom)
            binding.cardBtn.startAnimation(toBottom)
            binding.datingBtn.startAnimation(toBottom)
            binding.jobBtn.startAnimation(toBottom)
            binding.hastagBtn.startAnimation(toBottom)
            binding.matrimonyBtn.startAnimation(toBottom)
            binding.noteBtn.startAnimation(toBottom)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.buyBtn.visibility = View.VISIBLE
            binding.cardBtn.visibility = View.VISIBLE
            binding.datingBtn.visibility = View.VISIBLE
            binding.jobBtn.visibility = View.VISIBLE
            binding.hastagBtn.visibility = View.VISIBLE
            binding.matrimonyBtn.visibility = View.VISIBLE
            binding.noteBtn.visibility = View.VISIBLE
            binding.textView8.visibility = View.VISIBLE
            binding.textView9.visibility = View.VISIBLE
            binding.textView10.visibility = View.VISIBLE
            binding.textView11.visibility = View.VISIBLE
            binding.textView12.visibility = View.VISIBLE
            binding.textView13.visibility = View.VISIBLE
            binding.textView14.visibility = View.VISIBLE
            binding.view.visibility=View.VISIBLE
        } else {
            binding.buyBtn.visibility = View.GONE
            binding.cardBtn.visibility = View.GONE
            binding.datingBtn.visibility = View.GONE
            binding.jobBtn.visibility = View.GONE
            binding.hastagBtn.visibility = View.GONE
            binding.matrimonyBtn.visibility = View.GONE
            binding.noteBtn.visibility = View.GONE
            binding.textView8.visibility = View.GONE
            binding.textView9.visibility = View.GONE
            binding.textView10.visibility = View.GONE
            binding.textView11.visibility = View.GONE
            binding.textView12.visibility = View.GONE
            binding.textView13.visibility = View.GONE
            binding.textView14.visibility = View.GONE
            binding.view.visibility=View.GONE
        }
    }

    private fun setupViewPager() {
        binding.tabLayout.setupWithViewPager(binding.viewpager)
        val vpAdapter = VPAdapter(requireActivity().supportFragmentManager)
        vpAdapter.apply {
            add(IndividualFrag(), "")
            add(ProfessionalFrag(), "")
            add(MerchantFrag(), "")
        }

        binding.viewpager.adapter = vpAdapter
        binding.tabLayout.getTabAt(0)!!.setIcon(R.drawable.people).tag = "individual"
        binding.tabLayout.getTabAt(1)!!.setIcon(R.drawable.suitcase).tag = "professional"
        binding.tabLayout.getTabAt(2)!!.setIcon(R.drawable.merchant).tag = "merchant"
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        binding.tabLayout.getTabAt(0)!!.icon!!.setColorFilter(
            resources.getColor(R.color.white), PorterDuff.Mode.SRC_IN
        )
        binding.tabLayout.getTabAt(1)!!.icon!!.setColorFilter(
            resources.getColor(R.color.tab_unselected), PorterDuff.Mode.SRC_IN
        )
        binding.tabLayout.getTabAt(2)!!.icon!!.setColorFilter(
            resources.getColor(R.color.tab_unselected), PorterDuff.Mode.SRC_IN
        )

        binding.tabLayout.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(binding.root.context, R.color.white)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabIconColor =
                    ContextCompat.getColor(binding.root.context, R.color.tab_unselected)
                tab!!.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

}