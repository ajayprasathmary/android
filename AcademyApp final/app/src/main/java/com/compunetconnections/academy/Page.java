package com.compunetconnections.academy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Page extends FragmentStatePagerAdapter {
    int tabCount;
    private String[] tabTitles = new String[]{"UG", "PG"};
    public Page(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }
    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }



    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Pg tab1 = new Pg();
                return tab1;
            case 1:
                Ug tab2 = new Ug();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}