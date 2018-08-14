package com.ryctabo.retrofit.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ryctabo.retrofit.R;
import com.ryctabo.retrofit.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gustavo Pacheco (ryctabo at gmail.com)
 * @version 1.0-SNAPSHOT
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mDataSource;

    public UserAdapter() {
        this.mDataSource = new ArrayList<>();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextName, mTextInfo;

        ViewHolder(View itemView) {
            super(itemView);

            this.mTextName = itemView.findViewById(R.id.text_name);
            this.mTextInfo = itemView.findViewById(R.id.text_info);
        }
    }

    public void updateDataSource(List<User> dataSource) {
        this.mDataSource.clear();
        this.mDataSource.addAll(dataSource);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewRoot = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(viewRoot);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        User user = this.mDataSource.get(index);
        if (user != null) {
            holder.mTextName.setText(user.getName());

            String info = String.format("%s - %s", user.getUsername(), user.getEmail());
            holder.mTextInfo.setText(info);
        }
    }

    @Override
    public int getItemCount() {
        return this.mDataSource.size();
    }

}
