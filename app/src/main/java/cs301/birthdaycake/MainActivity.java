package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView currCake = findViewById(R.id.cakeview);
        CakeController currCakeController = new CakeController(currCake);

        Button blowoutButton = findViewById(R.id.button);
        blowoutButton.setOnClickListener(currCakeController);

        Button relightButton = findViewById(R.id.relight_button);
        relightButton.setOnClickListener(currCakeController);

        CompoundButton candlesButton = findViewById(R.id.candles_switch);
        candlesButton.setOnCheckedChangeListener(currCakeController);

        CompoundButton frostingButton = findViewById(R.id.frosting_switch);
        frostingButton.setOnCheckedChangeListener(currCakeController);

        SeekBar numCandlesBar = findViewById(R.id.candles_bar);
        numCandlesBar.setOnSeekBarChangeListener(currCakeController);
    }

    public void goodbye(View button){
        Log.i("button","Goodbye");
        finishAffinity();
    }
}
