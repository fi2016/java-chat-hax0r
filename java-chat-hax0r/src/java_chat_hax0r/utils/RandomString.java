package java_chat_hax0r.utils;

import java.util.Random;

public class RandomString {

    public static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
	public static String getRandomString() {
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 18) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            sb.append(CHARS.charAt(index));
        }
        String s = sb.toString();
        return s;
    }
}