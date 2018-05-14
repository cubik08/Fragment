package e.subsh.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;

import java.util.ArrayList;

import e.subsh.fragment.Fragments.Fragment1;
import e.subsh.fragment.Fragments.Fragment2;
import e.subsh.fragment.Fragments.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tableLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.mitoolbar);
        tableLayout = findViewById(R.id.miTableLayaout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> Agregarfragments()
    {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),Agregarfragments()));
        tableLayout.setupWithViewPager(viewPager);
    }
}
