package org.mcp.flixeldemo;

import java.util.ArrayList;

import org.flixel.FlxBlock;
import org.flixel.FlxG;
import org.flixel.FlxSprite;
import org.flixel.FlxState;
import org.flixel.FlxText;

import android.inputmethodservice.Keyboard.Key;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class PlayState extends FlxState{

	protected ArrayList levelBlocks = new ArrayList();
	protected Player player = null;
	protected Enemy red_ghost = null;
	protected FlxSprite arrow_up, arrow_down,arrow_right,arrow_left;
	protected ArrayList enemies = new ArrayList();
	
	public PlayState() {
		// TODO Auto-generated constructor stub
		  super();
		  //add(new FlxText(10, 10, 100, "Dentro do Jogo!"));

		  FlxSprite level = new FlxSprite(0,20);
		  level.loadGraphic(R.drawable.pacman_level_352x320, false);
		  this.add(level);
		  
		  addLevelBlocks();
		  player = new Player();
		  this.add(player);
		  
		  addEnemies();
		  addControls();
		  
		  /*FlxG.follow(player, 2.5f); // camera
		  FlxG.followAdjust(0.5f, 0.0f);
		  FlxG.followBounds(0, 0, 640, 640);*/
		  FlxG.playMusic(R.raw.mode);

		  
	}
	
	private void addLevelBlocks() {
		FlxBlock block, b2, b3;
		FlxBlock title_bar = new FlxBlock(0, 0, 320, 32);
		//ground.loadGraphic(R.drawable.transparent);
		title_bar.loadGraphic(R.drawable.tech_tiles);
		levelBlocks.add(this.add(title_bar));
		
		block= new FlxBlock(0, 0, 29, 145);
		block.loadGraphic(R.drawable.tech_tiles);
		levelBlocks.add(this.add(block));
		
		block= new FlxBlock(307, 0, 13, 145);
		block.loadGraphic(R.drawable.tech_tiles);
		levelBlocks.add(this.add(block));
		
		block= new FlxBlock(152, 30, 16, 53);
		block.loadGraphic(R.drawable.tech_tiles);
		levelBlocks.add(this.add(block));
		
		
		
	}

	private void addEnemies() {
		// TODO Auto-generated method stub
		red_ghost = new Enemy();
		this.add(red_ghost);
		enemies.add(red_ghost);
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		arrow_up = new FlxSprite(FlxG.width/2-20,340);
		arrow_up.loadGraphic(R.drawable.arrow_up, false);
		arrow_up.setAlpha((float)0.7);
		this.add(arrow_up);
		
		arrow_down = new FlxSprite(FlxG.width/2-20,400);
		arrow_down.loadGraphic(R.drawable.arrow_down, false);
		arrow_down.setAlpha((float)0.7);
		this.add(arrow_down);
		
		arrow_right = new FlxSprite(FlxG.width/2+30,370);
		arrow_right.loadGraphic(R.drawable.arrow_right, false);
		arrow_right.setAlpha((float)0.7);
		this.add(arrow_right);
		
		arrow_left = new FlxSprite(FlxG.width/2-70,370);
		arrow_left.loadGraphic(R.drawable.arrow_left, false);
		arrow_left.setAlpha((float)0.7);
		this.add(arrow_left);
	}

	public void update()
	 {
	  super.update();
	  FlxG.overlapArrayList(enemies, player);
	  FlxG.collideArrayList(levelBlocks, player);
	 }
	
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int key = KeyEvent.KEYCODE_DPAD_UP;
		float x =event.getX(); 
		float y =event.getY();
		
		if(x < FlxG.width/2 - 40){
			key = KeyEvent.KEYCODE_DPAD_LEFT;
			arrow_left.setAlpha((float)1);
			
		}
		else if(x > FlxG.width/2 + 40){
			key = KeyEvent.KEYCODE_DPAD_RIGHT;
			arrow_right.setAlpha((float)1);
		}
		else if(y < arrow_down.y) {
			key = KeyEvent.KEYCODE_DPAD_UP;
			arrow_up.setAlpha((float)1);
		}
		else if(y > arrow_down.y) {
			key = KeyEvent.KEYCODE_DPAD_DOWN;
			arrow_down.setAlpha((float)1);
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
			arrow_up.setAlpha((float)0.7);
			arrow_down.setAlpha((float)0.7);
			arrow_left.setAlpha((float)0.7);
			arrow_right.setAlpha((float)0.7);
			break;
			
		}
		return true;
	}

}
