package com.ideas2it.apiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements DownloadCompleteListener {

  ListFragment mListFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    startDownload();
  }

  private void showListFragment(ArrayList<Places> places) {
    mListFragment = ListFragment.newInstance(places);
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mListFragment).
        commit();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    return id == R.id.action_settings || super.onOptionsItemSelected(item);
  }

  private void startDownload() {
    new FetchDataFromAPITask(this).execute("https://demo3504260.mockable.io/getImageUrls");
  }

  @Override
  public void downloadComplete(ArrayList<Places> places) {
    showListFragment(places);
  }
}
