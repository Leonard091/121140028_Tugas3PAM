package com.example.tugas1pamleonardo.ui.skill_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tugas1pamleonardo.databinding.FragmentSkillInfoBinding

class SkillInfoFragment : Fragment() {
    private lateinit var binding: FragmentSkillInfoBinding
    companion object{
        var EXTRA_NAME = "extra_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillInfoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments!=null){
            val name = arguments?.getString(EXTRA_NAME)
            binding.textSkillInfo.text = "tes123 $name"
        }
    }

}