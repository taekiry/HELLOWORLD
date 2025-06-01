package PrivateProject;

public class Main {
	public static void main(String[] args) {

		CarApp app = new CarApp();
		if (app.loginCheck()) {
			app.execute();
		}
	}
}
