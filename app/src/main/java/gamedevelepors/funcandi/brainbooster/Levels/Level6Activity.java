package gamedevelepors.funcandi.brainbooster.Levels;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gamedevelepors.funcandi.brainbooster.CustomView;
import gamedevelepors.funcandi.brainbooster.R;

public class Level6Activity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8;

    Drawable wrong, right;

    ImageView check;

    Typeface t;

    TextView text;

    CustomView c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level6);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


        wrong = ContextCompat.getDrawable(this, R.drawable.brain_wrong);
        right = ContextCompat.getDrawable(this, R.drawable.brain_check);

        check = (ImageView) findViewById(R.id.imageView2);

        b1 = (Button) findViewById(R.id.button6);
        b2 = (Button) findViewById(R.id.button7);
        b3 = (Button) findViewById(R.id.button8);
        b4 = (Button) findViewById(R.id.button9);
        b5 = (Button) findViewById(R.id.button10);
        b6 = (Button) findViewById(R.id.button11);
        b7 = (Button) findViewById(R.id.button12);
        b8 = (Button) findViewById(R.id.button13);

        text = (TextView) findViewById(R.id.textView2);
        c = (CustomView) findViewById(R.id.custom);

        c.level=6;

        text.setTypeface(t);
        b1.setTypeface(t);
        b2.setTypeface(t);
        b3.setTypeface(t);
        b4.setTypeface(t);
        b5.setTypeface(t);
        b6.setTypeface(t);
        b7.setTypeface(t);
        b8.setTypeface(t);



    }

    public void Bclicked(View v) {
        life();
        check.setBackground(wrong);

        check.setVisibility(View.VISIBLE);
        timerDelayRemoveView(500, check);
    }

    public void Textclicked(View v){

        check.setBackground(right);

        CustomView.game8_CorrectlyAnswered++;

        check.setVisibility(View.VISIBLE);
        timerDelayRemoveView(800, check);

        Intent i = new Intent(this, Level7Activity.class);
        startActivity(i);

    }



    public void timerDelayRemoveView(long time, final ImageView img) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                img.setVisibility(View.GONE);
            }
        }, time);
    }

    public  void life(){
        if (c.life>0)
            c.life-=1;
        c.invalidate();
    }
}
