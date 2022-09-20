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


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("forSharePref", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            var getUsername = sharedPref.getString("username", "wrong")
            var getPassword = sharedPref.getString("password", "wrong")
            if (getUsername == "wrong" && getPassword == "wrong"){
                Toast.makeText(context, "Anda Belum melakukan Registrasi, Silahkan lalukan Registrasi", Toast.LENGTH_SHORT).show()
            } else{
                val username = binding.etUsername.text.toString()
                val password = binding.etPassword.text.toString()
                var tambahUser = sharedPref.edit()
                tambahUser.putString("username", username)
                tambahUser.putString("password", password)
                tambahUser.apply()
                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)

            }
        }
        binding.btnRegister.setOnClickListener {
            toRegist()
        }
    }



    private fun toRegist(){
        Navigation.findNavController(binding.root).navigate(R.id.registFragment)
    }




}