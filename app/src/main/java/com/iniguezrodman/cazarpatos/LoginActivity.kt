package com.iniguezrodman.cazarpatos

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonLogin: Button
    lateinit var buttonNewUser:Button
    lateinit var mediaPlayer: MediaPlayer
    lateinit var checkBoxRecordarme: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        //Inicialización de variables
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonNewUser = findViewById(R.id.buttonNewUser)
        checkBoxRecordarme = findViewById(R.id.checkBoxRecordarme)
        editTextEmail.setText ( sharedPref.getString(LOGIN_KEY,"") )
        editTextPassword.setText ( sharedPref.getString(PASSWORD_KEY,"") )

        //Eventos clic
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val clave = editTextPassword.text.toString()
            //Validaciones de datos requeridos y formatos
            if(!ValidarDatosRequeridos())
                return@setOnClickListener
            //Si pasa validación de datos requeridos, ir a pantalla principal
            if(checkBoxRecordarme.isChecked){
                val editor = sharedPref.edit()
                editor.putString(LOGIN_KEY,editTextEmail.text.toString())
                editor.putString(PASSWORD_KEY,editTextPassword.text.toString())
                editor.commit()
            }
            else{
                val editor = sharedPref.edit()
                editor.putString(LOGIN_KEY,"")
                editor.putString(PASSWORD_KEY,"")
                editor.commit()
            }
            val intencion = Intent(this, MainActivity::class.java)
            intencion.putExtra(EXTRA_LOGIN, email)
            startActivity(intencion)
        }
        buttonNewUser.setOnClickListener{

        }
        mediaPlayer=MediaPlayer.create(this, R.raw.title_screen)
        mediaPlayer.start()
    }
    private fun ActivarRecuerdame():Boolean{
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        if(sharedPref.getString(LOGIN_KEY,"") != null&& sharedPref.getString(PASSWORD_KEY,"")!=null) {
            return true
        }
        return false}

    private fun ValidarDatosRequeridos():Boolean{
        val email = editTextEmail.text.toString()
        val clave = editTextPassword.text.toString()
        if (email.isEmpty()) {
            editTextEmail.setError("El email es obligatorio")
            editTextEmail.requestFocus()
            return false
        }
        if (clave.isEmpty()) {
            editTextPassword.setError("La clave es obligatoria")
            editTextPassword.requestFocus()
            return false
        }
        if (clave.length < 3) {
            editTextPassword.setError("La clave debe tener al menos 3 caracteres")
            editTextPassword.requestFocus()
            return false
        }
        return true
    }
    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }
}

