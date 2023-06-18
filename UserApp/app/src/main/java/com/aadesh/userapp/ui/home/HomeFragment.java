package com.aadesh.userapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.aadesh.userapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=G M vedak Institute of technology tala");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i=0; i<5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/gmvit-app.appspot.com/o/gallery%2F%5BB%40f05b68cjpg?alt=media&token=45ea787e-6c28-4347-bca6-675a594ea30d");
                    break;
                    case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/gmvit-app.appspot.com/o/gallery%2F%5BB%406cb85fdjpg?alt=media&token=ff261520-6485-4eb5-92c8-83766fd971e3");
                    break;
                      case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/gmvit-app.appspot.com/o/gallery%2F%5BB%408cb9f25jpg?alt=media&token=06cb6080-6c82-481a-9056-28431592e7d4");
                    break;
                      case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/gmvit-app.appspot.com/o/gallery%2F%5BB%40940efaajpg?alt=media&token=a55cb816-1359-4170-b3ba-406f96b2bdf1");
                    break;
                      case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/gmvit-app.appspot.com/o/gallery%2F%5BB%408b428cbjpg?alt=media&token=fea586ca-8bd3-4642-b3df-1f3147935e7f");
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}