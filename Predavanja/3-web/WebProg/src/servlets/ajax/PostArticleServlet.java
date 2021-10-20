package servlets.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.ajax.Article;

public class PostArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5551894444616184019L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		BufferedReader in = req.getReader();
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		ObjectMapper mapper = new ObjectMapper();
		Article a = mapper.readValue(sb.toString(), Article.class);
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>) getServletContext().getAttribute("articles");
		articles.add(a);
	}

}
