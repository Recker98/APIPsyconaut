package banuelos.hector.apipsyconauts


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import android.widget.Toast.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    lateinit var psyPowers:ArrayList<psyconauts>
    lateinit var adapter:Psypoweradapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        psyPowers = arrayListOf<psyconauts>(
        )
        val recyclerPsy = findViewById<RecyclerView>(R.id.Psyconauts)
        adapter = Psypoweradapter(psyPowers)
        recyclerPsy.layoutManager = LinearLayoutManager(this)
        recyclerPsy.adapter = adapter
        getPsy()
    }

    private fun getPsy(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://psychonauts-api.herokuapp.com/api/powers"
        val objectRequest = JsonArrayRequest(
            Request.Method.GET, url, null, {
                    result ->
                for(indice in 0..result.length()-1)
                {
                    val powerPsyJsonInd = result.getJSONObject(indice)
                    val psyco = psyconauts( powerPsyJsonInd.getString("name"),
                        powerPsyJsonInd.getString("description"),
                        powerPsyJsonInd.getString("img")
                    )
                    psyPowers.add(psyco)
                }
                adapter.notifyDataSetChanged()            },
            {
                error("error")
                makeText(this, "Error", LENGTH_LONG).show()
            }
        )
        queue.add(objectRequest)

    }

}
































fun getarray(psyconauts:ArrayList<psyconauts> ){
    psyconauts.add(psyconauts("clairvoyance","Allows the user to see through the minds of others.","https://psychonauts-api.herokuapp.com/images/api/clairvoyance.png"))
    psyconauts.add(psyconauts("confusion","Allows the user to confuse enemies.","https://psychonauts-api.herokuapp.com/images/api/confusion.png"))
    psyconauts.add(psyconauts("herbaphony","Allows the user to speak to plants.","https://psychonauts-api.herokuapp.com/images/api/telekinesis.png"))
    psyconauts.add(psyconauts("hydrokinesis","Allows the user to control the movement of water.","https://psychonauts-api.herokuapp.com/images/api/hydrokinesis.png"))
    psyconauts.add(psyconauts("invisibility","Allows the user to turn invisible for a short period of time.","https://psychonauts-api.herokuapp.com/images/api/invisibility.png"))
}