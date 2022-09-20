package com.example.loginregissharedpreferense

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.loginregissharedpreferense.databinding.FragmentHomeBinding
import com.example.loginregissharedpreferense.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    lateinit var binding : FragmentSplashBinding
    lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("forSharePref", Context.MODE_PRIVATE)
        var getUsername = sharedPref.getString("username", "")
        var getPassword = sharedPref.getString("password", "")

        Handler().postDelayed({
            if (getUsername == "" && getPassword == ""){
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment)
            } else{
                Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_homeFragment)
            }
        }, 3000)
    }


}