package com.wehubs.weservice.screens.getStarted;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wehubs.weservice.R;

public class GetStartedFragment extends Fragment {
	ImageView setBackground;
	Button gotItButton;
	String ARG_IMAGEID = "ImageId";
	int imageID;

	public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);

		// Calculate inSampleSize
		options.inSampleSize = 2;//calculateInSampleSize(options, reqWidth, reqHeight);

		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public GetStartedFragment create(int position) {
        GetStartedFragment fragment = new GetStartedFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_IMAGEID, position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.fragment_get_started, container, false);
		setBackground = (ImageView) rootView
				.findViewById(R.id.getstarted_image);
		imageID=getArguments().getInt(ARG_IMAGEID);
		bgChange(imageID);
		return rootView;
	}

	private void bgChange(int imageID) {
		if (imageID==0){
			setBackground.setBackgroundResource(R.drawable.sample_walkthrough);
		}else if (imageID==1){
			setBackground.setBackgroundResource(R.drawable.sample_walkthrough);
			//setBackground.setImageBitmap(decodeSampledBitmapFromResource(getActivity().getResources(), R.drawable.getstarted2));
		}else {
			setBackground.setBackgroundResource(R.drawable.sample_walkthrough);
			//setBackground.setImageBitmap(decodeSampledBitmapFromResource(getActivity().getResources(), R.drawable.getstarted3));
		}
	}
}
	
