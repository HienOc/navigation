package com.adnet.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        Navigation.findNavController(this, R.id.fragmentContainerView)?.let { navigation ->
            NavigationUI.setupWithNavController(bottomNavigationView, navigation)
        }
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }
    @Subscribe
     fun eventBus(event: String) {
        if(event=="Next"){
            bottomNavigationView.visibility=View.GONE
        }
        if(event=="Back"){
            bottomNavigationView.visibility=View.VISIBLE
        }
    }
}
