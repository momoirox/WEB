package servletengine;

/**
 * Klasa koja reprezentuje datoteku koja je poslata na server.
 * 
 * @author Milan Vidakovic
 */
public class Part {
	private String fieldName;
	private String filePath;

	public Part(String fn, String fp) {
		fieldName = fn;
		filePath = fp;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String s) {
		fieldName = s;
	}


	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String s) {
		filePath = s;
	}

}