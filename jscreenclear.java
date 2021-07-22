// draumaz/jscreenclear
// BSD-3

import java.io.IOException;

class jscreenclear {
	public static void clear() {
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) { // When system is Windows
			try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); // Clear with cmd
			} catch (InterruptedException ie) {
				exceptions(1, 1);
			} catch (IOException ioe) {
				exceptions(2, 1);
			}
		} else { // When system is not Windows
			try {
			new ProcessBuilder("/bin/sh","-c","clear").inheritIO().start().waitFor(); // Clear with POSIX sh
			} catch (InterruptedException ie) {
				exceptions(1, 0);
			} catch (IOException ioe) {
				exceptions(2, 0);
			}
		}
	}
	public static void exceptions(int type, int os) {
		switch (type) {
			case 1:
				System.out.println("Interrupted exception encountered.");
				if (os == 1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println("Another interrupted exception encountered.");
					}
				}
				System.exit(0);
				break;
			case 2:
				System.out.println("IO exception encountered.");
				if (os == 1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						System.out.println("Another interrupted exception encountered.");
					}
				}
				System.exit(0);
				break;
		}
	}
}
