package com.example.myshop.recipe_detail;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myshop.R;
import com.example.myshop.common.MyCircleImageView;
import com.example.myshop.home.bean.ItemBean;
import com.example.myshop.recipe_detail.adapter.IngredientsAdapter;
import com.example.myshop.recipe_detail.adapter.RecipeAdapter;
import com.example.myshop.recipes.bean.RecipesBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecipesDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recipes_iv)
    MyCircleImageView circleImageView;
    @BindView(R.id.recipes_m)
    TextView recipesM;
    @BindView(R.id.recipes_cal)
    TextView recipesCal;
    @BindView(R.id.recipes_per)
    TextView recipesPer;
    @BindView(R.id.detail_ingredients_recycler)
    RecyclerView ingredients;
    @BindView(R.id.detail_recipe_recycler)
    RecyclerView recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_detail);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setEnterTransition(new Slide(Gravity.START));
        }

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        RecipesBean bean = getIntent().getParcelableExtra("bean");

        if (null != actionBar) {
            actionBar.setTitle(bean.getName());
        }

        Glide.with(this)
                .load(bean.getImage())
                .override(500, 500)
                .into(circleImageView);

        recipesM.setText(bean.getM());
        recipesCal.setText(bean.getCal());
        recipesPer.setText(bean.getPer());

        LinearLayoutManager verticalManager = new LinearLayoutManager(this);
        RecipeAdapter recipesAdapter = new RecipeAdapter();
        recipe.setLayoutManager(verticalManager);
        recipe.setAdapter(recipesAdapter);

        ArrayList<ItemBean> data = new ArrayList<>();
        data.add(new ItemBean("苹果", R.drawable.apple, "100g - 60cal"));
        data.add(new ItemBean("香蕉", R.drawable.banana, "100g - 60cal"));
        data.add(new ItemBean("樱桃", R.drawable.cherry, "100g - 60cal"));
        data.add(new ItemBean("葡萄", R.drawable.grape, "100g - 60cal"));
        data.add(new ItemBean("芒果", R.drawable.mango, "100g - 60cal"));
        LinearLayoutManager horizontalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(data);
        ingredients.setLayoutManager(horizontalManager);
        ingredients.setAdapter(ingredientsAdapter);
    }

    @OnClick(R.id.recipes_next)
    public void next(View view) {

        if (Build.VERSION.SDK_INT >= 21) {
            finishAfterTransition();
        } else {
            finish();
        }
    }
}
