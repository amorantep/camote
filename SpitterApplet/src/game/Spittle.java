package game;

import java.awt.Rectangle;

public class Spittle {
	private int x, y, speedX;
	private boolean visible;

	private Rectangle r;

	private final int MOVESPEED = 1;
	private final int MAXSPEED = 60;
	private final int MINSPEED = 1;

	public Spittle(int startX, int startY) {
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;

		r = new Rectangle(0, 0, 0, 0);
	}

	public void update() {
		y += speedX;
		if(r==null)
			r = new Rectangle(0, 0, 0, 0);
		r.setBounds(x, y, 5, 10);
		if (y > 600) {
			visible = false;
			r = null;
		}
		if (y < 601) {
			checkCollision();
		}

	}

	private void checkCollision() {
		/*
		 * if (r.intersects(StartingClass.hb.r)) { visible = false; if
		 * (StartingClass.hb.health > 0) { StartingClass.hb.health -= 1; } if
		 * (StartingClass.hb.health == 0) { StartingClass.hb.setCenterX(-100);
		 * StartingClass.score += 5;
		 * 
		 * 
		 * } }
		 * 
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

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void increaseSpeed() {
		int s = speedX + MOVESPEED;
		if (s <= MAXSPEED)
			setSpeedX(s);
	}

	public void decreaseSpeed() {
		int s = speedX - MOVESPEED;
		if (s >= MINSPEED)
		setSpeedX(s);
	}
}
