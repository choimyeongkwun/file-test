package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

class FileItem{
	private String name;
	private String string;
	@Override
	public String toString() {
		return "FileItem [name=" + name + ", string=" + string + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public FileItem(String name, String string) {
		super();
		this.name = name;
		this.string = string;
	}
	
}
public class Test {

	public static void main(String[] args) {
		List<FileItem> fList = new ArrayList<FileItem>();
		fList.add( new FileItem("name","홍길동"));
		fList.add(new FileItem("age","33"));
		fList.add(new FileItem("address","서울"));
		
		for(FileItem fi : fList) {
			if(fi.getName().equals("age")) {
				System.out.println(fi.getString());
			}
			
		}
		
	}
}
