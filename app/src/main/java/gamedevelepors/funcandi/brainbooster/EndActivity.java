package gamedevelepors.funcandi.brainbooster;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import gamedevelepors.funcandi.brainbooster.Levels.Level6Activity;

public class EndActivity extends AppCompatActivity implements View.OnClickListener{

    Button b, exit;
    Typeface t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


        b = (Button) findViewById(R.id.button14);
        exit = (Button) findViewById(R.id.button15);

        b.setTypeface(t);
        exit.setTypeface(t);

        b.setOnClickListener(this);
        exit.setOnClickListener(this);

        //Toast.makeText(getApplicationContext(), "S" + CustomView.score, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button14) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

//$$$$$$$$$$$$$$$$$$$$$$$$$$   EXIT  $$$$$$$$$$$$$$$$$$$$$$
        else if (v.getId() == R.id.button15) {
            // code for exit button
        }
    }
}
