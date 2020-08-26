package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.team.activity.TeamInformation;
import com.prography.playeasy.util.UIHelper;

import net.daum.mf.map.api.MapView;

public class MatchDetail extends AppCompatActivity {

    private MaterialButton detailHomeTeam;
    private MaterialButton detailAppliedMatch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        UIHelper.Companion.toolBarInitialize(this, findViewById(R.id.matchDetailToolBar));
        UIHelper.Companion.hideWindow(this);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.matchDetailMap);
        mapViewContainer.addView(mapView);

        initialized();
    }

    private void initialized() {

        detailHomeTeam = findViewById(R.id.detailHomeTeam);
        detailAppliedMatch = findViewById(R.id.detailMatchApplyButton);

        detailHomeTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamInformation.class);
                startActivity(intent);
            }
        });

        detailAppliedMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

    }
}
