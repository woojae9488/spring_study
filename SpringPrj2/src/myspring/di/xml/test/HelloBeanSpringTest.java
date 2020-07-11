package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;

	@Test
	public void test1() {
		Hello hello = context.getBean("hello", Hello.class);

		assertEquals("Hello Spring", hello.sayHello());
		hello.print();

		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}

		Printer printer = context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

	@Test
	@Ignore
	public void test2() {
		Hello hello = context.getBean("hello", Hello.class);
		Hello hello2 = context.getBean("hello", Hello.class);
		assertSame(hello, hello2);
	}

}
