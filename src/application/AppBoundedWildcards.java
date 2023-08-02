package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class AppBoundedWildcards {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		List<Shape> myShapes = new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));

		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));

		System.out.println("Total area myShapes: " + String.format("%.2f", totalArea(myShapes)));
		System.out.println("Total area myCircles: " + String.format("%.2f", totalArea(myCircles)));
	
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
		
		//List<Integer> intList = new ArrayList<Integer>();
		//intList.add(10);
		//intList.add(5);
		
		/*List<? extends Number> list;
		list = intList;*/
		//Number x = list.get(0);
		
		/*
		list.add(20);
		Não se pode adicionar, erro de compilação,
		ninguém garante que o argumento adicionado será inteiro.
		COVARIÂNCIA: 
		Operação get = OK ; 
		Operação put = ERROR - não permite;*/
		
		//List<Object> myObjs2 = new ArrayList<Object>();
		//myObjs.add("Maria");
		//myObjs.add("Alex");
		
//		List<? super Number> myNums;
		//myNums = myObjs;
		
		//myNums.add(10);
		//myNums.add(3.14);
		

		
		//Object y = myNums.get(0); 
		
		// Number y = myNums.get(0);
		
		 	/*	Não se pode adicionar, erro de compilação,
		ninguém garante que o argumento adicionado será inteiro.
		CONTRAVARIÂNCIA: 
		Operação get = ERROR - Não permite; 
		Operação put = OK; */
		 
	}
	
	public static void copy(List<? extends Number> listOr, List<? super Number> listDest){
		for (Number numb : listOr) {
			listDest.add(numb);
		}
	}
	
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	public static double totalArea(List<? extends Shape> list) {
		double sum = 0.0;
		for (Shape s : list) {
			sum += s.area();
		}
		return sum;
	}
}
