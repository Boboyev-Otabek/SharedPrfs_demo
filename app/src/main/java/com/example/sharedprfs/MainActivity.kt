package com.example.sharedprfs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprfs.managers.PrefsManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {

        var fullname = findViewById<EditText>(R.id.et_fuulname)
        var email = findViewById<EditText>(R.id.et_email)
        var psw = findViewById<EditText>(R.id.et_password)
        var cpsw = findViewById<EditText>(R.id.et_cpassword)

        var b_save = findViewById<Button>(R.id.b_save)

        b_save.setOnClickListener {
            PrefsManager.getInstance(this).savedata("Full Name", fullname.text.toString().trim())
            PrefsManager.getInstance(this).savedata("Email", email.text.toString().trim())
            PrefsManager.getInstance(this).savedata("Password", psw.text.toString().trim())
            PrefsManager.getInstance(this).savedata("Confirm password", cpsw.text.toString().trim())
            Toast.makeText(this, "Save data", Toast.LENGTH_SHORT).show()


        }


    }
}