package com.example.btuclassroom.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.btuclassroom.R

class CoursesFragment: Fragment(R.layout.fragment_courses) {

    private lateinit var course: EditText
    private lateinit var point: EditText
    private lateinit var credit: EditText
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences("btu",AppCompatActivity.MODE_PRIVATE)
        val text = sharedPreferences.getString("btu","")

        init()
        textView.text = text

        button.setOnClickListener {
            var course = course.text.toString()
            var point = point.text.toString()
            var credit = credit.text.toString()
            var text = textView.text.toString()
            var result = course + ", " + point + ", " + credit + "\n" + text
            textView.text = result
            sharedPreferences.edit().putString("", result).apply()
        }

        button2.setOnClickListener {

            textView.text = ""

        }


    }

    private fun init(){

        course = requireView().findViewById(R.id.course)
        point = requireView().findViewById(R.id.point)
        credit = requireView().findViewById(R.id.credit)
        button = requireView().findViewById(R.id.button)
        button2 = requireView().findViewById(R.id.button2)
        textView = requireView().findViewById(R.id.textView2)
    }

}