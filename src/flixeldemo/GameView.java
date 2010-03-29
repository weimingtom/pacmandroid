package org.mcp.flixeldemo;

import org.flixel.FlxFadeListener;
import org.flixel.FlxFlashListener;
import org.flixel.FlxG;
import org.flixel.FlxGame;
import org.flixel.FlxGameView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameView extends FlxGameView implements SurfaceHolder.Callback
{
 public GameView(Context context, AttributeSet attrs)
 {
  super(
   new FlxGame(320, 455, MenuState.class, context, R.class), 
   context, 
   attrs
  );
  SurfaceHolder holder = getHolder();
  holder.addCallback(this);
  setFocusable(true); // make sure we get key events
  setFocusableInTouchMode(true); // make sure we get touch events
  
 }
 
 public boolean onTouchEvent(MotionEvent event) {
	FlxG.state.onTouchEvent(event);
	return true;
	 
 }

}