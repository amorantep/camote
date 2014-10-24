package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PersonGenerator {
	public static ArrayList<Person> people = new ArrayList<>();;

	public static void createPerson(int centerX, int centerY) {
		Person p = new NerdyPerson(centerX, centerY);
		people.add(p);
		int r = randInt(1, 10);
		switch (r) {
		case 1:
			p.setSpeedX(1);
			break;
		case 2:
			p.setSpeedX(2);
			break;
		case 3:
			p.setSpeedX(3);
			break;
		case 4:
			p.setSpeedX(4);
			break;
		case 5:
			p.setSpeedX(5);
			break;
		case 6:
			p.setSpeedX(6);
			break;
		case 7:
			p.setSpeedX(7);
			break;
		case 8:
			p.setSpeedX(8);
			break;
		case 9:
			p.setSpeedX(9);
			break;
		case 10:
			p.setSpeedX(10);
			break;

		}

	}

	private static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public static int size() {
		return people.size();

	}

	public static void update() {
		for (Iterator iterator = people.iterator(); iterator.hasNext();) {
			Person p = (Person) iterator.next();
			p.update();

		}
	}

}
