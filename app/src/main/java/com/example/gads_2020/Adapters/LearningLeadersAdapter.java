package com.example.gads_2020.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads_2020.Model.Leader;
import com.example.gads_2020.R;

import java.util.ArrayList;
import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    Context context;
    //initialize the array list
    private List<Leader> leaderBoard = new ArrayList<>();

    public LearningLeadersAdapter(List<Leader> leaderBoard, Context context) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_leaders_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(leaderBoard.get(position).getName());
        holder.textView2.setText(leaderBoard.get(position).getHours());
        holder.image.setImageResource(Integer.parseInt(leaderBoard.get(position).getBadgeUrl()));

    }

    @Override
    public int getItemCount() {
        return leaderBoard.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //initialize the text views
        private TextView textView1, textView2;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.learning_textView_1);
            textView2 = itemView.findViewById(R.id.learning_textView_2);
            image = itemView.findViewById(R.id.learning_image);
        }
    }
}
