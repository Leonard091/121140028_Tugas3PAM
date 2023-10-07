package com.example.tugas1pamleonardo.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas1pamleonardo.R
import com.example.tugas1pamleonardo.Skills
import com.example.tugas1pamleonardo.SkillsAdapter
import com.example.tugas1pamleonardo.databinding.FragmentSkillsBinding
import java.util.Locale
import android.widget.SearchView
import com.example.tugas1pamleonardo.helper.ConstantUtil

class SkillsFragment : Fragment() {

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

        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvSkills.setHasFixedSize(true)
        binding.rvSkills.layoutManager = LinearLayoutManager(context)

        listSkills.addAll(ConstantUtil.getSkillData(this))

        val skillsAdapter = SkillsAdapter(listSkills)

        binding.searchSkills.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    val filteredList = ArrayList<Skills>()
                    for (i in listSkills) {
                        if (i.name?.lowercase(Locale.ROOT)?.contains(newText) == true
                            ||
                            i.desc?.lowercase(Locale.ROOT)?.contains(newText) == true) {
                            filteredList.add(i)
                        }
                    }

                    if (filteredList.isEmpty()) {
                        binding.rvSkills.visibility = View.INVISIBLE
                        binding.noResult.visibility = View.VISIBLE
                        Toast.makeText(requireActivity(), "Tidak ada hasil.", Toast.LENGTH_SHORT).show()
                    } else {
                        skillsAdapter.setFilteredList(filteredList)
                        binding.rvSkills.visibility = View.VISIBLE
                        binding.noResult.visibility = View.INVISIBLE
                    }
                }
                else{
                    binding.rvSkills.visibility = View.VISIBLE
                    binding.noResult.visibility = View.INVISIBLE
                }
                return true
            }

        })

        skillsAdapter.setOnClickCallBack(object: SkillsAdapter.onClickCallBack{

            override fun onItemClicked(data: Skills) {
                val bundle = bundleOf("extra_name" to data.name)
                findNavController().navigate(R.id.action_nav_skills_to_skillInfoFragment, bundle)
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