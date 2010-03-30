package org.mcp.flixeldemo;

import java.util.ArrayList;

import org.flixel.FlxBlock;
import org.flixel.FlxG;
import org.flixel.FlxState;
import org.flixel.FlxText;

import android.inputmethodservice.Keyboard.Key;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class PlayState extends FlxState{

	protected ArrayList levelBlocks = new ArrayList();
	protected Player player = null;
	
	public PlayState() {
		// TODO Auto-generated constructor stub
		  super();
		  //add(new FlxText(10, 10, 100, "Dentro do Jogo!"));
		  FlxBlock ground = new FlxBlock(0, 640-16, 640, 16);
		  ground.loadGraphic(R.drawable.transparent);
		  //ground.loadGraphic(R.drawable.tech_tiles);
		  levelBlocks.add(this.add(ground));
		  player = new Player();
		  this.add(player);
		  FlxG.follow(player, 2.5f); // camera
		  FlxG.followAdjust(0.5f, 0.0f);
		  FlxG.followBounds(0, 0, 640, 640);
		  FlxG.playMusic(R.raw.mode);

		  
	}
	
	public void update()
	 {
	  super.update();
	  FlxG.collideArrayList(levelBlocks, player);
	 }
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int key = KeyEvent.KEYCODE_DPAD_UP;
		float x =event.getX(); 
		float y =event.getY();
		
		if(x < FlxG.width/3){
			key = KeyEvent.KEYCODE_DPAD_LEFT;
		}
		else if(x > 2*FlxG.width/3){
			key = KeyEvent.KEYCODE_DPAD_RIGHT;
		}
		else if(x < 2*FlxG.width/3 && y < FlxG.height/2) {
			key = KeyEvent.KEYCODE_DPAD_UP;
		}
		else if(x < 2*FlxG.width/3 && y > FlxG.height/2) {
			key = KeyEvent.KEYCODE_DPAD_DOWN;
		}
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			FlxG.keys.handleKeyDown(key);
			break;
		case MotionEvent.ACTION_UP:
			FlxG.keys.handleKeyUp(KeyEvent.KEYCODE_DPAD_LEFT);
			FlxG.keys.handleKeyUp(KeyEvent.KEYCODE_DPAD_RIGHT);
			FlxG.keys.handleKeyUp(KeyEvent.KEYCODE_DPAD_UP);
			FlxG.keys.handleKeyUp(KeyEvent.KEYCODE_DPAD_DOWN);
			break;
			
		}
		return true;
	}

}
