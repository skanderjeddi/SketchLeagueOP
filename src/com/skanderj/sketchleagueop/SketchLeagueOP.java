package com.skanderj.sketchleagueop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class SketchLeagueOP {
	public static final String[] CHAMPIONS = { "Aatrox", "Ahri", "Akali", "Alistar", "Amumu", "Anivia", "Annie", "Ashe", "Aurelion Sol", "Azir", //
			"Bard", "Blitzcrank", "Brand", "Braum", //
			"Caitlyn", "Camille", "Cassiopeia", "Cho'Gath", "Corki", //
			"Darius", "Diana", "Dr. Mundo", "Draven", //
			"Ekko", "Elise", "Evelynn", "Ezreal", //
			"Fiddlesticks", "Fiora", "Fizz", //
			"Galio", "Gangplank", "Garen", "Gnar", "Gragas", "Graves", //
			"Hecarim", "Heimerdinger", //
			"Illaoi", "Irelia", "Ivern", //
			"Janna", "Jarvan IV", "Jax", "Jayce", "Jhin", "Jinx", //
			"Kai'Sa", "Kalista", "Karma", "Karthus", "Kassadin", "Katarina", "Kayle", "Kayn", "Kennen", "Kha'Zix", "Kindred", "Kled", "Kog'Maw", //
			"LeBlanc", "Lee Sin", "Leona", "Lissandra", "Lucian", "Lulu", "Lux", //
			"Malphite", "Malzahar", "Maokai", "Master Yi", "Miss Fortune", "Mordekaiser", "Morgana", //
			"Nami", "Nasus", "Nautilus", "Neeko", "Nidalee", "Nocturne", "Nunu & Willump", //
			"Olaf", "Orianna", "Ornn", //
			"Pantheon", "Poppy", "Pyke", //
			"Quinn", //
			"Rakan", "Rammus", "Rek'Sai", "Renekton", "Rengar", "Riven", "Rumble", "Ryze", //
			"Sejuani", "Shaco", "Shen", "Shyvana", "Singed", "Sion", "Sivir", "Skarner", "Sion", "Soraka", "Swain", "Sylas", "Syndra", //
			"Tahm Kench", "Taliyah", "Talon", "Taric", "Teemo", "Thresh", "Tristana", "Trundle", "Tryndamere", "Twisted Fate", "Twitch", //
			"Udyr", "Urgot", //
			"Varus", "Vayne", "Veigar", "Vel'Koz", "Vi", "Viktor", "Vladimir", "Volibear", //
			"Warwick", "Wukong", //
			"Xayah", "Xerath", "Xin Zhao", //
			"Yasuo", "Yorick", //
			"Zac", "Zed", "Ziggs", "Zilean", "Zoe", "Zyra" };

	public static final Map<Character, Integer> mappings = new HashMap<Character, Integer>();

	static {
		SketchLeagueOP.mappings.put('a', KeyEvent.VK_A);
		SketchLeagueOP.mappings.put('b', KeyEvent.VK_B);
		SketchLeagueOP.mappings.put('c', KeyEvent.VK_C);
		SketchLeagueOP.mappings.put('d', KeyEvent.VK_D);
		SketchLeagueOP.mappings.put('e', KeyEvent.VK_E);
		SketchLeagueOP.mappings.put('f', KeyEvent.VK_F);
		SketchLeagueOP.mappings.put('g', KeyEvent.VK_G);
		SketchLeagueOP.mappings.put('h', KeyEvent.VK_H);
		SketchLeagueOP.mappings.put('i', KeyEvent.VK_I);
		SketchLeagueOP.mappings.put('j', KeyEvent.VK_J);
		SketchLeagueOP.mappings.put('k', KeyEvent.VK_K);
		SketchLeagueOP.mappings.put('l', KeyEvent.VK_L);
		SketchLeagueOP.mappings.put('m', KeyEvent.VK_M);
		SketchLeagueOP.mappings.put('n', KeyEvent.VK_N);
		SketchLeagueOP.mappings.put('o', KeyEvent.VK_O);
		SketchLeagueOP.mappings.put('p', KeyEvent.VK_P);
		SketchLeagueOP.mappings.put('q', KeyEvent.VK_Q);
		SketchLeagueOP.mappings.put('r', KeyEvent.VK_R);
		SketchLeagueOP.mappings.put('s', KeyEvent.VK_S);
		SketchLeagueOP.mappings.put('t', KeyEvent.VK_T);
		SketchLeagueOP.mappings.put('u', KeyEvent.VK_U);
		SketchLeagueOP.mappings.put('v', KeyEvent.VK_V);
		SketchLeagueOP.mappings.put('w', KeyEvent.VK_W);
		SketchLeagueOP.mappings.put('x', KeyEvent.VK_X);
		SketchLeagueOP.mappings.put('y', KeyEvent.VK_Y);
		SketchLeagueOP.mappings.put('z', KeyEvent.VK_Z);
		SketchLeagueOP.mappings.put(' ', KeyEvent.VK_SPACE);
		SketchLeagueOP.mappings.put('\'', KeyEvent.VK_4);
		SketchLeagueOP.mappings.put('.', KeyEvent.VK_SEMICOLON);
		SketchLeagueOP.mappings.put('&', KeyEvent.VK_1);
	}

	public static final int DELAY = 30;

	private Robot robot;
	private Random random;

	public SketchLeagueOP() throws AWTException {
		this.robot = new Robot();
		this.random = new Random();
	}

	public final void tryAllChampions(boolean randomize) {
		if (randomize) {
			String[] randomizedArray = this.randomize(SketchLeagueOP.CHAMPIONS);
			this.robot.delay(4000);
			for (String champion : randomizedArray) {
				this.type(champion);
				this.pressEnter();
			}
		} else {
			this.robot.delay(4000);
			for (String champion : SketchLeagueOP.CHAMPIONS) {
				this.type(champion);
				this.pressEnter();
			}
		}
	}

	private String[] randomize(String[] baseArray) {
		String[] finalArray = new String[baseArray.length];
		for (int index = 0; index < finalArray.length; index += 1) {
			finalArray[index] = new String();
		}
		for (int index = 0; index < finalArray.length; index += 1) {
			String pick = this.pick(baseArray, finalArray, index == (finalArray.length - 1));
			finalArray[index] = pick;
		}
		return finalArray;
	}

	private boolean arrayContains(String[] array, String object) {
		for (int index = 0; index < array.length; index += 1) {
			if (array[index].equals(object)) {
				return true;
			}
		}
		return false;
	}

	public String pick(String[] baseArray, String[] finalArray, boolean last) {
		String randomString = baseArray[this.random.nextInt(baseArray.length)];
		boolean contains = this.arrayContains(finalArray, randomString);
		if (contains) {
			if (last) {
				return randomString;
			}
			return this.pick(baseArray, finalArray, last);
		} else {
			return randomString;
		}
	}

	private final void type(char character) {
		int code = SketchLeagueOP.mappings.get(character);
		this.robot.delay(SketchLeagueOP.DELAY);
		this.robot.keyPress(code);
		this.robot.keyRelease(code);
	}

	private final void type(String string) {
		String[] splits = string.split("(?!^)");
		for (String part : splits) {
			boolean isUppercase = (part.equals(part.toUpperCase()) || part.equals(".")) && !part.equals("\'") && !part.equals("&");
			if (isUppercase) {
				this.enableCaps();
			}
			char c = part.toLowerCase().charAt(0);
			this.type(c);
			if (isUppercase) {
				this.disableCaps();
			}
		}
	}

	private final void pressEnter() {
		this.robot.delay(SketchLeagueOP.DELAY);
		this.robot.keyPress(KeyEvent.VK_ENTER);
		this.robot.keyRelease(KeyEvent.VK_ENTER);
	}

	private final void enableCaps() {
		this.robot.delay(SketchLeagueOP.DELAY);
		this.robot.keyPress(KeyEvent.VK_SHIFT);
	}

	private final void disableCaps() {
		this.robot.delay(SketchLeagueOP.DELAY);
		this.robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	public static void main(String[] args) {
		try {
			new SketchLeagueOP().tryAllChampions(true);
		} catch (AWTException awtException) {
			awtException.printStackTrace();
		}
	}
}