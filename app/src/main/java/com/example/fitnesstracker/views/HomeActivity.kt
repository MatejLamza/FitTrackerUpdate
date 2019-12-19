package com.example.fitnesstracker.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.fitnesstracker.R
import com.example.fitnesstracker.factories.HomeActivityVMFactory
import com.example.fitnesstracker.viewmodels.HomeActivityViewModel
import com.example.fitnesstracker.views.Fragments.ClientsFragment
import com.example.fitnesstracker.views.adapters.MenuAdapter
import com.example.fitnesstracker.views.Fragments.HomeFragment
import com.example.fitnesstracker.views.Fragments.ScheduleFragment
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.footer.*
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), DuoMenuView.OnMenuClickListener {

    @Inject
    lateinit var vmFactory: HomeActivityVMFactory

    private lateinit var homeVM: HomeActivityViewModel
    private lateinit var drawerLayout: DuoDrawerLayout
    private lateinit var menuView: DuoMenuView

    private var menuAdapter = MenuAdapter()
    private var options: List<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeVM = ViewModelProviders.of(this, vmFactory).get(HomeActivityViewModel::class.java)

        //Fetching names of menu items and converting it to list
        options = resources.getStringArray(R.array.menuOptions).toList()

        drawerLayout = findViewById(R.id.drawer)
        menuView = drawerLayout.menuView as DuoMenuView


        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        initMenu()
        handleDrawer()

        val frag = HomeFragment()
        goToFragment(frag, false)

        setTitle(options[0])

        btn_log_off.setOnClickListener {
            Toast.makeText(this, "Logging off", Toast.LENGTH_SHORT).show()
            homeVM.googleSignOut()
            backToLoginActivity()
        }
    }

    override fun onOptionClicked(position: Int, objectClicked: Any?) {
        setTitle(options[position])

        when (position) {
            1 ->{
                Toast.makeText(this, options[position], Toast.LENGTH_LONG).show()
                goToFragment(ClientsFragment(),true)
            }
            2 ->{
                Toast.makeText(this, options[position], Toast.LENGTH_LONG).show()
                goToFragment(ScheduleFragment(),false)
            }
            3 -> Toast.makeText(this, options[position], Toast.LENGTH_LONG).show()
            4 -> Toast.makeText(this, options[position], Toast.LENGTH_LONG).show()
            5 -> Toast.makeText(this, options[position], Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer()
    }

    override fun onHeaderClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFooterClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initMenu() {
        menuAdapter.setOptions(options as ArrayList<String>)
        menuView.setOnMenuClickListener(this)
        menuView.adapter = menuAdapter
    }

    private fun handleDrawer() {
        val drawerToggle =
            DuoDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.ClosedDrawer)
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun backToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goToFragment(fragment: Fragment, addToStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToStack) {
            transaction.addToBackStack(null)
        }
        transaction.add(R.id.main_container, fragment).commit()
    }
}