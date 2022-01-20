package com.example.btuclassroom.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.btuclassroom.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private lateinit var image: ImageView
    private lateinit var photoLink: EditText
    private lateinit var name: EditText
    private lateinit var id: EditText
    private lateinit var mail: EditText
    private lateinit var number: EditText
    private lateinit var address: EditText
    private lateinit var education: EditText
    private lateinit var work: EditText
    private lateinit var saveInfo: Button

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        profile()
        saveInfo()

        db.child(auth.currentUser?.uid!!).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(com.example.btuclassroom.UserInfo::class.java) ?: return
                Glide.with(this@ProfileFragment).load(userInfo.photo).placeholder(R.drawable.ic_baseline_person_24).into(image)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun init(){
        image = requireView().findViewById(R.id.imageView)
        photoLink = requireView().findViewById(R.id.photoLink)
        name = requireView().findViewById(R.id.name)
        id = requireView().findViewById(R.id.idNum)
        mail = requireView().findViewById(R.id.email)
        number = requireView().findViewById(R.id.phoneNumb)
        address = requireView().findViewById(R.id.address)
        education = requireView().findViewById(R.id.course)
        work = requireView().findViewById(R.id.work)
        saveInfo = requireActivity().findViewById(R.id.buttonSave)
    }

    private fun profile(){

        val idNumber = id.text.toString()
        val email = mail.text.toString()
        val mobNum = number.text.toString()

        if (!email.contains("@btu.edu.ge")) {
            mail.error = "შეიყვანეთ მეილი სწორად"
        }
        if(idNumber.isEmpty() || (idNumber.length != 12 ) || (!idNumber.contains(Regex("[0-9]")))){
            id.error = "პირადი ნომერი არ რეგისტრირდება"
        }
        if(mobNum.isEmpty() || (mobNum.length != 12) || (mobNum.contains(Regex("[0-9]")))){
            number.error = "შეიყვანეთ ნომერი სწორად"
        }

    }
    private fun saveInfo(){

        saveInfo.setOnClickListener(){
            val name = name.text.toString()
            val id = id.text.toString()
            val mail = mail.text.toString()
            val number = number.text.toString()
            val address = address.text.toString()
            val education = education.text.toString()
            val work = work.text.toString()
            val userInfo = com.example.btuclassroom.UserInfo(name, id, mail, number, address, education, work)
            db.child(auth.currentUser?.uid!!).setValue(userInfo)
        }


    }

}