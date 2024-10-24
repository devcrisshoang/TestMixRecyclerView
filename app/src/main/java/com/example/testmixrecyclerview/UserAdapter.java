package com.example.testmixrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static int TYPE_USER_FEATURE = 1;
    private static int TYPE_USER_NORMAL = 2;

    private List<User> mListUser;

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(TYPE_USER_FEATURE == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_featured,parent,false);
            return new UserFeaturedViewHolder(view);
        } else if (TYPE_USER_NORMAL == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_normal,parent,false);
            return new UserNormalViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null){
            return;
        }
        if (TYPE_USER_FEATURE == holder.getItemViewType()){
            UserFeaturedViewHolder userFeaturedViewHolder = (UserFeaturedViewHolder) holder;
            userFeaturedViewHolder.imgUserFeatured.setImageResource(user.getResourceId());
            userFeaturedViewHolder.tvUserNameFeatured.setText(user.getName());
        } else if (TYPE_USER_NORMAL == holder.getItemViewType()) {
            UserNormalViewHolder userNormalViewHolder = (UserNormalViewHolder) holder;
            userNormalViewHolder.imgUserNormal.setImageResource(user.getResourceId());
            userNormalViewHolder.tvUserNameNormal.setText(user.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return mListUser.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        User user = mListUser.get(position);
        if (user.isFeatured()){
            return  TYPE_USER_FEATURE;
        }
        else return TYPE_USER_NORMAL;
    }

    public class  UserFeaturedViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUserFeatured;
        private TextView tvUserNameFeatured;

        public UserFeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserFeatured = itemView.findViewById(R.id.img_user_featured);
            tvUserNameFeatured = itemView.findViewById(R.id.tv_user_name_featured);
        }

    }
    public class UserNormalViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUserNormal;
        private TextView tvUserNameNormal;

        public UserNormalViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserNormal = itemView.findViewById(R.id.img_user_normal);
            tvUserNameNormal = itemView.findViewById(R.id.tv_user_name_normal);
        }
    }
 }
