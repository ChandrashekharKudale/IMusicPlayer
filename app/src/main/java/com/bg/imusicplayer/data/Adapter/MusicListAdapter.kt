package com.bg.imusicplayer.data.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bg.callhistory.callback.MusicCallback
import com.bg.imusicplayer.R
import com.bg.imusicplayer.data.model.obj.Entry
import com.bg.imusicplayer.data.utils.IMusicUtils
import com.bg.imusicplayer.data.view.MusicListFragment
import com.bg.imusicplayer.databinding.SongListItemBinding

import java.util.*

class MusicListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


   // private   var musicList: List<Entry>= ArrayList<Entry>()
    //val callUtils= com.bg.callhistory.utils.CallUtils
    private var musicList: ArrayList<Entry> = ArrayList<Entry>()
    private var callback: MusicCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val mSongListItemBinding = DataBindingUtil.inflate<SongListItemBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.song_list_item, parent, false
                )
                return SongListViewHolder(mSongListItemBinding)

        }

        override fun onBindViewHolder(songViewHolder: RecyclerView.ViewHolder, position: Int) {

        val listItem = musicList[position]

                val headerViewHolder = songViewHolder as SongListViewHolder

            songViewHolder.songListItemBinding.musicModel = listItem
            songViewHolder.songListItemBinding.imusicUtils=IMusicUtils


            songViewHolder.songListItemBinding.rootLayout.setOnClickListener {
                callback?.onClick(listItem)
            }


        }

    override fun getItemCount(): Int {
        return if (musicList != null) {
            musicList!!.size
        } else {
            0
        }
    }


    fun setMusicList(
        context1: MusicListFragment,
        context: Context,
        musicListModel: List<Entry>
    ) {
        musicList=musicListModel as ArrayList<Entry>
        this.callback=context1
        notifyDataSetChanged()
    }


     class SongListViewHolder(var songListItemBinding: SongListItemBinding) :
        RecyclerView.ViewHolder(songListItemBinding.root)




}