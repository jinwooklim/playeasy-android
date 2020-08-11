package com.prography.playeasy.match.module.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.match.activity.MatchDetail;
import com.prography.playeasy.match.domain.models.Match;

import java.util.ArrayList;
import java.util.List;


public class MatchRecyclerAdapter extends RecyclerView.Adapter<MatchRecyclerAdapter.MyViewHolder> {
    private List<Match> matchList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_activity_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(matchList.get(position));
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public void addItems(Match match) {
        matchList.add(match);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        private TextView title;
        private TextView type;
        private TextView description;
        private TextView startAt;

        private TextView duration;
        private TextView fee;
        private TextView phone;


        private TextView totalQuota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            type = itemView.findViewById(R.id.matchType);
            description = itemView.findViewById(R.id.matchDescription);

            startAt = itemView.findViewById(R.id.matchStartAt);
            duration = itemView.findViewById(R.id.matchEndAt);
            fee = itemView.findViewById(R.id.matchFee);
            totalQuota = itemView.findViewById(R.id.matchHomeQuota);
        }

        //주석 처리
        public void onBind(Match match) {
//            title.setText(match.getTitle());
//            type.setText(match.getType());
            description.setText(match.getDescription());
//            location.setText(match.getLocation());
            fee.setText(String.valueOf(match.getFee()));
            startAt.setText(match.getStartAt().toString());
//            endAt.setText(match.getEndAt().toString());
            //      homeQuota.setText(String.valueOf(match.getHomeQuota()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tvMatchId = v.findViewById(R.id.matchId);
                    int matchId = Integer.parseInt(tvMatchId.getText().toString());

                    Intent intent = new Intent(v.getContext(), MatchDetail.class);
                    intent.putExtra("match_id", matchId);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
