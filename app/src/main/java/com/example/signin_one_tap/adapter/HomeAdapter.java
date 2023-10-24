package com.example.signin_one_tap.adapter;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.signin_one_tap.fragment.AccountFragment;
import com.example.signin_one_tap.fragment.HomeFragment;

public class HomeAdapter extends FragmentPagerAdapter {

    Context mContext;
    int mTotalTabs;
    private SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public HomeAdapter(Context context , FragmentManager fragmentManager , int totalTabs) {
        super(fragmentManager);
        mContext = context;
        mTotalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("homeAdapter" , position + "");
        if (position == 0) {
            return new HomeFragment();
        }
        return new AccountFragment();
    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);

        //Register fragment so we can call it from activity with the UI in fragment still there (not null)
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    /**
     * Use this if you want to get fragment instance.
     * Example if you want to call a public function in fragment from activity
     * @param position
     * @return
     */
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}