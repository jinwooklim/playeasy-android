package com.prography.playeasy.team.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.util.UIHelper;

public class TeamMember extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_teammember);

        UIHelper.Companion.toolBarInitialize(this, findViewById(R.id.TeamMemberToolbar));
        UIHelper.Companion.hideWindow(this);
    }
}
