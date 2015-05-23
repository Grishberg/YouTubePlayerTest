package com.grishberg.youtubeplayertest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.pedrovgs.DraggableView;
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
	private DraggableView					mDraggableView;
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
		mDraggableView		= (DraggableView)  	getView().findViewById(R.id.draggable_view);
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
					//mYouTubePlayer.cueVideo("nCgQDjiotG0");
					mYouTubePlayer.loadVideo("nCgQDjiotG0");
					mYouTubePlayer.play();
					mYouTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener()
					{
						@Override
						public void onLoading()
						{

						}

						@Override
						public void onLoaded(String s)
						{

						}

						@Override
						public void onAdStarted()
						{

						}

						@Override
						public void onVideoStarted()
						{

						}

						@Override
						public void onVideoEnded()
						{

						}

						@Override
						public void onError(YouTubePlayer.ErrorReason errorReason)
						{
							Log.d(TAG,errorReason.toString());
						}
					});
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
