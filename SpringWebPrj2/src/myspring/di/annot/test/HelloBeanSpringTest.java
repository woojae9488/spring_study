package myspring.di.annot.test;

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

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/annot.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;

	@Test
	public void test1() {
		Hello hello = context.getBean("hello", Hello.class);

		assertEquals("Hello Spring", hello.sayHello());
		hello.print();

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
