// draumaz/jscreenclear
// BSD-3

class example { // Example script
	public static void example_script() throws InterruptedException {
		String[] hello = {"BINGO","BANGO","BONGO"};
		jscreenclear jsc = new jscreenclear();
		jsc.clear(); // This is the only command you'll be using
		for (int i = 0; i < hello.length; i++) {
			System.out.println("\n"+hello[i]);
			Thread.sleep(300);
			jsc.clear();
		}
	}
}
