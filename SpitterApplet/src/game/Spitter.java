package game;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Spitter {
	private int centerX = 175;
	private int centerY = 50;

	// Constants are Here
	final int MOVESPEED = 5;
	final int GROUND = 382;

	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;

	private int speedX = 0;
	private int speedY = 1;

	private boolean readyToFire = true;

	private static Background bg1 = SpitterGame.getBg1();
	private static Background bg2 = SpitterGame.getBg2();

	//ArrayList<Spittle> spittles = new ArrayList<Spittle>();
	Spittle spittle ;
	private double angle = 90;
	private final double ANGLESTEP= 1;
	
	public Spitter()
	{
		spittle  = new Spittle(centerX, centerY );
		spittle.setVisible(false);
	}

	public void update() {

		centerX +=speedX;
		if(centerX<0)
			centerX=0;
		if(centerX>350)
			centerX=350;
		speedX = 0;
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
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public void shoot() {
		if (readyToFire) {
			
			double x,y;
			
			x = spittle.getSpeedX() * Math.cos(angle);
			y = spittle.getSpeedX() * Math.sin(angle);
			
			int xC = (int) x;
			int yC = (int) y;
//			spittle.setX(centerX+20);
//			spittle.setY(centerY + 25);
			spittle.setX(centerX +xC +10);
  			spittle.setY(centerY + yC+12);
			spittle.setVisible(true);
			readyToFire = false;
		}  
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getANGLESTEP() {
		return ANGLESTEP;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}

	public Spittle getSpittle() {
		return spittle;
	}
	
	public void increaseSpeedSpittle()
	{
		spittle.increaseSpeed();
	}
	
	public void decreaseSpeedSpittle()
	{
		spittle.decreaseSpeed();
	}
	
	public void increaseAngle()
	{
		angle +=ANGLESTEP;
	}
	
	public void decreaseAngle()
	{
		angle -=ANGLESTEP;
	}
}
