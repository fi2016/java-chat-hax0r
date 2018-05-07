package java_chat_hax0r;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandListener implements Runnable
{
	private Hax0rTool tool;
	
	public CommandListener() {
		System.out.println("+++ Welcome Hax0r +++");
		System.out.println("First connect to the server: connect <ip> <port>");
		System.out.println("Then type any command to attack the server");
	}
	
	@Override
	public void run()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (!Thread.currentThread().isInterrupted()) {
			try
			{
				String command = reader.readLine();
				String[] args = command.split(" ");
				if (args.length > 0) {
					if (args[0].equals("connect")) {
						if (args.length == 3) {
							String ip = args[1];
							int port = Integer.parseInt(args[2]);
							tool = new Hax0rTool();
							System.out.println(tool.connect(ip, port));
						} else {
							printSyntax("connect <ip> <port>");
						}
					} else {
						if (tool != null) {
							if (args[0].equals("dos")) {
								if (args.length == 2) {
									int amount = Integer.parseInt(args[1]);
									tool.dos(amount);
								} else {
									printSyntax("dos <amount>");
								}
							} else if (args[0].equals("spam")) {
								if (args.length == 2) {
									int amount = Integer.parseInt(args[1]);
									tool.spam(amount);
								} else {
									printSyntax("spam <amount>");
								}
							} else if (args[0].equals("pa")) {
								if (args.length == 1) {
									tool.protocolAttack();
								} else {
									printSyntax("spam <amount>");
								}
							} else {
								System.out.println("Command not found!");
							}
						} else {
							System.out.println("First connect to the server: connect <ip> <port>");
						}
					}
				} else {
					printSyntax("<command>");
				}
			} catch (Exception ignored) {}
		}
	}
	
	private void printSyntax(String syntax) {
		System.out.println("Syntax: " + syntax);
	}
}