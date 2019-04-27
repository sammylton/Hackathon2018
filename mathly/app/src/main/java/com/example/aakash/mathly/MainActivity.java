package com.example.aakash.mathly;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static List<String> HistoryList = new ArrayList<String>();
    TextView resu09;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        resu09 = (TextView) findViewById(R.id.textViw3);
        resu09.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, History.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, About.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_gcd) {
            startActivity(new Intent(MainActivity.this, gcd.class));
        } else if (id == R.id.nav_factors) {
            startActivity(new Intent(MainActivity.this, factors.class));
        } else if (id == R.id.nav_prime) {
            startActivity(new Intent(MainActivity.this, Prime.class));
        } else if (id == R.id.nav_modularexpo) {
            startActivity(new Intent(MainActivity.this, modularexpo.class));
        } else if (id == R.id.nav_modularmultinver) {
            startActivity(new Intent(MainActivity.this, modularmultinverse.class));
        } else if (id == R.id.nav_calculator) {
            Intent inte = new Intent();
            inte.setAction(Intent.ACTION_MAIN);
            inte.addCategory(Intent.CATEGORY_APP_CALCULATOR);
            inte.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(inte);
        } else if (id == R.id.nav_bigfactorial) {
            startActivity(new Intent(MainActivity.this, BigFactorial.class));
        }
        else if (id == R.id.nav_nCr) {
            startActivity(new Intent(MainActivity.this, nCr.class));
        }else if (id == R.id.nav_fibonacci) {
            startActivity(new Intent(MainActivity.this, checkfibonacci.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
