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
		super(PLAYER_START_X, PLAYER_START_Y, R.drawable.player, true);

		drag.x = PLAYER_RUN_SPEED * 8;
		drag.y = drag.x;
		acceleration.y = 0;
		//acceleration.y = GRAVITY_ACCELERATION;
		maxVelocity.x = PLAYER_RUN_SPEED;
		maxVelocity.y = PLAYER_RUN_SPEED;
		
		
		addAnimation("idle", new ArrayList(Arrays.asList(new Integer[] {4})));
		addAnimation("run",  new ArrayList(Arrays.asList(new Integer[] {3,4,5})), 12);
		addAnimation("jump",  new ArrayList(Arrays.asList(new Integer[] {4})));
		addAnimation("idle_up",  new ArrayList(Arrays.asList(new Integer[] {5})));
		addAnimation("run_up",  new ArrayList(Arrays.asList(new Integer[] {0,1,2})), 12);
		addAnimation("run_down",  new ArrayList(Arrays.asList(new Integer[] {6,7,8})), 12);
		addAnimation("jump_up",  new ArrayList(Arrays.asList(new Integer[] {9})));
		addAnimation("jump_down",  new ArrayList(Arrays.asList(new Integer[] {10})));
		
		
	}
	
	public void update()
	 {
	  acceleration.x = 0;
	  if(FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_LEFT))
	  {
	   setFacing(LEFT);
	   velocity.x = -PLAYER_RUN_SPEED;
	   velocity.y = 0;
	   play("run");
	   
	  }
	  else if(FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_RIGHT))
	  {
	   setFacing(RIGHT);
	   velocity.x = PLAYER_RUN_SPEED;
	   velocity.y = 0;
	   play("run");
	  } 
	  else if((FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_UP) || FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_CENTER) ))
	  {
		   velocity.y = -PLAYER_RUN_SPEED;
		   velocity.x = 0;
		  play("run_up");
	   //velocity.y = -JUMP_ACCELERATION;
	  }
	  else if(FlxG.keys.pressed(KeyEvent.KEYCODE_DPAD_DOWN))
	  {
		  velocity.y = PLAYER_RUN_SPEED;
		  velocity.x = 0;
		  play("run_down");
	  }
	  
	  

	  /*
	  //animações
	  if(velocity.y > 0)
	  {
		  play("run_down");
	  }
	  else if (velocity.y < 0)
	  {
		  play("run_up");
	  }
	  else if(velocity.x == 0)
	  {
		  play("idle");
	  }
	  else
	  {
		  play("run");
	  }*/
	  
	  if(velocity.x == 0 && velocity.y == 0)
	  {
		  play("idle");
	  }
	  
	  super.update();
	 }

	
}
