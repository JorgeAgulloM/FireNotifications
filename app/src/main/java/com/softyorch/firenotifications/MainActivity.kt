package com.softyorch.firenotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extras = intent.extras
        if (extras != null) {
            val test = extras.getString("test")
            Log.i("LOGTAG", "Para la clave test el valor es $test")

            val example1 = extras.getString("example1")
            Log.i("LOGTAG", "Para la clave example1 el valor es $example1")

        }

    }
}