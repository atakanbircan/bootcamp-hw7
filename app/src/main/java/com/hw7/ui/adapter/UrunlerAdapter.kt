package com.hw7.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

import com.hw7.data.entity.Urunler
import com.hw7.databinding.MainRvCardDesignBinding
import com.hw7.ui.fragment.MainFragmentDirections
import com.hw7.ui.viewmodel.MainFragmentViewModel

class UrunlerAdapter(var mcontext : Context, var mList : List<Urunler>,var viewModel:MainFragmentViewModel)
    : RecyclerView.Adapter<UrunlerAdapter.CardTasarimHolder>() {


    inner class CardTasarimHolder(var design : MainRvCardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {

        val binding = MainRvCardDesignBinding.inflate(LayoutInflater.from(mcontext), parent,false)
        return CardTasarimHolder(binding)

    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val urun = mList.get(position)
        holder.design.txtUrunAdi.text = mList.get(position).urun_ad
        holder.design.txtUrunFiyat.text = "${mList.get(position).urun_fiyat.toString()}₺"

        holder.design.CardViewRow.setOnClickListener {
            val transition = MainFragmentDirections.urunDetayGecis(urun = urun)
            Navigation.findNavController(it).navigate(transition)
        }

        holder.design.imageView.setOnClickListener {
            Snackbar.make(it,"${urun.urun_ad} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.sil(urun.urun_id)
                }
                .show()
        }
    }


}