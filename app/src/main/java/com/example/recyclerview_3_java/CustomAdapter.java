package com.example.recyclerview_3_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT= 1;

    private Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent,false);
            return new CustomViewYesHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_not,parent,false);
        return new CustomViewNotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof CustomViewYesHolder){
            TextView first_name = ((CustomViewYesHolder)holder).first_name;
            TextView last_name = ((CustomViewYesHolder)holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }

        if(holder instanceof CustomViewNotHolder){
            TextView first_name = ((CustomViewNotHolder)holder).first_name;
            TextView last_name = ((CustomViewNotHolder)holder).last_name;

            first_name.setText("This first name is not available");
            last_name.setText("This last name is not available");
        }

    }

    //asosiy qism shu yerda//
    //agar member mavjud bo`lsa yes, bo`lmasa not qaytaradi
    @Override
    public int  getItemViewType(int position){
        Member member = members.get(position);

        if(member.isAvailable()){
            return TYPE_AVAILABLE_YES;
        }
        return TYPE_AVAILABLE_NOT;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        TextView first_name,last_name;
        public CustomViewYesHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }

    private class CustomViewNotHolder extends RecyclerView.ViewHolder {
        public View view;
        TextView first_name,last_name;
        public CustomViewNotHolder(View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
