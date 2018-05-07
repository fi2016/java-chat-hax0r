package java_chat_hax0r;

public class Main
{
	public static void main(String[] args) {
		new Main(args);
	}
	
	public Main(String[] args) {
		CommandListener listener = new CommandListener();
		new Thread(listener).start();
	}
}