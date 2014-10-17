package game;

import java.awt.Rectangle;

public class Spittle {
	private int x, y, speed;
	private double velocityX, velocityY;

	private boolean visible;

	
	private Rectangle r;

	private final int MOVESPEED = 1;
	private final int MAXSPEED = 60;
	private final int MINSPEED = 1;

	public Spittle(int startX, int startY) {
		x = startX;
		y = startY;
		speed = 7;
		velocityX = 0;
		velocityY = 1;
		visible = true;

		r = new Rectangle(0, 0, 0, 0);
	}

	public void update() {
		velocityY += .4;
		y += velocityY;
		x += velocityX;
		if(r==null)
			r = new Rectangle(0, 0, 0, 0);
		r.setBounds(x, y, 5, 10);
		if (y < 0 ||  y > SpitterGame.HEIGTH || x <0 || x > SpitterGame.WIDTH) {
			visible = false;
			r = null;
		}
		else if (y < 601) {
			checkCollision();
		}

	}

	private void checkCollision() {
		
		if (r.intersects(SpitterGame.nerd.r)) {
			visible = false;
		//	SpitterGame.killNerd();
			
			SpitterGame.nerd.die();
			System.out.println("babeado!");
		}
		 /* 
		 * if (r.intersects(StartingClass.hb2.r)) { visible = false; if
		 * (StartingClass.hb2.health > 0) { StartingClass.hb2.health -= 1; } if
		 * (StartingClass.hb2.health == 0) { StartingClass.hb2.setCenterX(-100);
		 * StartingClass.score += 5;
		 * 
		 * 
		 * }
		 * 
		 * }
		 */
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void increaseSpeed() {
		int s = speed + MOVESPEED;
		if (s <= MAXSPEED)
			setSpeed(s);
	}

	public void decreaseSpeed() {
		int s = speed - MOVESPEED;
		if (s >= MINSPEED)
			setSpeed(s);
	}
}
