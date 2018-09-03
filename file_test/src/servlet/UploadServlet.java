package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/up/*")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String tmpPath = System.getProperty("java.io.tmpdir");
		System.out.println("너 템프디렉토리 : " + tmpPath);
		System.out.println("너 멀티파트방식 : " + isMulti);
		DiskFileItemFactory dfac = new DiskFileItemFactory();
		dfac.setRepository(new File(System.getProperty("java.io.tmpdir")));
		dfac.setSizeThreshold(1024*1024*5);
		ServletFileUpload sfu = new ServletFileUpload(dfac);
		try {
			List<FileItem> fList = sfu.parseRequest(request);
			for(FileItem fi: fList) {
				if(fi.isFormField()) {
				String name = fi.getFieldName();
				String value = fi.getString("utf-8");
				System.out.println(name + " : " + value);
				}else {
					String name = fi.getFieldName();
					String value = fi.getName();
					System.out.println(name + " : " + value);
					File f = new File("C:\\bdi-study\\workspace\\file_test\\WebContent\\test.jpg");
					fi.write(f);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
