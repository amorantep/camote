package game;

import java.awt.Rectangle;

public class Person {

	private int power, speedX =1, centerX, centerY;
	private Background bg = SpitterGame.getBg1();

	public Rectangle r = new Rectangle(0, 0, 0, 0);
	public int health = 5;
	
	// Behavioral Methods
	public void update() {
		centerX += speedX;
		//speedX = speedX -1;
		r.setBounds(centerX - 25, centerY - 25, 50, 60);

		if(centerX<0 || centerX>400)
			speedX *= -1;
		
		/*
		 * if (r.intersects(Robot.yellowRed)){ checkCollision(); }
		 */
	}

	private void checkCollision() {
		/*
		 * if (r.intersects(Spitter.rect) || r.intersects(Spitter.rect2) ||
		 * r.intersects(Robot.rect3) || r.intersects(Robot.rect4)){
		 * System.out.println("collision");
		 * 
		 * }
		 */
	}

	public void die() {

	}

	public void attack() {

	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}
}
