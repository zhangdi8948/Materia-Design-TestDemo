package com.example.myshop.recipes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myshop.R;
import com.example.myshop.recipe_detail.RecipesDetailActivity;
import com.example.myshop.recipes.adapter.RecipesAdapter;
import com.example.myshop.recipes.bean.RecipesBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipesActivity extends AppCompatActivity {

    @BindView(R.id.recipes_toolbar)
    Toolbar toolbar;
    @BindView(R.id.recipes_viewpager)
    ViewPager viewPager;
    @BindView(R.id.recipes_next)
    ImageView next;
    private ArrayList<RecipesBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.back);
        }

        //设置viewpager
        data = new ArrayList<>();
        data.add(new RecipesBean("Eggy Guacamole",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554701360656&di=6a458754c72f32b7c337e8196d68095a&imgtype=0&src=http%3A%2F%2Fmmbiz.qpic.cn%2Fmmbiz_jpg%2FmM7XbTJQKJWYBKkIVyMkicbby2Exac2G0nOeLzCuNI5QuYlj0VopvX6NbHzHT5grkX6CKTd9WSRlgABYkGl91Hg%2F0%3Fwx_fmt%3Djpeg", "You've got all the ingredients!",
                "25 m", "200 cal", "4 per"));
        data.add(new RecipesBean("Lemon Steak",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554701406424&di=5672d4f665922b8a51db06b3b1e665ec&imgtype=0&src=http%3A%2F%2Fwww.ahstatic.com%2Fphotos%2Fa555_rs_05_p_2048x1536.jpg", "You've got all the ingredients!",
                "25 m", "200 cal", "4 per"));
        data.add(new RecipesBean("Fruit Salad",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554701476547&di=615bad9170309ae995fefa5173c18e79&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2Ffd%2Ftg%2Fg6%2FM01%2FB5%2FA9%2FCggYs1b4vnWAPKOUABrt8udtFsQ623.jpg", "You've got all the ingredients!",
                "25 m", "200 cal", "4 per"));
        data.add(new RecipesBean("Vegetable sausage",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554701555323&di=dbbee099ba07f2000e51acf122ee7b17&imgtype=0&src=http%3A%2F%2Fp1.ifengimg.com%2Ffck%2F2018_16%2F572567415ff4e3a_w1080_h720.jpg", "You've got all the ingredients!",
                "25 m", "200 cal", "4 per"));
        data.add(new RecipesBean("Salmon Salad",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554701573409&di=0bded16e6e729f14d535208dfa1c2bb4&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161130%2F502ea61694a041459cfb5ac9982ee6af_th.jpg", "You've got all the ingredients!",
                "25 m", "200 cal", "4 per"));

        RecipesAdapter adapter = new RecipesAdapter(data);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(50);
        viewPager.setPageTransformer(true, new ScalePageTransformer(){

            TextView name, have, m, cal, per;

            @Override
            public void before(View view) {

                name = view.findViewById(R.id.recipes_name);
                name.setAlpha(0);
                have = view.findViewById(R.id.recipes_have);
                have.setAlpha(0);
                m = view.findViewById(R.id.recipes_m);
                m.setAlpha(0);
                cal = view.findViewById(R.id.recipes_cal);
                cal.setAlpha(0);
                per = view.findViewById(R.id.recipes_per);
                per.setAlpha(0);
            }

            @Override
            public void currentPosition() {

                name.setAlpha(1);
                have.setAlpha(1);
                m.animate().alpha(1).setDuration(1000).start();
                cal.animate().alpha(1).setDuration(1000).start();
                per.animate().alpha(1).setDuration(1000).start();
            }
        });

        viewPager.setAdapter(adapter);
    }

    @OnClick(R.id.recipes_next)
    public void next(View next) {

        Intent intent = new Intent(this, RecipesDetailActivity.class);
        int position = viewPager.getCurrentItem();
        RecipesBean bean = data.get(position);
        intent.putExtra("bean", bean);
        View layout = (View) viewPager.getAdapter().instantiateItem(viewPager, position);
        TextView m = layout.findViewById(R.id.recipes_m);
        TextView cal = layout.findViewById(R.id.recipes_cal);
        TextView per = layout.findViewById(R.id.recipes_per);
        ImageView iv = layout.findViewById(R.id.recipes_iv);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<View, String>(m, "recipesM"),
                new Pair<View, String>(cal, "recipesCal"),
                new Pair<View, String>(per, "recipesPer"),
                new Pair<View, String>(next, "recipesNext"),
                new Pair<View, String>(iv, "recipesIv")
        );
        startActivity(intent, optionsCompat.toBundle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_end_menu, menu);
        menu.getItem(0).setIcon(R.drawable.menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
