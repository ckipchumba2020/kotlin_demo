package com.example.mynavdemo3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)

        val firstNameEditText = view.findViewById<EditText>(R.id.edit_first_name)
        val lastNameEditText = view.findViewById<EditText>(R.id.edit_last_name)

        val buttonSubmit = view.findViewById<Button>(R.id.button_submit)

        buttonSubmit.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()

            if(firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(context, "No First name or Last name provided.", Toast.LENGTH_LONG).show()
            } else {
                val action = ContactsFragmentDirections.actionContactsFragmentToDetailsFragment(firstName, lastName)
                findNavController().navigate(action)
            }
        }

        return view
    }
}