package com.example.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//public class RanklistAdapter extends ArrayAdapter<Leaderboard.rankList>
public class RanklistAdapter extends ArrayAdapter<Leaderboard.rankList> {
    private int resourceId;
    public RanklistAdapter(Context context, int textViewResourceId,
                        ArrayList<Leaderboard.rankList> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Leaderboard.rankList user=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,
                false);
        // inflate 预加载布局 被加载 是否加载

        TextView userName=(TextView)view.findViewById(R.id.User_name);
        TextView flagDays=(TextView)view.findViewById(R.id.Flag_days);
        userName.setText(user.getUsername());
        flagDays.setText(user.getDays().toString());

        return view;
    }


}



    /*
    private ArrayList<Leaderboard.rankList> mRankList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        View personView;
        TextView userName;
        TextView flagDays;

        public ViewHolder(View view) {
            super(view);
            personView= view;
            userName=(TextView)view.findViewById(R.id.User_name);
            flagDays=(TextView)view.findViewById(R.id.Flag_days);
        }
    }

    public RanklistAdapter(ArrayList<Leaderboard.rankList> Ranklist) {
        mRankList=Ranklist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.personView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Leaderboard.rankList user=mRankList.get(position);
        holder.userName.setText(user.getUsername());
        holder.flagDays.setText(user.getDays());
    }

    @Override
    public int getItemCount() {
        return mRankList.size();
    }
    */

