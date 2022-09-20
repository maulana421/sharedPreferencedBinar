package com.example.loginregissharedpreferense

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.loginregissharedpreferense.databinding.FragmentLoginBinding
import com.example.loginregissharedpreferense.databinding.FragmentRegistBinding


class RegistFragment : Fragment() {

    lateinit var binding : FragmentRegistBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("forSharePref", Context.MODE_PRIVATE)
        binding.btnRegister.setOnClickListener {
            val fullname = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val passwordPertama = binding.etPasswordfirst.text.toString().trim()
            val repeatPassword = binding.etpasswordSecond.text.toString().trim()

            if(fullname.isNotBlank() && username.isNotBlank() && passwordPertama.isNotBlank() && repeatPassword.isNotBlank()){
                if(passwordPertama.equals(repeatPassword)){
                    sharedPref.edit().apply{
                        putString("fullname",fullname)
                        putString("username",username)
                        putString("passwordPertama",passwordPertama)
                        putString("repeatPassword",repeatPassword)
                        apply()
                    }
                    Navigation.findNavController(binding.root).navigate(R.id.loginFragment)
                }else{
                    Toast.makeText(requireActivity(), " your password is different, please check again", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(requireActivity(), " data should not be empty ", Toast.LENGTH_SHORT).show()
            }
        }
    }


}