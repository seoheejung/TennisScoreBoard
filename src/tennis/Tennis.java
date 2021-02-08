package tennis;

import java.io.*;

public class Tennis {

	public static void main(String[] args) throws IOException {
		Display.Intro();
		Play tennis = new Play();
		tennis.play();
	}
}
