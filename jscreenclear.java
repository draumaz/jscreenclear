class jscreenclear {
	public static void clear() {
		if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) { // When system is Windows
		try {
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor(); // Clear with cmd
		} catch (Exception e) {}
		} else { // When system is not Windows
			try {
				new ProcessBuilder("/bin/sh","-c","clear").inheritIO().start().waitFor(); // Clear with POSIX sh
			} catch (Exception e) {}
		}
	}
}