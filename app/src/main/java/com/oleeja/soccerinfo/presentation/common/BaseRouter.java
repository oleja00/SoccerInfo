package com.oleeja.soccerinfo.presentation.common;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BaseRouter {

    private FragmentManager mFragmentManager;

    public BaseRouter(AppCompatActivity activity) {
        mFragmentManager = activity.getSupportFragmentManager();
    }

    protected void addFragment(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .add(viewGroupId, fragment, tag)
                .commitAllowingStateLoss();
    }

    protected void addFragmentWithBackStack(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .addToBackStack(tag)
                .add(viewGroupId, fragment, tag)
                .commitAllowingStateLoss();
    }
    protected void replaceFragmentWithBackStack(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .replace(viewGroupId, fragment)
                .addToBackStack(tag)
                .commit();
    }
    protected void replaceFragment(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .replace(viewGroupId, fragment, tag)
                .commit();
    }

    protected void addFragment(int viewGroupId, @NonNull BaseFragment fragment, String tag, Pair<View, String> p ) {
        mFragmentManager
                .beginTransaction()
                .add(viewGroupId, fragment, tag)
                .addSharedElement(p.first, p.second)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

}
