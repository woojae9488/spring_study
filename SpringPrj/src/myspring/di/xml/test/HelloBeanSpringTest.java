package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Assert;
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
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;

	@Test
	@Ignore
	public void test2() {
		Hello constructerHello = context.getBean("constructerHello", Hello.class);
		Hello constructerHello2 = context.getBean("constructerHello", Hello.class);
		assertSame(constructerHello, constructerHello2);
	}

	@Test
	public void test1() {
		Hello constructerHello = (Hello) context.getBean("constructerHello");
		Assert.assertEquals("Hello Spring", constructerHello.sayHello());
		constructerHello.print();

		assertEquals(3, constructerHello.getNames().size());
		List<String> list = constructerHello.getNames();
		for (String value : list) {
			System.out.println(value);
		}

		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
}
