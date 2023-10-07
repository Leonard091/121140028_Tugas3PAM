package com.example.tugas1pamleonardo.helper

import androidx.fragment.app.Fragment
import com.example.tugas1pamleonardo.R
import com.example.tugas1pamleonardo.Skills

object ConstantUtil {
    fun getSkillData(fragment: Fragment): ArrayList<Skills>{
        val skillList = ArrayList<Skills>()
        val skills = fragment.resources.getStringArray(R.array.name_skills_array)
        val images = fragment.resources.getStringArray(R.array.desc_skills_array)
        for (i in skills.indices){
            skillList.add(Skills(skills[i], images[i]))
        }
        return skillList

    }
}