package cs301.birthdaycake;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener{

    private CakeView currCakeView;
    private CakeModel currCakeModel;

    public CakeController(CakeView cakeview){
        this.currCakeView = cakeview;
        this.currCakeModel = cakeview.getCakeModel();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View button) {
        Log.d("Button","Button id: " + button.getId());
        int buttonID = button.getId();
        switch(buttonID){

            case R.id.button:
                currCakeModel.areCandlesLit = false;
                currCakeView.invalidate();
                break;

            case R.id.relight_button:
                currCakeModel.areCandlesLit = true;
                currCakeView.invalidate();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("Compound Button","State Changed; id: " + compoundButton.getId() + ", new state: " + b);

        switch(compoundButton.getId()){
            case R.id.candles_switch:
                currCakeModel.hasCandles = b;
                currCakeView.invalidate();
                break;

            case R.id.frosting_switch:
                currCakeModel.hasFrosting = b;
                currCakeView.invalidate();
                break;

        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("Number of Candles Bar", "Current Candles: " + i);
        currCakeModel.numCandles = i;
        currCakeView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
