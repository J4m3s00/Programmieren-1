package pr1.a08;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import schimkat.myway.DirtyPainter2;
import schimkat.myway.Drawable2;

public class Snake implements Drawable2, KeyListener {

	private final int GRID_WIDTH = 20;
	private final int GRID_HEIGHT = 20;
	private final int BLOCK_SIZE = 32;
	private final int APPLE_SIZE = 10;
	private final double MOVE_DELAY = 0.2d;
	
	private int playerLength;
	private int[] playerX = new int[128];
	private int[] playerY = new int[128];
	private boolean dir_left = false;
	private boolean dir_right = true;
	private boolean dir_top = false;
	private boolean dir_bottom = false;
	
	private int appleX = -10;
	private int appleY = -10;


	private double timer = 0.0;

	public Snake(DirtyPainter2 window) {
		window.addKeyListener(this);
		resetSnake();
		spawnApple();
	}

	private void moveSnake() {
		for (int i = playerLength; i > 0; i--) {
			this.playerX[i] = this.playerX[(i - 1)];
			this.playerY[i] = this.playerY[(i - 1)];
		}

		if (dir_right) {
			this.playerX[0]++;
		}
		if (dir_left) {
			this.playerX[0]--;
		}

		if (dir_top) {
			this.playerY[0]--;
		}
		if (dir_bottom) {
			this.playerY[0]++;
		}

		int currentX = this.playerX[0];
		int currentY = this.playerY[0];
		
		if (currentX == appleX && currentY == appleY) {
			this.playerX[this.playerLength] = this.playerX[this.playerLength-1];
			this.playerY[this.playerLength] = this.playerY[this.playerLength-1];
			this.playerLength++;
			spawnApple();
		}

		if (currentX < 0 || currentX >= GRID_WIDTH) {
			resetSnake();
			return;
		}
		if (currentY < 0 || currentY >= GRID_HEIGHT) {
			resetSnake();
			return;
		}

		for (int i = playerLength; i > 0; i--) {
			if (this.playerX[i] == currentX && this.playerY[i] == currentY) {
				resetSnake();
				return;
			}
		}
	}

	@Override
	public void draw(Graphics2D g, double delta) {
		//Draw the background
		for (int y = 0; y < GRID_HEIGHT; y++) {
			for (int x = 0; x < GRID_WIDTH; x++) {
				g.setColor(new Color(0.3f, 0.4f, 0.9f));
				g.fillRect(x * (BLOCK_SIZE + 2) + 100, y * (BLOCK_SIZE + 2) + 25, BLOCK_SIZE, BLOCK_SIZE);
			}
		}
		//Draw the player
		g.setColor(Color.red);
		for (int i = 0; i < playerLength; i++) {
			g.fillRect(this.playerX[i] * (BLOCK_SIZE + 2) + 100, this.playerY[i] * (BLOCK_SIZE + 2) + 25, BLOCK_SIZE,
					BLOCK_SIZE);
		}
		//Draw the apple
		g.setColor(Color.green);
		g.fillRect(appleX * (BLOCK_SIZE + 2) + 100 + ((BLOCK_SIZE - APPLE_SIZE) / 2), appleY * (BLOCK_SIZE + 2) + 25 + ((BLOCK_SIZE - APPLE_SIZE) / 2), APPLE_SIZE, APPLE_SIZE);
			
		timer += delta;
		if (timer >= MOVE_DELAY) {
			moveSnake();
			timer -= MOVE_DELAY;
		}
	}

	private void spawnApple() {
		Random rand = new Random();
		appleX = rand.nextInt(GRID_WIDTH);
		appleY = rand.nextInt(GRID_HEIGHT);
	}
	
	private void resetSnake() {
		playerLength = 3;
		for (int i = 0; i < playerLength; i++) {
			playerX[i] = 4 - i;
			playerY[i] = 3;
		}

		dir_left = false;
		dir_right = true;
		dir_top = false;
		dir_bottom = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D && !dir_left) {
			dir_right = true;
			dir_left = false;
			dir_top = false;
			dir_bottom = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A && !dir_right) {
			dir_right = false;
			dir_left = true;
			dir_top = false;
			dir_bottom = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W && !dir_bottom) {
			dir_right = false;
			dir_left = false;
			dir_top = true;
			dir_bottom = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S && !dir_top) {
			dir_right = false;
			dir_left = false;
			dir_top = false;
			dir_bottom = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.playerX[this.playerLength] = this.playerX[this.playerLength-1];
			this.playerY[this.playerLength] = this.playerY[this.playerLength-1];
			this.playerLength++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
