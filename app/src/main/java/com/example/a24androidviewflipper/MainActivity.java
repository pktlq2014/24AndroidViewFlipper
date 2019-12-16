package com.example.a24androidviewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
{
    ViewFlipper viewFlipper;
    Animation in,out;
    Button button1, button2;
    // cách 2 dùng array
    int[] arrayHinh = {R.mipmap.ss1, R.mipmap.ss2, R.mipmap.ss3, R.mipmap.ss4, R.mipmap.god, R.mipmap.blue, R.mipmap.ultra};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = findViewById(R.id.viewFlipper);
        button1 = findViewById(R.id.butTon1);
        button2 = findViewById(R.id.butTon2);


        for(int i = 0; i < arrayHinh.length; i++)
        {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(arrayHinh[i]);
            viewFlipper.addView(imageView);
        }



        in = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        out = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setInAnimation(out);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(viewFlipper.isAutoStart())
                {
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(viewFlipper.isAutoStart())
                {
                    viewFlipper.stopFlipping();
                    viewFlipper.showPrevious();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
    }
}
