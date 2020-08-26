package com.prography.playeasy.team.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;

import com.prography.playeasy.util.UIHelper;

public class TeamInformation extends AppCompatActivity {

    private ImageView TeamProfile;
    private MaterialButton showMember;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_teaminfo);

        UIHelper.Companion.toolBarInitialize(this, findViewById(R.id.teamInfoToolBar));
        UIHelper.Companion.hideWindow(this);

        initialized();
    }

    private void initialized() {
        showMember = findViewById(R.id.teamPlayerShowButton);
        showMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamMember.class);
                startActivity(intent);
            }
        });
    }
}
