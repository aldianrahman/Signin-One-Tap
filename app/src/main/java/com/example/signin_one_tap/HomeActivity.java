package com.example.signin_one_tap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.signin_one_tap.adapter.HomeAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    TabLayout.Tab tab1,tab2;
    ImageButton iconBtn,iconBtn2;

    private ViewPager viewPager;

    TextView tvUsername;

    String email, picUrl, username;

    TextView tvItemHomeButtonTitle,tvItemHomeButtonTitle2;

    private int selectedColor = Color.parseColor("#714F2D");
    private int unselectedColor = Color.parseColor("#FFFFFF");





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUi();
        initData();
        initCntrl();

    }

    private void initCntrl() {


    }

    private void initData() {

        email = getIntent().getExtras().getString("email");
        picUrl = getIntent().getExtras().getString("urlPic");
        username = getIntent().getExtras().getString("username");


//
//        tvUsername.setText(username);

    }

    public String getPic() {
        return picUrl;
    }

    public String getUsername() {
        return username;
    }

    private void initUi() {
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        tab1 = tabLayout.newTab().setCustomView(R.layout.item_home_badge);
        tab2 = tabLayout.newTab().setCustomView(R.layout.item_home_badge);

        iconBtn = tab1.getCustomView().findViewById(R.id.iconBtn);
        tvItemHomeButtonTitle = tab1.getCustomView().findViewById(R.id.tvItemHomeButtonTitle);
        iconBtn.setImageResource(R.drawable.home_buttom_nav);
        tvItemHomeButtonTitle.setText("Home");
        tvItemHomeButtonTitle.setTextColor(unselectedColor);
        iconBtn2 = tab2.getCustomView().findViewById(R.id.iconBtn);

        tvItemHomeButtonTitle2 = tab2.getCustomView().findViewById(R.id.tvItemHomeButtonTitle);
        iconBtn2.setImageResource(R.drawable.profile_buttom_nav);
        tvItemHomeButtonTitle2.setText("Account");
        tvItemHomeButtonTitle2.setTextColor(unselectedColor);

        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        HomeAdapter adapter = new HomeAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}