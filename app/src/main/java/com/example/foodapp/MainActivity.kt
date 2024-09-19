package com.example.foodapp
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.foodapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : MainActivityBinding
    lateinit var  navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this,R.layout.main_activity)

        var fragmentHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHost
        navController = fragmentHost.navController

        setupWithNavController(binding.bottomNavBar, navController)

        binding.fabSendMassage.setOnClickListener{
             var intent =  Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "01112602464"));
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

    }
}
