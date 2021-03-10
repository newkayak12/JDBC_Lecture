package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PropertiesLoader {
	static Map<String, String> prop = new HashMap<>();
	

	public static void main(String[] args) {
		
//		prop.put("ip","jdbc:oracle:thin:@rclass.iptime.org:8877:xe" );
//		prop.put("id","student_sh");
//		prop.put("pw", "student");
		
		
		File f = new File("/Users/sanghyeonkim/Downloads/JDBC/Prop.properties");
		
		
		
//		try {
//			FileOutputStream fos = new FileOutputStream (f);
//			try {
//				ObjectOutputStream oos = new ObjectOutputStream (fos);
//				
//				
//				oos.writeObject(prop);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	
	
			try(FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);){
				
				prop = (Map<String,String>) ois.readObject();
				
			}catch(ClassNotFoundException  | IOException e){
				
			}
			Set<String> key = prop.keySet();
			for(String temp : key) {
				System.out.println(prop.get(temp));
			}
	}
}
