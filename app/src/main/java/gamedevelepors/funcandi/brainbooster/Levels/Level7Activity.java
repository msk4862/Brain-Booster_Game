package gamedevelepors.funcandi.brainbooster.Levels;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import gamedevelepors.funcandi.brainbooster.CustomView;
import gamedevelepors.funcandi.brainbooster.R;
import gamedevelepors.funcandi.brainbooster.ShakeListener;

public class Level7Activity extends AppCompatActivity {

    Drawable wrong, right;

    ImageView check, mango, tree;

    Typeface t;

    TextView text;

    CustomView c;

    int x, y;


    ShakeListener mShaker;

    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        x = getResources().getDisplayMetrics().widthPixels;
        y = getResources().getDisplayMetrics().heightPixels;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


        wrong = ContextCompat.getDrawable(this, R.drawable.brain_wrong);
        right = ContextCompat.getDrawable(this, R.drawable.brain_check);

        check = (ImageView) findViewById(R.id.imageView2);



        text = (TextView) findViewById(R.id.textView2);
        mango = (ImageView) findViewById(R.id.imageView6);
        tree = (ImageView) findViewById(R.id.imageView4);

        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                life();
                check.setBackground(wrong);

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(500, check);
            }
        });

        c = (CustomView) findViewById(R.id.custom);

        c.level=7;

        text.setTypeface(t);


        mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake()
            {
                CustomView.game8_CorrectlyAnswered++;

                mShaker.pause();
                loadmainAniamtion();

                check.setBackground(right);

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(900, check);


                i = new Intent(getApplicationContext(), Level8Activity.class);
                startActivity(i);
            }
        });
    }





    public void loadmainAniamtion() {


        ObjectAnimator textAnimator;

            textAnimator = ObjectAnimator.ofFloat(mango, "y", y/2, y-y/5);
            textAnimator.setDuration(1200L);



        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(textAnimator);
        animatorSet.start();
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
