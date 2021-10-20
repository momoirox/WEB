package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class UploadServletV3
 */
@MultipartConfig(fileSizeThreshold = 100000, location = "C:\\Temp", maxFileSize = 50000, maxRequestSize = 50000)
public class UploadServletV3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServletV3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding(response.getCharacterEncoding());

			PrintWriter pout = response.getWriter();

			pout.println("<html>");
			pout.println("<head>");
			pout.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			pout.println("</head>");
			pout.println("<body>");

			pout.println("Request character encoding: " + request.getCharacterEncoding() + "<br>");
			pout.println("Response character encoding: " + response.getCharacterEncoding() + "<br>");

			Collection<Part> items = request.getParts();
			// Process the uploaded items
			for (Part item : items) {
				String name = item.getName();
				String fileName = getFileName(item);
				String contentType = item.getContentType();
				long sizeInBytes = item.getSize();
				pout.println(name + "->" + fileName  + "("
						+ sizeInBytes + " bytes, Content-Type: "
						+ contentType + ")<br />");
				if (sizeInBytes != 0) {
					if (fileName != null) {
						String uploadedFile = "C:/Temp/Files/" + fileName;
						pout.println(" saved at: {" + uploadedFile + "} <br />");
						item.write(uploadedFile);
					} else {
						StringWriter writer = new StringWriter();
						IOUtils.copy(item.getInputStream(), writer, "utf-8");
						pout.println(" value is: " + writer.toString() + "<br />");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return null;
    }

}
