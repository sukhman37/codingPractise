package Tech_Question;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.omg.CORBA.portable.ApplicationException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

//import beans.Car;


public class Testing {
	public static void main(String[] args) {
		
		String json = "{\"debtamount\": 20, \"amount\": 0, \"code\": 3, \"error_message\": \"has loan balance\"}";
		
		
		String counters=null;
		//String counter[] = counters.split(",");
		System.out.println(counters.length());
		
	/*	ApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
		Car car = (Car)application.getBean("t");
		car.carname();*/
/*
		try {
			File file = new File("D:\\adcom\\");
			
			String JAVA_HOME = System.getenv("JAVA_HOME");
			String JRE_HOME = System.getenv("JRE_HOME");
			String path = System.getenv("PATH");
			System.out.println("Path = "+path);
			String a[]= {path};

			Process p = Runtime.getRuntime().exec("cmd.exe /c javac java.java", a, file);
			
			System.out.println("INPUT");
			String line = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line = br.readLine()) != null)
				System.out.println(line);
			
			System.out.println("ERROR");
			line = "";
			BufferedReader brE = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while((line = brE.readLine()) != null)
				System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
