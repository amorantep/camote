package game;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import framework.Animation;

public class SpitterGame extends Applet implements Runnable, KeyListener {
	// ////
	// /deubg
	int i = 0;
	// ///
	private Spitter spitter;
	public static NerdyPerson nerd;

	private Image image, currentSprite, character, background, nerdy,
			nerdyDead, nerdyLeft,nerdyLeftDead;
	private Graphics second;
	private URL base;

	final static int WIDTH = 400;
	final static int HEIGTH = 600;

	private static Background bg1, bg2;
	private Animation spitterAnim, personAnim, deadAnim;

	@Override
	public void init() {

		setSize(WIDTH, HEIGTH);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Image Setups
		character = getImage(base, "data/Mario.PNG");
		background = getImage(base, "data/background.png");
		nerdy = getImage(base, "data/person.png");
		nerdyDead = getImage(base, "data/personDead.png");
		nerdyLeft = getImage(base, "data/personLeft.png");
		nerdyLeftDead = getImage(base, "data/personLeftDead.png");

		spitterAnim = new Animation();
		spitterAnim.addFrame(character, 1250);

		personAnim = new Animation();
		personAnim.addFrame(nerdy, 500);
		personAnim.addFrame(nerdyLeft, 500);

		deadAnim = new Animation();
		deadAnim.addFrame(nerdyDead, 500);
		deadAnim.addFrame(nerdyLeftDead, 500);

		currentSprite = spitterAnim.getImage();
	}

	@Override
	public void start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);
		spitter = new Spitter();
		nerd = new NerdyPerson(200, 500);
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		while (true) {

			spitter.update();
			nerd.update();
			bg1.update();
			bg2.update();
			animate();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// ArrayList<Spittle> splittles = spitter.getSpittles();
			// for (int i = 0; i < splittles.size(); i++) {
			// Spittle p = (Spittle) splittles.get(i);
			// if (p.isVisible() == true) {
			// p.update();
			// } else {
			// splittles.remove(i);
			// }
			// }

			Spittle s = spitter.getSpittle();
			if (s != null) {
				if (s.isVisible() == true) {
					s.update();
				}
			}
		}
	}

	private void animate() {
		spitterAnim.update(10);
		personAnim.update(50);
		deadAnim.update(50);

	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);

		// ArrayList spittles = spitter.getSpittles();
		// for (int i = 0; i < spittles.size(); i++) {
		// Spittle p = (Spittle) spittles.get(i);
		// g.setColor(Color.YELLOW);
		// g.fillRect(p.getX(), p.getY(), 5, 10);
		// }
		Spittle s = spitter.getSpittle();
		if (s != null) {
			if (s.isVisible()) {
				g.setColor(Color.BLUE);

				g.fillRect(s.getX(), s.getY(), 10, 10);
			}
		}

		// g.drawImage(character, spitter.getCenterX(), spitter.getCenterY(),
		// this);
		g.drawImage(currentSprite, spitter.getCenterX(), spitter.getCenterY(),
				this);

		// g.drawImage(nerdy, nerd.getCenterX(), nerd.getCenterY(), this);
		if (!nerd.isDead())
			g.drawImage(personAnim.getImage(), nerd.getCenterX(),
					nerd.getCenterY(), this);
		g.drawRect(nerd.r.x, nerd.r.y, nerd.r.width, nerd.r.height);

		if (nerd.isDead()) {
			g.drawImage(deadAnim.getImage(), nerd.getCenterX(),
					nerd.getCenterY(), this);
			int i = 0;
//			while(i<5000000)
//				i++;
			 nerd.resurrect();
			// g.drawImage(personAnim.getImage(), nerd.getCenterX(),
			// nerd.getCenterY(), this);
		}
	}

	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			if (spitter.isReadyToFire())
				spitter.increaseSpeedSpittle();
			System.out.println("Shoot harder!");
			break;

		case KeyEvent.VK_DOWN:
			if (spitter.isReadyToFire())
				spitter.decreaseSpeedSpittle();
			System.out.println("Shoot Lower!");
			break;

		case KeyEvent.VK_LEFT:
			spitter.moveLeft();
			spitter.setMovingLeft(true);
			break;

		case KeyEvent.VK_RIGHT:
			spitter.moveRight();
			spitter.setMovingRight(true);
			break;

		case KeyEvent.VK_SPACE:
			spitter.shoot();
			break;

		case KeyEvent.VK_A:
			spitter.increaseAngle();
			break;
		case KeyEvent.VK_B:
			spitter.decreaseAngle();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:

			System.out.println("Stop moving up");
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("Stop moving down");
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("Stop moving left");
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("Stop moving right");
			break;

		case KeyEvent.VK_SPACE:
			spitter.setReadyToFire(true);
			System.out.println("Stop jumping");
			break;

		case KeyEvent.VK_A:
			// spitter.increaseAngle();
			// System.out.println("angle+");
			break;
		case KeyEvent.VK_B:
			// spitter.decreaseAngle();
			// System.out.println("angle-");
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void killNerd() {

	}

}
