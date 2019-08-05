package com.moreno.searchitunes.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.moreno.searchitunes.Constants;
import com.moreno.searchitunes.R;
import com.moreno.searchitunes.databinding.ActivityDetailBinding;
import com.moreno.searchitunes.models.Track;
import com.moreno.searchitunes.viewmodels.DetailViewModel;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupToolbar();
        setupBindings();

    }

    private void setupToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        binding.setViewmodel(detailViewModel);

        Track track = (Track) getIntent().getSerializableExtra(Constants.EXTRA_TRACK);
        binding.setTrack(track);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
