package com.aadesh.userapp.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.aadesh.userapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comp,"Computer Engineering", "The Department of Computer Engineering was established in 2011 and it offers four year degree course. Department is equipped with experienced staff and high end computational laboratories with software and students will be exposed to be familiar with latest trends in the field."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering", "The department of Mechanical Engineering was established in 2011 and it offers four year degree course. The Department has dedicated experienced and well qualified faculty. The laboratories and workshops are well equipped with excellent training aids and modern machineries. "));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext()).load("https://gmvit.com/wp-content/uploads/2020/03/PANO_20200302_103652-1-scaled.jpg").into(imageView);

        return view;
    }
}