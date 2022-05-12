package banuelos.hector.apipsyconauts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val psyPowers = arrayListOf<psyconauts>()
        val recyclerPsy = findViewById<RecyclerView>(R.id.Psyconauts)

        val queue = Volley.newRequestQueue(this)
        val url = "https://psychonauts-api.herokuapp.com/api/powers"
        val objectRequest = JsonArrayRequest(
                Request.Method.GET, url, null, {
                        result ->
                        for(indice in 0 until result.length())
                        {
                                val powerPsyJsonInd = result.getJSONObject(indice)
                                val psyco = psyconauts( powerPsyJsonInd.getString("name"),
                                                powerPsyJsonInd.getString("description"),
                                                powerPsyJsonInd.getString("img")
                        )
                        print(powerPsyJsonInd.getString("name"))
                        psyPowers.add(psyco)
                    }
                },
            {
                error("error")
            }
            )
        queue.add(objectRequest)

        val adapter = Psypoweradapter(psyPowers)

        recyclerPsy.layoutManager = LinearLayoutManager(this)
        recyclerPsy.adapter = adapter

    }

}