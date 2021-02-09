package com.bg.imusicplayer.data.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bg.callhistory.callback.MusicCallback
import com.bg.imusicplayer.R
import com.bg.imusicplayer.data.Adapter.MusicListAdapter
import com.bg.imusicplayer.data.model.obj.Entry
import com.bg.imusicplayer.data.utils.ApiException
import com.bg.imusicplayer.data.utils.AppConstants.ENTRY_OBJ
import com.bg.imusicplayer.data.utils.Coroutines
import com.bg.imusicplayer.data.utils.NoInternetException
import com.bg.imusicplayer.data.viewmodel.SongListViewModel
import com.bg.imusicplayer.data.viewmodel.SongListViewModelFactory
import com.bg.imusicplayer.databinding.FragmentMusicListBinding


import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MusicListFragment : Fragment(),MusicCallback, KodeinAware {

    private lateinit var musicListAdapter: MusicListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var songListViewModel: SongListViewModel
    private val factory: SongListViewModelFactory by instance()
    override val kodein by kodein()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
setPrimaryColorStatusBarColor()
        // Inflate the layout for this fragment
        songListViewModel = ViewModelProvider(this, factory).get(SongListViewModel::class.java)

        val fragmentMusicListBinding: FragmentMusicListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_music_list, container, false
        )

        // bind RecyclerView
        recyclerView = fragmentMusicListBinding?.recyclerViewMusic
        recyclerView.setLayoutManager(LinearLayoutManager(activity))

        //init the Custom adataper
        musicListAdapter = MusicListAdapter()
        //set the CustomAdapter
        recyclerView.setAdapter(musicListAdapter)

        return fragmentMusicListBinding.root
    }



    private fun initMusicListData()= Coroutines.main {
        try {
          var  musicFragmentContext=this
            lifecycleScope.launch {

                songListViewModel.getOfflineSongs().observe(viewLifecycleOwner, {
                    if (it != null && it?.feed?.entry?.size!! >= 0) {
                        musicListAdapter?.setMusicList(
                            musicFragmentContext, requireActivity(),
                            it.feed.entry
                        )
                    } else {
                        lifecycleScope.launch {
                            songListViewModel.getSongInfo(20).observe(viewLifecycleOwner, Observer {
                                it.feed?.let { it1 ->
                                    musicListAdapter?.setMusicList(
                                        musicFragmentContext, requireActivity(),
                                        it1.entry
                                    )
                                }

                            })
                        }
                    }

                })

            }

        } catch (e: ApiException) {
            e.printStackTrace()
        } catch (e: NoInternetException) {
            e.printStackTrace()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMusicListData()
    }

    override fun onClick(entry: Entry) {

        var bundle = Bundle()
        bundle.putSerializable(ENTRY_OBJ, entry)
        findNavController().navigate(
            R.id.action_FirstFragment_to_SecondFragment,
            bundle
        )

    }


     fun setPrimaryColorStatusBarColor() {
        if (activity != null) {
            val window = activity?.window
            window?.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            );

        }
    }
}