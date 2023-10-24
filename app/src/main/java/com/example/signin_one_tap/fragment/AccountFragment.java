package com.example.signin_one_tap.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.signin_one_tap.HomeActivity;
import com.example.signin_one_tap.MainActivity;
import com.example.signin_one_tap.R;
import com.squareup.picasso.Picasso;

public class AccountFragment extends Fragment {

    TextView tvUsername;

    String username,pic;

    ImageView circularImageView;

    Button logout;


    public static AccountFragment getInstance(/*NewHomeAdapter.HomeAdapterInterface homeInterface*/) {
        AccountFragment f = new AccountFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        HomeActivity activity = (HomeActivity) getActivity();
        username = activity != null ? activity.getUsername() : "-";
        pic = activity != null ? activity.getPic() : "";

        initUi(view);
        initData();

        // Inflate the layout for this fragment
        return view;
    }

    private void initData() {


//        assert getArguments() != null;
//        String email = getArguments().getString("email");
//        String pic = getArguments().getString("urlPic");
//        String username = getArguments().getString("username");

        tvUsername.setText(username);

        Picasso.with(getContext())
                .load(pic)
                .fit()
//                .transform(new RoundedTransformation(100))
                .into(circularImageView);
//
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initUi(View view) {
        tvUsername = view.findViewById(R.id.username);
        circularImageView = view.findViewById(R.id.profile_image);
        logout = view.findViewById(R.id.logout);
    }
}