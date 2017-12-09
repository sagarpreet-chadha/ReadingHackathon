package com.example.sagarpreetchadha.canvasapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AlphabetCanvas extends AppCompatActivity {
    public ImageView alp_image;
    public LinearLayout draw_area;
    Bitmap drawn_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_canvas);
        alp_image=(ImageView)findViewById(R.id.alphabet_image);
        draw_area=(LinearLayout)findViewById(R.id.llMain);

        final MyDrawView myDrawView = new MyDrawView(this);
        draw_area.addView(myDrawView);
        draw_area.setDrawingCacheEnabled(true);

        Button redraw=(Button)findViewById(R.id.redraw);
        Button next=(Button)findViewById(R.id.next);

        redraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                draw_area.removeAllViews();
                MyDrawView myDrawView1=new MyDrawView(AlphabetCanvas.this);
                draw_area.addView(myDrawView1);
                draw_area.setDrawingCacheEnabled(true);
                drawn_image=null;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawn_image = draw_area.getDrawingCache();
            }
        });
    }
}
