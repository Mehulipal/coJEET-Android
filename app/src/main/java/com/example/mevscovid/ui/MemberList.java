package com.example.mevscovid.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mevscovid.R;
import com.example.mevscovid.ui.slideshow.SlideshowFragment;

import java.util.List;

public class MemberList extends ArrayAdapter<Members> {

    private Context context;
    private List<Members> memberlist;

    public MemberList(Context context, List<Members> memberlist)
    {
       super(context, R.layout.list_layout, memberlist);
        this.context = context;
        this.memberlist = memberlist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //LayoutInflater inflater = context.getLayoutInflater();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView tv1 = (TextView)listViewItem.findViewById(R.id.tv1);
        TextView tv2 = (TextView)listViewItem.findViewById(R.id.tv2);

        Members mem = memberlist.get(position);

        tv1.setText(mem.getMname());
        tv2.setText(mem.getMgenre());

        return listViewItem;
    }
}
