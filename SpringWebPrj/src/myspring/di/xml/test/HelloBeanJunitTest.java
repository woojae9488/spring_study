package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	ApplicationContext context;

	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}

	@Test
	public void test2() {
		Hello setterHello = context.getBean("setterHello", Hello.class);
		Hello setterHello2 = context.getBean("setterHello", Hello.class);
		assertSame(setterHello, setterHello2);
	}

	@Test
	@Ignore
	public void test1() {
		Hello setterHello = (Hello) context.getBean("setterHello");
		Assert.assertEquals("Hello Spring", setterHello.sayHello());
		setterHello.print();

		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
}
