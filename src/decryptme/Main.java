package decryptme;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Main
 */
@WebServlet("/")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public static final double[] NEW_WORD_CHANCE = {1.0, 0.8, 0.6, 0.4, 0.2, 0.1, 0.0};
    
	private CipherDB db;
    
    
    @Override
	public void init() {
    	db = CipherDB.getInstance();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		SentenceGenerator sg = new SentenceGenerator(context);
		
		
		String[] plaintext = sg.getSentenceAsArray(NEW_WORD_CHANCE);
		String[] cipher = CipherGenerator.shift(plaintext);
		
		String plaintextS = Arrays.toString(plaintext).replaceAll("\\[|\\]|,", "");
		String cipherS = Arrays.toString(cipher).replaceAll("\\[|\\]|,", "");
		
		if(db.getCipher(plaintextS) == "") {
			db.addCipher(plaintextS, cipherS);
		}
		
        System.out.println(plaintextS);
        
        request.setAttribute("cipher", cipherS);
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cipher = request.getParameter("cipher");
		String attempt = request.getParameter("attempt");
		
		boolean success;
		if(attempt == null || attempt.equals("")) {
			success = false;
		} else {
			success = db.getCipher(attempt).equals(cipher);
		}

		request.setAttribute("cipher", request.getParameter("cipher") );
		request.setAttribute("success", success);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

   

}
