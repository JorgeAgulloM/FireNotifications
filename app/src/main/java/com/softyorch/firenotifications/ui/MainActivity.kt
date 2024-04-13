package com.softyorch.firenotifications.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import com.softyorch.firenotifications.R
import com.softyorch.firenotifications.data.TopicManager.Companion.BASKETBALL_TOPIC
import com.softyorch.firenotifications.data.TopicManager.Companion.FOOTBALL_TOPIC
import com.softyorch.firenotifications.data.TopicManager.Companion.PETANCA_TOPIC
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


        initUI()
        //throw RuntimeException("Yorch Fail")

    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        findViewById<Button>(R.id.btnFootball).setOnClickListener {
            viewModel.subscribeToTopic(FOOTBALL_TOPIC)
        }
        findViewById<Button>(R.id.btnBasketball).setOnClickListener {
            viewModel.subscribeToTopic(BASKETBALL_TOPIC)
        }
        findViewById<Button>(R.id.btnPetanca).setOnClickListener {
            viewModel.subscribeToTopic(PETANCA_TOPIC)
        }
    }
}