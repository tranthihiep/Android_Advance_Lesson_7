package com.haha.lesson_7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by trant on 17/01/2018.
 */

public class AdapterInfor extends RecyclerView.Adapter<AdapterInfor.ViewHolder> {
    private ArrayList<Information> mInfor;

    AdapterInfor(ArrayList<Information> informations) {
        this.mInfor = informations;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_information, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return mInfor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtID,mTxtName,mTxtFullName;
        public ViewHolder(View itemView) {
            super(itemView);
            mTxtName =(TextView) itemView.findViewById(R.id.txtName);
            mTxtID =(TextView) itemView.findViewById(R.id.txtID);
            mTxtFullName =(TextView) itemView.findViewById(R.id.txtFullName);

        }
        public void setData(int pos){
            mTxtName.setText("Name: "+mInfor.get(pos).getmName());
            mTxtID.setText("Id: "+mInfor.get(pos).getmID());
            mTxtFullName.setText("Full name: "+mInfor.get(pos).getmFullName());

        }
    }
}

