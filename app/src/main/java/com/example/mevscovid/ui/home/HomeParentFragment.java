package com.example.mevscovid.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import androidx.fragment.app.Fragment;

import com.example.mevscovid.ApiClient;
import com.example.mevscovid.ui.JsonPlaceholderApi4;
import com.example.mevscovid.ui.PoliciesClass;
import com.example.mevscovid.R;


import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mevscovid.adapter;
import com.example.mevscovid.ui.JsonPlaceholderApi;
import com.example.mevscovid.ui.Post;
import com.example.mevscovid.ui.slideshow.SlideshowFragment2;
import com.example.mevscovid.ui.tools.ToolsFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeParentFragment extends Fragment {
    public HomeParentFragment() {
    }

 /*   private int[] mImg = new int[] {
            R.drawable.cc1, R.drawable.cc2, R.drawable.cc3
    };
    private String[] mImgTitle = new String[] {
            "One", "Two", "Three"
    }; */

 public LinearLayout aa;
 public LinearLayout bb;
 public LinearLayout cc;
 public LinearLayout dd;
 public LinearLayout ee;
 public LinearLayout ff;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent_home, container, false);

        ImageView imageView = view.findViewById(R.id.main_logo_iv);

        aa = (LinearLayout) view.findViewById(R.id.main_event_ll);
        bb = (LinearLayout) view.findViewById(R.id.main_pronite_ll);
        cc = (LinearLayout) view.findViewById(R.id.main_gallery_ll);
        dd = (LinearLayout) view.findViewById(R.id.main_special_ll);
        ee = (LinearLayout) view.findViewById(R.id.main_team_ll);
        ff = (LinearLayout) view.findViewById(R.id.main_sponsor_ll);

        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new LFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new HFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new NFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ToolsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(getId(), fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    //    Glide.with(requireContext()).load(R.drawable.celesta_logo_long_2).into(imageView);

   /*     CarouselView carview = view.findViewById(R.id.carouselView);
        carview.setPageCount(mImg.length);
        carview.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImg[position]);
            }
        });
        carview.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(),mImgTitle[position],Toast.LENGTH_SHORT).show();
            }
        }); */

        return view;
    }
}

