package com.example.o1

import android.content.ContentValues.TAG
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var flash: ImageView
    private var isactive: Boolean = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flash = findViewById(R.id.flash)
 
        lightState(isactive)
        

        flash.setOnClickListener {

            if (isactive==false) {
                flash.setImageResource(R.drawable.ic_baseline_highlight_24)

                isactive = true

                lightState(isactive)
            }

            else{

                flash.setImageResource(R.drawable.ic_outline_highlight_24)
                isactive=false
                lightState(isactive)

            }


        }




    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun lightState(isactive: Boolean) {

        val cameraManager:CameraManager=getSystemService(CAMERA_SERVICE) as CameraManager

        var cameraid : String?=null

        try {

            cameraid = cameraManager.cameraIdList[0]

            cameraManager.setTorchMode(cameraid, isactive)

        }

        catch (e:java.lang.Exception)
        {
            Log.d(TAG, "lightState: not doinf")
        }




    }
}