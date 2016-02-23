
//Joshua Hale
//Draws circles within a window. All different colors
//Layers print with random colors

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ConcentricCircles extends JFrame {

	int width = 300;
	int height = 300;
	private CirclesDraw window;

	public static void main(String[] args) {
		// create dialog window object
		JOptionPane.showMessageDialog(null, "Joshua Hale 2016", "Concentric Circles",
				JOptionPane.INFORMATION_MESSAGE);
		ConcentricCircles c = new ConcentricCircles();

		// public void setVisible(boolean b)
		// Shows or hides this Window depending on the value of parameter b.
		c.setVisible(true);

	}

	// create circle size and colors
	public ConcentricCircles() {

		Greet();

	}

	private void Greet() {
		Scanner sc = new Scanner(System.in);
		CheckWidth();

		/*
		 * notes --------------------------------------------------------------
		 * int width = 200; System.out.print("Enter window height over 100px: ");
		 * int height = sc.nextInt(); setTitle("HW3: Concentric Circles");
		 * setSize(width, height);
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * Container contentPane = getContentPane(); window = new CirclesDraw();
		 * contentPane.add(window);
		 * ---------------------------------------------------------------------
		 * --
		 */

		sc.close();
	}

	// Sets title, window , size, exit_on_close
	private void StartPrinting() {
		setTitle("HW3: Concentric Circles");
		setSize(this.width, this.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// public Container getContentPane()
		// Returns the contentPane object for this frame.
		Container contentPane = getContentPane();
		window = new CirclesDraw();
		contentPane.add(window);
	}

	// User input for Height of window in pixels
	// Note: Program still opens a window under 100px
	private int CheckHeight() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter window height over 100px: ");
		// int height = sc.nextInt();
		// Check for valid input. Negatives, Type, etc.
		for (;;) {
			if (!sc.hasNextInt()) {
				System.out.println("Integers only please: ");
				sc.next();// discard
				continue;
			}
			height = sc.nextInt();
			if (height >= 100) {
				StartPrinting();
			} else {
				System.out.println("Out of range. Must be over 100px");
				CheckWidth();
			}
			sc.close();
			return height;
		}
	}

	private int CheckWidth() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter window width over 100px: ");
		for (;;) {
			if (!sc.hasNextInt()) {
				System.out.println("Integers only please: ");
				sc.next();// discard
				continue;
			}
			width = sc.nextInt();
			if (width >= 100) {
				CheckHeight();
			} else {
				System.out.println("Out of range. Must be over 100px.");
			}
			sc.close();
			return width;
		}
	}

	private class CirclesDraw extends JPanel {

		public CirclesDraw() {
			// only sets window color src Oracle
			setBackground(Color.BLACK);
		}

		// For resizing window for redraw of circles
		public void paintComponent(Graphics g) {

			// getWidth/getHeight Returns: the current width of this component
			// Window resize
			int width = getWidth();
			int height = getHeight();
			int x = 0;
			int y = 0;

			// The all mighty Google told me super class this. Note*** read into
			super.paintComponent(g);

			// Get circle color, then draw circles
			while (width > 10 && height > 10) {
				//sleep(1000);

				// sets circle color based on random rgb return
				g.setColor(RandColor());

				// Note****Graphics g -
				// ConcentricCircles.CirclesDraw.paintComponent(Graphics)
				//Draws the outline of an oval. The result is a circle or 
				//ellipse that fits within the rectangle specified by the x, y, width, and height arguments.
				g.drawOval(x, y, width, height);

				// set circle padding
				// "-=" and "+=" are similar to x=x-5 and x=x+5
				width -= 10;
				height -= 10;
				x = x + 5;
				y = x + 5;
			}
		}

		// --------------------------------------------------------------------------------
		// creates ints used to assign rgb values randomly
		private Color RandColor() {

			// public static double random()
			// Returns a double value with a positive sign, greater than or
			// equal to 0.0
			// and less than 1.0. Returned values are chosen pseudorandomly with
			// (approximately) uniform distribution from that range.
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 100);
			int blue = (int) (Math.random() * 256);

			// object for storing r,g,b values
			Color rgb = new Color(red, green, blue);
			// sysout for checking RGB values
			// Output as java.awt.Color[r=*,g=*,b=*]
			// "*" being a random generated number
			// System.out.println(rgb);

			// value to create circle color with full opacity
			return rgb;
		}
	}

}
