package javaeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * references :
 * 1. http://www.developer.com/java/start-using-java-lambda-expressions.html
 * 
 * 
 */

class Data{
	Integer id;
	String data;
	
	public Data(Integer id, String data) {
		this.id = id;
		this.data = data;
	}
	
	static Comparator<Data>  comprators = new Comparator<Data>() {
		public int compare(Data o1, Data o2) {
			return o1.getData().compareTo(o2.getData());
		}
	};

	static Comparator<Data>  compratorsById = new Comparator<Data>() {
		public int compare(Data o1, Data o2) {
			return o2.getId().compareTo(o1.getId());
		}
	};
	
	static Comparator<Data> byIDLambda = (o1, o2)->o1.getId().compareTo(o2.getId());
		

//	 Sort by name lenght using lambda expression
	static Comparator<Data> sortByNameLenght = (Data s1, Data s2) -> s1.getData().length()- s2.getData().length(); 
	 
	@Override
	public String toString() {
		return "Data [id=" + id + ", data=" + data + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}

public class LambdaExpression {
	
	public static void main(String[] args) {

		ArrayList<Data> datas = new ArrayList<Data>();
		datas.add(new Data(1, "D 5swsd"));
		datas.add(new Data(2, "D 2d"));
		datas.add(new Data(3, "D 3ddd"));
		datas.add(new Data(4, "D 4ddddd"));

//		Collections.sort(datas, Data.compratorsById);

//		Lambda USE 1:
		datas.sort((Data d1, Data d2) -> d1.getId().compareTo(d2.getId()) );

//		Lambda USE 2:
		datas.sort((d1,d2) -> d1.getId().compareTo(d2.getId()) );

//		Lambda USE 3:
//		datas.forEach((data) -> System.out.println(data.toString()));
		
//		Reverse sorting by comparator
		datas.sort(Data.comprators.reversed());
		
//		Java 8 :: example
		datas.forEach(System.out::println);
		
//		Thread Using Lambda
		 new Thread(() -> System.out.println("I am a Thread.")).start();;
		
//		 Runnable Interface using lambda
		 Runnable runa = () -> System.out.println("I am a thread using Lambda");
		 new Thread(runa).start();
		 
//		 Sorted Using Lambda, by string length size
		 datas.sort(Data.sortByNameLenght.reversed());
		 datas.forEach((data) -> System.out.println(data));
		 
		}
}
