package org.mcp.flixel;

import org.flixel.FlxFadeListener;
import org.flixel.FlxFlashListener;
import org.flixel.FlxG;
import org.mcp.flixel.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class PacDroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //turn off window bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
    }

}