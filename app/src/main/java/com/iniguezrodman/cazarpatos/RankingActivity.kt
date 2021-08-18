package com.iniguezrodman.cazarpatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        consultarPuntajeJugadores()
    }

    fun consultarPuntajeJugadores() {
        val db = Firebase.firestore
        db.collection("usuarios")
            .orderBy("patosCazados", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { result ->
                var jugadores = ArrayList<Jugador>()
                for (document in result) {
                    //val jugador = document.toObject(Jugador::class.java)
                    val jugador = document.toObject<Jugador>()
                    jugadores.add(jugador)
                }
                //Poblar en RecyclerView información usando mi adaptador
                val recyclerViewRanking: RecyclerView = findViewById(R.id.recyclerViewRanking);
                recyclerViewRanking.layoutManager = LinearLayoutManager(this);
                recyclerViewRanking.adapter = RankingAdapter(jugadores);
                recyclerViewRanking.setHasFixedSize(true);
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error al obtener datos de jugadores:-> {$e.message}", Toast.LENGTH_LONG).show()
            }
    }
}

