package banuelos.hector.apipsyconauts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class psypoweradapter (val psyconauts:List<psyconauts>):RecyclerView.Adapter<psypoweradapter.psypowerHolder>(){

    class psypowerHolder(val view: View):RecyclerView.ViewHolder(view){
    fun render(psyconauts: psyconauts){
    view.
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): psypowerHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return psypowerHolder(layoutInflater.inflate(R.layout.powerlayouut,parent,false))
    }

    override fun onBindViewHolder(holder: psypowerHolder, position: Int) {
        holder.render(psyconauts[position])
    }

    override fun getItemCount(): Int = psyconauts.size
}