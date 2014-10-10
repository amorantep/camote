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

public class SpitterGame extends Applet implements Runnable, KeyListener {

	private Spitter spitter;
	private Image image, character;
	private Graphics second;
	private URL base;

	@Override
	public void init() {

		setSize(400, 600);
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
		character = getImage(base, "data/Mario.png");

	}

	@Override
	public void start() {
		spitter = new Spitter();

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
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList<Spittle> splittles = spitter.getSpittles();
			for (int i = 0; i < splittles.size(); i++) {
				Spittle p = (Spittle) splittles.get(i);
				if (p.isVisible() == true) {
					p.update();
				} else {
					splittles.remove(i);
				}
			}
		}
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
		g.drawImage(character, spitter.getCenterX(),
				spitter.getCenterY(), this);
		
		ArrayList spittles = spitter.getSpittles();
		for (int i = 0; i < spittles.size(); i++) {
			Spittle p = (Spittle) spittles.get(i);
			g.setColor(Color.YELLOW);
			g.fillRect(p.getX(), p.getY(), 5, 10);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			spitter.shoot();
			System.out.println("Shoot harder!");
			break;

		case KeyEvent.VK_DOWN:
			System.out.println("Shoot Lower!");
			break;

		case KeyEvent.VK_LEFT:
			System.out.println("Move left");
			break;

		case KeyEvent.VK_RIGHT:
			System.out.println("Move right");
			break;

		case KeyEvent.VK_SPACE:
			System.out.println("Jump");
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			spitter.setReadyToFire(true);
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
			System.out.println("Stop jumping");
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
