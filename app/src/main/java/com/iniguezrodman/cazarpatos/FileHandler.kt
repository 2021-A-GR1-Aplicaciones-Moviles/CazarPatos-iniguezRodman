package com.iniguezrodman.cazarpatos

interface FileHandler {
    fun SaveInformation(datosAGrabar:List<Pair<String,String>>)
    fun ReadInformation():Pair<String,String>
}