package banuelos.hector.apipsyconauts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Psypoweradapter (val psyconauts:List<psyconauts>):RecyclerView.Adapter<Psypoweradapter.PsypowerHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PsypowerHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return PsypowerHolder(layoutInflater.inflate(R.layout.powerlayouut,parent,false))
    }

    override fun onBindViewHolder(holder: PsypowerHolder, position: Int) {
        holder.render(psyconauts[position])
    }

    override fun getItemCount(): Int = psyconauts.size

    class PsypowerHolder(val view:View):RecyclerView.ViewHolder(view){
        val PsyPowerName = view.findViewById<TextView>(R.id.tvPsyPowername)
        val PsyPowerDescription = view.findViewById<TextView>(R.id.tvPsyPowerDescription)
        val PsyPowerImage = view.findViewById<ImageView>(R.id.ivPsy)
        fun render(psyconauts: psyconauts){
            PsyPowerName.text = psyconauts.psypower
            PsyPowerDescription.text = psyconauts.psypower_description
            Picasso.get().load(psyconauts.psypower_image).into(PsyPowerImage);
        }
    }
}