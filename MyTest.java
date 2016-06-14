package factoryw.com.myArtifact;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyTest {
	
	private int operand1;
	private int operand2;
	private String operation;
	private double  result;

	    
	 @Parameters
	    public static Collection<String[]> data()  {
	    	
	    	Collection<String[]> transform = new ArrayList<>();
			try {
				Path dir = Paths.get(System.getProperty("user.dir"));
				System.out.println(dir);
				Files.lines(Paths.get(dir+"/file.txt")).forEach(p->transform.add(p.split(";")));
				
				/*Collection<String> collection = Files.lines(Paths.get(dir+"/src/MyPackage/file.txt")).collect(Collectors.toList());
		        for(String col:collection){ transform.add(col.split(";")); }*/
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
			return transform;				    	
	    }

		public MyTest (String operand1,String operand2,String operation,String result) {

	        this.operand1 = Integer.parseInt(operand1);
	        this.operand2 = Integer.parseInt(operand2);
	        this.operation = operation;
	        this.result = Double.parseDouble(result);
	    }
		
	    private static final double DELTA = 1e-15;	 

		@Test
	    public void MyTest() {

			switch (operation) {
			case "+":{assertEquals(operand1 + operand2, result,DELTA);break;}
			case "-":{assertEquals(operand1 - operand2, result,DELTA);break;}
			case "*":{assertEquals(operand1 * operand2, result,DELTA);break;}
			case "/":{assertEquals(operand1 / operand2, result,DELTA);break;}
			default:throw new IllegalArgumentException("Operation must be +,-,*,/");
			}

		}
}