package gamedevelepors.funcandi.brainbooster;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import gamedevelepors.funcandi.brainbooster.Levels.Level1Activity;

public class MainActivity extends AppCompatActivity {

    Typeface t;
    TextView title, sbt;
    Button b;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        CustomView c=new CustomView(this);
        c.life=3;
        CustomView.game8_CorrectlyAnswered++;

        i = new Intent(this, Level1Activity.class);

        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");

        title = (TextView) findViewById(R.id.textView);
        sbt = (TextView) findViewById(R.id.textView4);
        b = (Button) findViewById(R.id.button);

        title.setTypeface(t);
        sbt.setTypeface(t);

        b.setTypeface(t);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });



    }
}
