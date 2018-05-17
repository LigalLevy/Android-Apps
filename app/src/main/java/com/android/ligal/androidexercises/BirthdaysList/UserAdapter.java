package com.android.ligal.androidexercises.BirthdaysList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ligal.androidexercises.R;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<BirthDayList> birthdays;

    public UserAdapter(List<BirthDayList> _birthdays) {
        this.birthdays = _birthdays;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( UserAdapter.ViewHolder holder, int position) {
        holder.name.setText(this.birthdays.get(position).getName());
        holder.birthDate.setText(this.birthdays.get(position).getBirthDay());
        holder.comment.setText(this.birthdays.get(position).getComment());
    }

    @Override
    public int getItemCount() { return birthdays.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView birthDate;
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            birthDate = itemView.findViewById(R.id.birthdate_tv);
            comment = itemView.findViewById(R.id.comment_tv);

        }
    }
}