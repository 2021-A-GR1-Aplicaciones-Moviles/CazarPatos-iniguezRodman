package com.iniguezrodman.cazarpatos

import android.app.Activity
import android.content.Context

class FileInternalManager(val actividad: Activity) {
    fun SaveInformation(datosAGrabar:List<Pair<String,String>>){
        //val texto = "texto" + System.lineSeparator() + "almacenado"
        actividad.openFileOutput("fichero.txt", Context.MODE_PRIVATE).bufferedWriter().use { fos ->
            for ((clave, valor) in datosAGrabar) {
                fos.write("$clave-$valor")
            }
        }
    }
}