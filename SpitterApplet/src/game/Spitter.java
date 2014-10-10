package game;

import java.util.ArrayList;

public class Spitter {
	private int centerX = 175;
	private int centerY = 50;
	private boolean jumped = false;

	private int speedX = 0;
	private int speedY = 1;
	
	private boolean readyToFire = false;

	
	ArrayList<Spittle> spittles = new ArrayList<Spittle>();
	public void update() {

		// Moves Character or Scrolls Background accordingly.
	/*	if (speedX < 0) {
			centerX += speedX;
		} else if (speedX == 0) {
			System.out.println("Do not scroll the background.");

		} else {
			if (centerX <= 150) {
				centerX += speedX;
			} else {
				System.out.println("Scroll Background Here");
			}
		}

		// Updates Y Position

		if (centerY + speedY >= 382) {
			centerY = 382;
		} else {
			centerY += speedY;
		}

		// Handles Jumping
		if (jumped == true) {
			speedY += 1;

			if (centerY + speedY >= 382) {
				centerY = 382;
				speedY = 0;
				jumped = false;
			}

		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}*/
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void moveRight() {
		speedX = 6;
	}

	public void moveLeft() {
		speedX = -6;
	}

	public void stop() {
		speedX = 0;
	}

	public void jump() {
		if (jumped == false) {
			speedY = -15;
			jumped = true;
		}

	}
	
	public void shoot() {
		if (readyToFire) {
			Spittle p = new Spittle(centerX +20, centerY+25);
			spittles.add(p);
		}
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public ArrayList<Spittle> getSpittles() {
		return spittles;
	}
}
