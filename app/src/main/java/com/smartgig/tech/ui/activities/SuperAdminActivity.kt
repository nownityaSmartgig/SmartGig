package com.smartgig.tech.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivitySuperAdminBinding
import com.smartgig.tech.ui.fragment.AddEmployeeDocumentFragment

class SuperAdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperAdminBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuperAdminBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

//        val addEmployeeFragment = AddEmployeeDocumentFragment()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, addEmployeeFragment)
//            .commit()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        navController.navigate(R.id.addEmployeeDocumentFragment)
    }
}