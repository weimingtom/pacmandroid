package org.mcp.flixeldemo;

import java.util.ArrayList;
import java.util.Arrays;
import android.view.*;

import org.flixel.*;

public class Player extends FlxSprite {

	protected static final int PLAYER_START_X = 300;
	 protected static final int PLAYER_START_Y = 300;
	 protected static final int PLAYER_RUN_SPEED = 80;
	 protected static final float GRAVITY_ACCELERATION = 420;
	 protected static final float JUMP_ACCELERATION = 200;
	 
	public Player() {
		// TODO Auto-generated constructor stub
		super(PLAYER_START_X, PLAYER_START_Y, R.drawable.spaceman, true);

		drag.x = PLAYER_RUN_SPEED * 8;
		acceleration.y = GRAVITY_ACCELERATION;
		maxVelocity.x = PLAYER_RUN_SPEED;
		maxVelocity.y = JUMP_ACCELERATION;
		
		
		addAnimation("idle", new ArrayList(Arrays.asList(new Integer[] {0})));
		addAnimation("run",  new ArrayList(Arrays.asList(new Integer[] {1, 2, 3, 0})), 12);
		addAnimation("jump",  new ArrayList(Arrays.asList(new Integer[] {4})));
		addAnimation("idle_up",  new ArrayList(Arrays.asList(new Integer[] {5})));
		addAnimation("run_up",  new ArrayList(Arrays.asList(new Integer[] {6, 7, 8, 5})), 12);
		addAnimation("jump_up",  new ArrayList(Arrays.asList(new Integer[] {9})));
		addAnimation("jump_down",  new ArrayList(Arrays.asList(new Integer[] {10})));
		
		
	}
	
	public void update()
	 {
	  acceleration.x = 0;
	  if(FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_LEFT))
	  {
	   setFacing(LEFT);
	   acceleration.x = -drag.x;
	  }
	  else if(FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_RIGHT))
	  {
	   setFacing(RIGHT);
	   acceleration.x = drag.x;
	  }
	  if((FlxG.keys.justPressed(KeyEvent.KEYCODE_DPAD_UP) || FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_CENTER) ) && velocity.y==0)
	  {
	   velocity.y = -JUMP_ACCELERATION;
	  }

	  //animações
	  if(velocity.y != 0)
	  {
	   play("jump");
	  }
	  else if(velocity.x == 0)
	  {
	   play("idle");
	  }
	  else
	  {
	   play("run");
	  }
	  
	  super.update();
	 }

	
}
