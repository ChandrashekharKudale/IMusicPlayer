package com.bg.imusicplayer.data.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bg.imusicplayer.R
import com.bg.imusicplayer.data.model.obj.Entry
import com.bg.imusicplayer.data.utils.AppConstants
import com.bg.imusicplayer.data.utils.IMusicUtils
import com.bg.imusicplayer.data.viewmodel.SongDetailsViewModel
import com.bg.imusicplayer.data.viewmodel.SongDetailsViewModelFactory
import com.bg.imusicplayer.databinding.FragmentMusicDetailsBinding
import com.bg.imusicplayer.databinding.FragmentMusicListBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MusicDetailsFragment : Fragment(), KodeinAware {

    private lateinit var songDetailsViewModel: SongDetailsViewModel
    private lateinit var entryItem: Entry

    private val factory: SongDetailsViewModelFactory by instance()
    override val kodein by kodein()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPrimaryColorStatusBarColor()
        songDetailsViewModel = ViewModelProvider(this, factory).get(SongDetailsViewModel::class.java)


        val fragmentMusicDetailsBinding: FragmentMusicDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_music_details, container, false
        )

        if (arguments!=null && arguments?.getSerializable(AppConstants.ENTRY_OBJ)!=null){
            // Log.d("data", (args.toString()))
            entryItem= arguments?.getSerializable(AppConstants.ENTRY_OBJ) as Entry


        }
        fragmentMusicDetailsBinding.musicModel=entryItem
        fragmentMusicDetailsBinding.viewModelDetail=songDetailsViewModel
        fragmentMusicDetailsBinding.imusicUtils= IMusicUtils
        fragmentMusicDetailsBinding.imageView4.setBackgroundResource(R.drawable.ic_play)

        return fragmentMusicDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments!=null && arguments?.getSerializable(AppConstants.ENTRY_OBJ)!=null){
            entryItem= arguments?.getSerializable(AppConstants.ENTRY_OBJ) as Entry

        }
    }


    fun setPrimaryColorStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (activity != null) {
                val window = activity?.window
                window?.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            }
        }
    }
}