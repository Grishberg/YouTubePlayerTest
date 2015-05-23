package com.grishberg.youtubeplayertest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{
	public static final String TAG						= "YoutubePlayer";
	public static final String YOUTUBE_API_KEY			="AIzaSyD0INVrE2YHbGJqhU3iTjzLSPOFDAuactE";
	private YouTubePlayerSupportFragment	mYouTubeContainer;
	private YouTubePlayer					mYouTubePlayer;
	public MainActivityFragment()
	{
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		initiliazeYoutubeFragment();
	}

	// инициализация плеера
	private void initiliazeYoutubeFragment()
	{

		mYouTubeContainer = YouTubePlayerSupportFragment.newInstance();
		mYouTubeContainer.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener()
		{
			@Override
			public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored)
			{
				if (!wasRestored)
				{
					mYouTubePlayer	= youTubePlayer;
//					youTubePlayer.cueVideo("nCgQDjiotG0");
					mYouTubePlayer.loadVideo("nCgQDjiotG0");
					mYouTubePlayer.play();
				}
			}

			@Override
			public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
			{

			}
		});
		getChildFragmentManager().beginTransaction().replace(R.id.fragment_youtube_player, mYouTubeContainer).commit();

	}
}
