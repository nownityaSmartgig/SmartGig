package com.smartgig.tech.ui.activities.super_admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.smartgig.tech.R
import com.smartgig.tech.databinding.ActivitySuperAdminBinding

class SuperAdminActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySuperAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window , false)
        super.onCreate(savedInstanceState)

        binding = ActivitySuperAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
//        binding.toolbar.addView()

        val navController = findNavController(R.id.nav_host_fragment_content_super_admin)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController , appBarConfiguration)

//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view , "Replace with your own action" , Snackbar.LENGTH_LONG)
//                .setAnchorView(R.id.fab)
//                .setAction("Action" , null).show()
//        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_super_admin)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}