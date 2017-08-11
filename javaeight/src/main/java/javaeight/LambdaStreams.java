package javaeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Data2{
	Integer id;
	String data;
	
	public Data2(Integer id, String data) {
		this.id = id;
		this.data = data;
	}
	
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

	

	
public class LambdaStreams {

/*
 * references :
 * 1. http://www.developer.com/java/start-using-java-lambda-expressions.html
 * 
 * 
 */
	public static void main(String[] args) {

		ArrayList<Data> datas = new ArrayList<Data>();
		datas.add(new Data(1, "D 5swsd"));
		datas.add(new Data(2, "D 2d"));
		datas.add(new Data(3, "D 3ddd"));
		datas.add(new Data(4, "D 4ddddd"));
		
//		Using Lambda to update all entries
		Consumer<Data> datass = e -> e.setId(e.getId()+1110);
		datas.forEach(datass);
//		datas.forEach(System.out::println);
		
//		Using Streams and lambda to filter and print data in 3 lines.
//		datas.stream()
//		.filter((p) -> (p.getId() > 1112 ))
//		.forEach((data) -> System.out.println(data));
		
//		Making Predicate to do filtering 
		Predicate<Data> filterOne = new Predicate<Data>() {
			@Override
			public boolean test(Data t) {
				
				if(t.getId() > 1112)
					return false;
				else 
					return true;
			}
		};
		
//		Making filter using Lambda
		Predicate<Data> filterTwo = (d) -> d.getId() > 1112;
		
//		datas.stream().filter(filterOne).forEach(System.out::println);
		
//		Using Stream's limit 
//		datas.stream().limit(2).forEach(System.out::println);
		
//		java.util.List<Data> list3 = 
		List<Data> list4 = 
		datas.stream()
				.sorted(((d1,d2) -> d1.getId().compareTo(d2.getId())))
				.limit(3)
				.collect(Collectors.toList());
		
//		list4.forEach(System.out::println);
		
		
		Data dMax = datas.stream().max((d1,d2) -> d1.getId().compareTo(d2.getId())).get();
		Data dMin = datas.stream().min((d1,d2) -> d1.getId().compareTo(d2.getId())).get();
		System.out.println(dMax);
		System.out.println(dMin);
		
//		Joining Datas using stream for list 
		String allDatas = datas
				.stream()
				.map(d	-> d.getData())
				.collect(Collectors.joining(", "));
				
		System.out.println(allDatas);		

//		Made here a set of names using stream
		Set<String> allDatas2 = datas
				.stream()
				.map(d	-> d.getData())
				.collect(Collectors.toSet());
				
		System.out.println(allDatas2.toString());
		
		
//		Made here a set of names using stream
		TreeSet<String> allDatas3 = datas
				.stream()
				.map(d	-> d.getData())
				.collect(Collectors.toCollection(TreeSet::new));
				
		System.out.println("This is Tree Set : \n "+allDatas3.toString());		
		
//		Made a list with all ids integer
		List<Integer> allDatas4 = datas
				.stream()
				.map(d	-> d.getId())
				.collect(Collectors.toList());
				
		System.out.println("This is Tree Set : \n "+allDatas4.toString());		
		

//		Made a list with all ids integer
		int sum = datas
				.stream()
				.mapToInt(d	-> d.getId())
				.sum();
		System.out.println("This is Sum :  "+sum);
		
//		It will generate summary 
		IntSummaryStatistics summary = datas.stream().mapToInt((x) -> x.getId()).summaryStatistics();
		System.out.println(summary.toString());
	}
}


