package com.sopan.circle_menu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sopan.circle_menu.R;
import com.sopan.circle_menu.design.CircleMenu;
import com.sopan.circle_menu.interfaces.OnMenuSelectedListener;
import com.sopan.circle_menu.interfaces.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity implements OnMenuSelectedListener, OnMenuStatusChangeListener {

    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_middle_click, R.mipmap.icon_cancel);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.mipmap.icon_home)
                .addSubMenu(Color.parseColor("#30A400"), R.mipmap.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.mipmap.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.mipmap.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.mipmap.icon_gps);
        /*circleMenu.addSubMenu(Color.parseColor("#8077b2a1"), R.drawable.ic_chapter_click)
                .addSubMenu(Color.parseColor("#8043859C"), R.drawable.ic_model_test_click)
                .addSubMenu(Color.parseColor("#80466b69"), R.drawable.ic_ques_bank_click)
                .addSubMenu(Color.parseColor("#80213F87"), R.drawable.ic_help_click);*/

        circleMenu.setOnMenuSelectedListener(this);
        circleMenu.setOnMenuStatusChangeListener(this);

    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

    @Override
    public void onMenuSelected(int index) {
        switch (index) {
            case 0:
                Toast.makeText(MainActivity.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(MainActivity.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "Settings button Clcked", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(MainActivity.this, ThankYouActivity.class));
                break;
            /*case 4:
                Toast.makeText(MainActivity.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                break;  */
        }
    }


    @Override
    public void onMenuOpened() {

    }

    @Override
    public void onMenuClosed() {

    }
}
