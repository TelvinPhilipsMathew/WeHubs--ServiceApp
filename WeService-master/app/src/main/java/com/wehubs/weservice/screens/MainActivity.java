package com.wehubs.weservice.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wehubs.weservice.R;
import com.wehubs.weservice.customAdapters.CategoryAdapter;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bindViews();

        setCategoryAdapter();
    }
    private void setCategoryAdapter() {
        CategoryAdapter adapter = new CategoryAdapter(this);
        rvCategory.setAdapter(adapter);
    }

    private void bindViews() {
        rvCategory =(RecyclerView)findViewById(R.id.rv_category);
        lLayout = new GridLayoutManager(MainActivity.this, 2);
        rvCategory.setHasFixedSize(true);
        rvCategory.setLayoutManager(lLayout);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            onBackPressed();
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
      //  AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   AppEventsLogger.deactivateApp(this);
    }
}
