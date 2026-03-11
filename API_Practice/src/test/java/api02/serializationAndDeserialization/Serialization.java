package api02.serializationAndDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.testng.annotations.Test;


class Demo implements Serializable{
	public int num;
	public String name;
	public Demo(int num,String name) {
		this.num=num;
		this.name=name;
	}
}
public class Serialization {
	@Test
	public void testSerialization() {
		Demo d=new Demo(101,"Tester");
		String fileName="SerializedFile.ser";
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream obj=new ObjectOutputStream(fos);
			obj.writeObject(d);
			obj.flush();
			obj.close();
			System.out.println("Demo object is serialized");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	@Test
	public void testDeserialized() {
		Demo ref=null;
		
		try {
			FileInputStream fis=new FileInputStream("SerializedFile.ser");
			ObjectInputStream obj=new ObjectInputStream(fis);
			ref=(Demo)obj.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(ref.num);
		System.out.println(ref.name);
	}

}
