package com.iniguezrodman.cazarpatos

import android.app.Activity
import android.content.Context

class SharedPreferencesManager (actividad: Activity): FileHandler{
    val sharedPref = actividad.getPreferences(Context.MODE_PRIVATE)
    override fun SaveInformation(datosAGrabar:List<Pair<String,String>>){
        val editor = sharedPref.edit()
        for ((clave, valor) in datosAGrabar) {
            editor.putString(clave,valor)
        }
        editor.apply()
    }
    override fun ReadInformation():Pair<String,String>{
        val email = sharedPref.getString(LOGIN_KEY,"").toString()
        val clave = sharedPref.getString(PASSWORD_KEY,"").toString()
        return (email to clave)
    }
}