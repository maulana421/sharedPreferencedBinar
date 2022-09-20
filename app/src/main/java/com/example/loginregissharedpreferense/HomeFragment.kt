package com.example.loginregissharedpreferense

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.loginregissharedpreferense.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var sharedPref : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("forSharePref", Context.MODE_PRIVATE)

        val result = """
            ${sharedPref.getString("fullname","wrong")}
        """.trimIndent()

        binding.tvResult.text = result
    }

    private fun toLogout(){
        binding.btnLogout.setOnClickListener {
            sharedPref.edit().apply {
                clear()
                apply()
            }
            Navigation.findNavController(binding.root).navigate(R.id.loginFragment)
        }
    }


}