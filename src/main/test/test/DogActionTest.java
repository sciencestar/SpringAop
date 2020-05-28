import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.DogAction;

public class DogActionTest {

	@Test
	public void testRun() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DogAction da = (DogAction)ctx.getBean("dogBean");
		da.run();
	}

	@Test
	public void testJump() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DogAction da = (DogAction)ctx.getBean("dogBean");
		da.jump();
	}

}
