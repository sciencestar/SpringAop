package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName StudentServiceAspect
 * @Description: TODO
 * @Author lxc
 * @Date 2020/5/28 12:27
 * @Version V1.0
 **/
public class StudentServiceAspect {

    public void before(JoinPoint jp) {
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("开始添加学生：" + jp.getArgs()[0]);
        System.out.println("开始添加学生");
    }

    //后置通知
    public void doAfter(JoinPoint jp) {
        System.out.println("类名:" + jp.getTarget().getClass().getName());
        System.out.println("方法名：" + jp.getSignature().getName());
        System.out.println("学生添加完成：" + jp.getArgs()[0]);
    }

    //环绕通知
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("添加学生前");
        Object retVal = pjp.proceed();
        System.out.println(retVal);
        System.out.println("添加学生后");
        return retVal;
    }

    //返回通知
    public void doAfterReturning(JoinPoint jp) {
        System.out.println("返回通知");
    }

    //异常通知
    public void doAfterThrowing(JoinPoint jp, Throwable ex) {
        System.out.println("异常通知");
        System.out.println("异常信息：" + ex.getMessage());
    }
}
