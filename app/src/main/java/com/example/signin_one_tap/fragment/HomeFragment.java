package com.example.signin_one_tap.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.signin_one_tap.HomeActivity;
import com.example.signin_one_tap.R;
import com.example.signin_one_tap.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    TextView headerTitle;

    ImageView arrow;

    CardView cvArrow;

    boolean arrowBool;

    RecyclerView rvList;

    SearchView searchView;


    public static HomeFragment getInstance(/*NewHomeAdapter.HomeAdapterInterface homeInterface*/) {
        HomeFragment f = new HomeFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        
        initUi(view);
        initData();
        initCntrl();

        // Inflate the layout for this fragment
        return view;
    }

    private void initCntrl() {
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrowBool = !arrowBool;
                if (arrowBool){
                    arrow.setImageResource(R.drawable.baseline_arrow_drop_down_24);
                    cvArrow.setVisibility(View.GONE);
                }else{
                    arrow.setImageResource(R.drawable.baseline_arrow_drop_up_24);
                    cvArrow.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private void initData() {

        List<String> dummyData = new ArrayList<>();

        for (int i = 1; i <= 200; i++) {
            dummyData.add("Item " + i);
        }

        rvList.setAdapter(new ListAdapter(dummyData)); // Atur adapter Anda

        headerTitle.setText("JOB LIST");

        arrowBool = true;


    }

    private void initUi(View view) {

//        searchView = view.findViewById(R.id.searchView);

        headerTitle = view.findViewById(R.id.headerTitle);

        arrow = view.findViewById(R.id.ivDown);

        cvArrow = view.findViewById(R.id.cvArrow);
        cvArrow.setVisibility(View.GONE);

        rvList = view.findViewById(R.id.rvList);

        rvList.setLayoutManager(new LinearLayoutManager(getContext())); // Atur tata letak manajer
        

    }
}