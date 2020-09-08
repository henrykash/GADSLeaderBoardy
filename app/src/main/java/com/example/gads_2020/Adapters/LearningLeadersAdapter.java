package com.example.gads_2020.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gads_2020.Model.LeaderBoard;
import com.example.gads_2020.R;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    //initialize the array list
    private List<LeaderBoard> leaderBoard = new ArrayList<>();
    //initialize the constructor
    public LearningLeadersAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_leaders_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(leaderBoard.get(position));
    }

    @Override
    public int getItemCount() {
        return leaderBoard.size();
    }

    public void setLeaderBoard(List<LeaderBoard> leaderBoard) {
        this.leaderBoard = leaderBoard;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        //initialize the text views
        private TextView textView1, textView2, country;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.learning_textView_1);
            textView2 = itemView.findViewById(R.id.learning_textView_2);
            country = itemView.findViewById(R.id.country);
            image = itemView.findViewById(R.id.learning_image);
        }

        public void bind(LeaderBoard leaderBoard) {
            textView1.setText(leaderBoard.getName());
            textView2.setText(leaderBoard.getHours());
            country.setText(leaderBoard.getCountry());

            Glide.with(image.getContext())
                    .load(leaderBoard.getImage())
                    .centerCrop()
                    .into(image);
        }

    }
}
