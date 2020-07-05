package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");

		Hello setterHello = (Hello) context.getBean("setterHello");
		System.out.println(setterHello.sayHello());
		setterHello.print();

		Printer printer = context.getBean("printer", Printer.class);
		System.out.println(printer.toString());

		Hello setterHello2 = context.getBean("setterHello", Hello.class);
		System.out.println(setterHello == setterHello2);
	}
}
