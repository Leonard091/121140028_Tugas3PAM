package com.example.tugas1pamleonardo.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas1pamleonardo.ui.skill_info.SkillInfoFragment
import com.example.tugas1pamleonardo.R
import com.example.tugas1pamleonardo.Skills
import com.example.tugas1pamleonardo.SkillsAdapter
import com.example.tugas1pamleonardo.databinding.FragmentSkillsBinding

class SkillsFragment : Fragment() {
    companion object{
        var EXTRA_VALUE = "extra_value"
    }
    private val listSkills = ArrayList<Skills>()

    private var _binding: FragmentSkillsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val skillsViewModel =
            ViewModelProvider(this).get(SkillsViewModel::class.java)

//        bindingSkills =
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvSkills.setHasFixedSize(true)
        binding.rvSkills.layoutManager = LinearLayoutManager(context)

        listSkills.add(Skills("Kotlin", "I'm still learning....."))
        listSkills.add(Skills("HTML", "I have created several websites such as biography, web Prodi, etc.."))
        listSkills.add(Skills("CSS", "I have created several websites such as biography, web Prodi, etc.."))
        listSkills.add(Skills("Python", "I once worked on a 2d video game project with 2 of my friends."))
        listSkills.add(Skills("C++", "I have learnt it since grade 2 of senior high school as the beginning of learning programming."))

        val skillsAdapter = SkillsAdapter(listSkills)


        skillsAdapter.setOnClickCallBack(object: SkillsAdapter.onClickCallBack{
            val skillInfo = SkillInfoFragment()
            val bundle = Bundle()

            override fun onItemClicked(data: Skills) {
//                Toast.makeText(requireActivity(), "Bahasa: " + data.name, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_nav_skills_to_skillInfoFragment)
            }
        })
        binding.rvSkills.adapter = skillsAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}