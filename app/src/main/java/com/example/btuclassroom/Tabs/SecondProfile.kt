package com.example.btuclassroom.Tabs

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.btuclassroom.R


class SecondProfile: Fragment(R.layout.profile_second) {

    private lateinit var EditAddress: EditText
    private lateinit var EditCourse: EditText
    private lateinit var EditWork: EditText
    private lateinit var EditPhNum: EditText
    private lateinit var address: TextView
    private lateinit var course: TextView
    private lateinit var work: TextView
    private lateinit var phoneNumb: TextView
    private lateinit var button3: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        saveInfo()


    }

    private fun init(){

        EditAddress = requireView().findViewById(R.id.EditAddress)
        EditWork = requireView().findViewById(R.id.EditWork)
        EditCourse = requireView().findViewById(R.id.EditCourse)
        EditPhNum = requireView().findViewById(R.id.EditPhNum)
        phoneNumb = requireView().findViewById(R.id.phoneNumb)
        address = requireView().findViewById(R.id.address)
        course = requireView().findViewById(R.id.course)
        work = requireView().findViewById(R.id.work)
        button3 = requireView().findViewById(R.id.button3)
    }

    private fun saveInfo(){

        val sharedPreferances = requireActivity()
            .getSharedPreferences("pref", Context.MODE_PRIVATE)

        button3.setOnClickListener(){
            var EditAddress = EditAddress.text.toString()
            var EditWork = EditWork.text.toString()
            var EditCourse = EditCourse.text.toString()
            var EditPhNum = EditPhNum.text.toString()
            var phoneNumb1 =  phoneNumb.text.toString()
            var address1 = address.text.toString()
            var course1 = course.text.toString()
            var work1 = work.text.toString()


            var result1 = EditAddress + address1
            address.text = result1

            var result2 = EditCourse + course1
            course.text = result2

            var result3 = EditWork + work1
            work.text = result3

            var result4 = EditPhNum + phoneNumb1
            phoneNumb.text = result3

            sharedPreferances.edit().putString("", result1).apply()
            sharedPreferances.edit().putString("", result2).apply()
            sharedPreferances.edit().putString("", result3).apply()
            sharedPreferances.edit().putString("", result4).apply()


        }


    }
}