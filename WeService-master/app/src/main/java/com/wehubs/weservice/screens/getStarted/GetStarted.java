package com.wehubs.weservice.screens.getStarted;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wehubs.weservice.CustomViews.CirclePageIndicator;
import com.wehubs.weservice.screens.Login.LoginActivity;
import com.wehubs.weservice.R;

public class GetStarted extends FragmentActivity {

	/**
	 * The number of pages (wizard steps) to show in this demo.
	 */
	private static final int NUM_PAGES = 3;
	CirclePageIndicator mIndicator;
	TextView skip,next;
	/**
	 * The pager widget, which handles animation and allows swiping horizontally
	 * to access previous and next wizard steps.
	 */
	private ViewPager mPager;
	/**
	 * The pager adapter, which provides the pages to the view pager widget.
	 */
	private PagerAdapter mPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_started);

		// Instantiate a ViewPager and a PagerAdapter.
		mPager = (ViewPager) findViewById(R.id.getstarted_pager);
		skip =(TextView)findViewById(R.id.skip);
		next =(TextView)findViewById(R.id.next);
		setPagerAdapter();
		skip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent loginIntentSkip = new Intent(GetStarted.this, LoginActivity.class);
				startActivity(loginIntentSkip);
				finish();
				overridePendingTransition(R.anim.fadein, R.anim.no_change);
			}
		});


		next.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				if (next.getText().toString().equalsIgnoreCase(getString(R.string.b_done))) {
					Intent loginIntentDone = new Intent(GetStarted.this, LoginActivity.class);
					startActivity(loginIntentDone);
					finish();
					overridePendingTransition(R.anim.fadein, R.anim.no_change);
				} else {
					// Otherwise, select the previous step.
					mPager.setCurrentItem(mPager.getCurrentItem() + 1);
				}
			}
		});
	}



	private void setPagerAdapter() {
		mPagerAdapter = new WelcomeScreenPagerAdapter(
				getSupportFragmentManager(),GetStarted.this);
		mPager.setAdapter(mPagerAdapter);
		mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override public void onPageSelected(int position) {
				if(mPager.getCurrentItem() == NUM_PAGES - 1){
					skip.setVisibility(View.INVISIBLE);
					next.setText(getString(R.string.b_done));


				}
				else{

					if(next.getText().toString().equalsIgnoreCase((getString(R.string.b_done)))) {
						skip.setVisibility(View.VISIBLE);
						next.setText(getString(R.string.b_next));
					}
				}

			}

			@Override public void onPageScrollStateChanged(int state) {

			}
		});
		mIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);

	}

	@Override
	public void onBackPressed() {
		if (mPager.getCurrentItem() == 0) {
			// If the user is currently looking at the first step, allow the
			// system to handle the
			// Back button. This calls finish() on this activity and pops the
			// back stack.
			super.onBackPressed();
		} else {
			// Otherwise, select the previous step.
			mPager.setCurrentItem(mPager.getCurrentItem() - 1);
		}
	}

	/**
	 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects,
	 * in sequence.
	 */
	private class WelcomeScreenPagerAdapter extends FragmentStatePagerAdapter {

		LayoutInflater mLayoutInflater;
		int mResources[] = { R.drawable.sample_walkthrough, R.drawable.sample_walkthrough, R.drawable.sample_walkthrough, R.drawable.sample_walkthrough, R.drawable.sample_walkthrough};
		public WelcomeScreenPagerAdapter(FragmentManager fm,Activity mContext) {

			super(fm);
			mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public Fragment getItem(int position) {
			return new GetStartedFragment().create(position);
		}

		@Override
		public int getCount() {
			return NUM_PAGES;
		}

	}

}
