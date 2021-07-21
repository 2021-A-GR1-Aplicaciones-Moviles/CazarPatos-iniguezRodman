package com.iniguezrodman.cazarpatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        var jugadores = arrayListOf<Jugador>()
        jugadores.add(Jugador("Jugador1",10))
        jugadores.add(Jugador("Jugador2",9))
        jugadores.add(Jugador("Jugador3",8))
        jugadores.add(Jugador("Jugador4",7))

        val recyclerViewRanking: RecyclerView = findViewById(R.id.recyclerViewRanking);
        recyclerViewRanking.layoutManager = LinearLayoutManager(this);
        recyclerViewRanking.adapter = RankingAdapter(jugadores);
        recyclerViewRanking.setHasFixedSize(true);
    }
}