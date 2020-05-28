package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IStudent;

/**
 * @ClassName TestProxy
 * @Description: TODO
 * @Author lxc
 * @Date 2020/5/28 12:44
 * @Version V1.0
 **/
public class TestProxy {

    @Test
    public void testPro(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        IStudent people =(IStudent) ac.getBean("studentImpl");
        people.addStudent("zhangsna");
    }
}
