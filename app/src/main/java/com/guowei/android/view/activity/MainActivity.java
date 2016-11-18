package com.guowei.android.view.activity;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import android.widget.Toast;
import com.guowei.android.R;
import com.guowei.android.base.MyBaseAppActivity;


import com.guowei.android.presenter.activityPresenter.MainActivityPresenter;
import com.guowei.android.presenter.RequiresPresenter;
import com.guowei.android.widght.MaterialSearchView;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

@RequiresPresenter(MainActivityPresenter.class)
public class MainActivity extends MyBaseAppActivity<MainActivityPresenter> implements NavigationView.OnNavigationItemSelectedListener{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.search_view)
    MaterialSearchView searchView;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewpager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //设置侧滑及侧滑监听
        setDrawLayout();
        initSubmit();
        /*AndroidBean androidBean = new AndroidBean();
        androidBean.setArticle_author("zhou12314");
        androidBean.setArticle_name("222222222");
        initSerarchView();
        androidBean.setArticle_star(8);
        androidBean.setArticleUrl("http://blog.csdn.net/zhou12314");
        androidBean.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this,"添加数据成功，返回objectId为：",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"添加数据失败，返回objectId为：",Toast.LENGTH_LONG).show();
                }
            }
        });
        BmobQuery<AndroidBean> beanBmobQuery = new BmobQuery<>();
        beanBmobQuery.order("-createdAt");
                beanBmobQuery.findObjects(new FindListener<AndroidBean>() {
                    @Override
                    public void done(List<AndroidBean> list, BmobException e) {
                        if(e == null){
                            List<AndroidBean>  androidBeanList = list;
                            Toast.makeText(MainActivity.this,"获取数据成功，返回objectId为：",Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this,"获取数据失败，返回objectId为：",Toast.LENGTH_LONG).show();
                        }
            }
        });*/
      /*  androidBean.save(new SaveListener() {
           @Override
            public void done(String s, BmobException e) {
            }
        });*/
    }

    @OnClick(R.id.fab)
    public   void clickFab(){
        Intent intent = new Intent(this,CommitActivity.class);
        startActivity(intent);

    }

    private void initSubmit() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("flag",i+"");

                if(i!=0){
                    fab.hide();
                }else{
                    fab.show();
                }
            }
        });
    }

    private void initSerarchView() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                /**
                 * 当点击搜索的时候执行以下操作
                 */
                Toast.makeText(MainActivity.this,query,Toast.LENGTH_LONG).show();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this,newText,Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private void setDrawLayout() {
        /**
         * ActionBarDrawerToggle  是 DrawerLayout.DrawerListener实现。
         和 NavigationDrawer 搭配使用，推荐用这个方法，符合Android design规范。
         作用：
         1.改变android.R.id.home返回图标。
         2.Drawer拉出、隐藏，带有android.R.id.home动画效果。
         3.监听Drawer拉出、隐藏；
         */
        ActionBarDrawerToggle togger = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(togger);
        togger.syncState();
        navigationView.setNavigationItemSelectedListener(this);

}


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case  R.id.nav_main:
                break;
            case  R.id.nav_search:
                searchView.showSearch();
                break;
            case  R.id.nav_setting:
                break;
            case  R.id.nav_share:
                break;
            case  R.id.nav_send:

                break;

            case  R.id.nav_user:

                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else if(searchView.isSearchOpen()){
            searchView.closeSearch();
        }else {
            super.onBackPressed();
        }

    }
    public ViewPager getViewPager(){
        return  viewpager;
    }
    public  TabLayout getTabLayout(){
        return  tabLayout;
    }
}
