package org.mcp.flixel;

import org.flixel.*;

import android.content.Context;
import android.graphics.Paint.Align;
import android.test.TouchUtils;
import android.text.method.Touch;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuState extends FlxState implements TouchInterpreter {
	public MenuState()
	 {
	  super();
	  //add(new FlxText(10, 10, 100, "Hello World!"));
	  FlxText txt = new FlxText(0, (FlxG.width / 2) - 80, FlxG.width, "PacmanDroid");
		txt.setFormat(null,16,0xFFFFFFFF, Align.CENTER);
		this.add(txt);
		

		txt = new FlxText(0, FlxG.height  -24, FlxG.width, "TOUCH THE SCREEN TO START");
		txt.setFormat(null, 8, 0xFFFFFFFF, Align.CENTER);
		this.add(txt);
      }
	
      public void update()
      {
    	  super.update();
          if (FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_CENTER))
          {
             changeToPlayState();
          }
          
      }
      
      public void changeToPlayState(){
    	  FlxG.flash(0xffffffff);//, (float) 0.75,  new FlxFlashListener() {}, true);
          FlxFadeListener onFade = new FlxFadeListener() {
			
			@Override
			public void fadeComplete() {
				// TODO Auto-generated method stub
				FlxG.switchState(PlayState.class);
			}
		};
          FlxG.fade(0xff000000, 1, onFade);  
          
      }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		changeToPlayState();
		return true;
	}

      

      
}
