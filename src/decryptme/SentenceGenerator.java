package decryptme;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;

import javax.servlet.ServletContext;
public class SentenceGenerator {

	public static final String TEXT_FILE = "/WEB-INF/words_alpha.txt";
	public static final int NUM_LINES = 370104;
	
	private Random random;
	private ServletContext context;
	
	public SentenceGenerator(ServletContext context) {
		random = new Random();
		this.context = context;
	}
	
	
	public String getSentence() {
		String sentence = "";
		int n = random.nextInt(10);
		for(int i = 0; i < n; i++) {
			sentence += getRandomWord();
		}
		
		return sentence;
	}
	
	public String getSentence(int numWords) {
		String res = "";
		for(int i = 0; i < numWords; i++) {
			res += getRandomWord();
		}
		return res;
	}
	
	public String[] getSentenceAsArray(double[] chances) {
		ArrayList<String> arrList = new ArrayList<String>();
		for(int i = 0; i < chances.length; i++) {
			if(random.nextDouble() > chances[i]) {
				break;
			}
			arrList.add(getRandomWord());
		}

		return arrList.toArray(new String[arrList.size()]);		
	}
	
	
	public String getSentence(double[] chances) {
		String sentence = "";
		for(int i = 0; i < chances.length; i++) {
			if(random.nextDouble() > chances[i]) {
				break;
			}
			sentence += getRandomWord();
		}
		return sentence;
	}
	
	public BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(context.getResourceAsStream(TEXT_FILE)));
	}
	
	public String getRandomWord() {
		String res = "";
		int lineNum = random.nextInt(NUM_LINES);
		BufferedReader reader = getReader();
		for(int i = 0; i != lineNum; i++) {
			try {
				reader.readLine();
			} catch (Exception e) {
				System.out.println("error incrementing readline");
			}
		}
		try {
			res = reader.readLine();
		} catch (IOException e) {
			System.out.println("error getting final line");
		}
		
		return res; 
	}
	

}
