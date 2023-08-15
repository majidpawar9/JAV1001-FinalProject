package com.majid.cambrianapp


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.majid.cambrianapp.databinding.ActivityUserLoggedInBinding
import com.majid.cambrianapp.ui.logout.LogoutFragment
import org.w3c.dom.Text

class UserLoggedInActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityUserLoggedInBinding
    private lateinit var curruser: Text
    private lateinit var logoutFragment: LogoutFragment
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = ActivityUserLoggedInBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val user = auth.currentUser
        setSupportActionBar(binding.appBarUserLoggedIn.toolbar)

        binding.appBarUserLoggedIn.fab.setOnClickListener { view ->
            openEmailApp()
        }


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_user_logged_in)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_apply, R.id.nav_logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.user_logged_in, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_user_logged_in)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_logout -> {
                startActivity(Intent(this, SignUpActivity::class.java))
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            R.id.nav_home -> {
                startActivity(Intent(this, UserLoggedInActivity::class.java))
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            R.id.nav_apply -> {
                startActivity(Intent(this, UserLoggedInActivity::class.java))
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    private fun openEmailApp() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:") // Use "mailto:" scheme

        // Set email recipients (optional)
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("recipient@example.com"))

        // Set email subject (optional)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email")

        // Set initial text (optional)
        intent.putExtra(Intent.EXTRA_TEXT, "Initial text of the email")

        // Verify that there's an email app available to handle the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "You don't have email App",
                Toast.LENGTH_SHORT
            ).show()
            // Handle case where no email app is available
            // Show an error message or take alternative action
        }
    }

}