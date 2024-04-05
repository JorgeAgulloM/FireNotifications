package com.softyorch.firenotifications.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.softyorch.firenotifications.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.onLoginSelectedExample()
        viewModel.customEvent()

        val extras = intent.extras
        if (extras != null) {
            val test = extras.getString("test")
            Log.i("LOGTAG", "Para la clave test el valor es $test")

            val example1 = extras.getString("example1")
            Log.i("LOGTAG", "Para la clave example1 el valor es $example1")

        }

        //throw RuntimeException("Yorch Fail")

    }
}