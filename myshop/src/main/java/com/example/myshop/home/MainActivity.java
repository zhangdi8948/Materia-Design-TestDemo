package com.example.myshop.home;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.myshop.R;
import com.example.myshop.home.adapter.BarRecyclerAdapter;
import com.example.myshop.home.bean.GoodsModule;
import com.example.myshop.home.bean.ItemBean;
import com.example.myshop.home.adapter.HelperAdapter;
import com.example.myshop.home.adapter.SectionPagerAdapter;
import com.example.myshop.recipes.RecipesActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SectionPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @BindView(R.id.drawer_main)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.main_tab)
    TabLayout tabLayout;
    @BindView(R.id.helper_recycler)
    RecyclerView helperRecycler;
    @BindView(R.id.helper_next)
    RelativeLayout helperNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //设置toolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

        //设置actionbar里的recyclerview
        ArrayList<ItemBean> data = new ArrayList<>();
        data.add(new ItemBean("苹果", R.drawable.apple, "100g - 60cal"));
        data.add(new ItemBean("香蕉", R.drawable.banana, "100g - 60cal"));
        data.add(new ItemBean("樱桃", R.drawable.cherry, "100g - 60cal"));
        data.add(new ItemBean("葡萄", R.drawable.grape, "100g - 60cal"));
        data.add(new ItemBean("芒果", R.drawable.mango, "100g - 60cal"));
        data.add(new ItemBean("橘子", R.drawable.orange, "100g - 60cal"));
        data.add(new ItemBean("梨", R.drawable.pear, "100g - 60cal"));
        data.add(new ItemBean("凤梨", R.drawable.pineapple, "100g - 60cal"));
        data.add(new ItemBean("草莓", R.drawable.strawberry, "100g - 60cal"));

        BarRecyclerAdapter adapter = new BarRecyclerAdapter(data);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        // 设置viewpager
        ArrayList<GoodsModule> goodsModules = new ArrayList<>();
        goodsModules.add(new GoodsModule("Fruits", data));
        goodsModules.add(new GoodsModule("Vegetable", data));
        goodsModules.add(new GoodsModule("Grains", data));
        goodsModules.add(new GoodsModule("Daily", data));
        mSectionsPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(), goodsModules);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //将viewpager的标题显示在tab上
        tabLayout.setupWithViewPager(mViewPager);

        //设置helper菜单里的recyclerview
        LinearLayoutManager helperManager = new LinearLayoutManager(this);
        helperRecycler.setLayoutManager(helperManager);
        ArrayList<String> helperData = new ArrayList<>();
        helperData.add("Avocado");
        helperData.add("Bread");
        helperData.add("Egg");
        helperData.add("Spinach");
        HelperAdapter helperAdapter = new HelperAdapter(helperData);
        helperRecycler.setAdapter(helperAdapter);

        //帮助菜单里的next按钮点击事件
        helperNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.closeDrawers();
                startActivity(new Intent(MainActivity.this, RecipesActivity.class));
            }
        });
    }


    //设置actionbar菜单布局
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_end_menu, menu);
        return true;
    }

    //设置actionbar菜单按钮点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.helper:
                drawerLayout.openDrawer(GravityCompat.END);
                return true;
            case android.R.id.home:

                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
