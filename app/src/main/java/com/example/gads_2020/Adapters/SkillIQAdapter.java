package com.example.gads_2020.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gads_2020.Model.SkillIQ;
import com.example.gads_2020.R;

import java.util.ArrayList;
import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.ViewHolder> {
    //initialize the array list
    private List<SkillIQ> skillIQ = new ArrayList<>();

    //initialize the constructor
    public SkillIQAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_iq_item, parent, false);
        return new SkillIQAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(skillIQ.get(position));
    }

    @Override
    public int getItemCount() {
        return skillIQ.size();
    }

    public void setSkillIQ(List<SkillIQ> skillIQ) {
        this.skillIQ = skillIQ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //initialize views on skill_iq_item
        private TextView textView1, textView2, country;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.skill_textView_1);
            textView2 = itemView.findViewById(R.id.skill_textView_2);
            country = itemView.findViewById(R.id.country2);
            image = itemView.findViewById(R.id.skill_image);

        }

        public void bind(SkillIQ skillIQ) {
            textView1.setText(skillIQ.getName());
            textView2.setText(skillIQ.getSkillscore());
            country.setText(skillIQ.getCountry());

            Glide.with(image.getContext())
                    .load(skillIQ.getImage())
                    .centerCrop()
                    .into(image);
        }

    }
}
