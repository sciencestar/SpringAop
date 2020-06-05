package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @ClassName LogAnnotationAspect
 * @Description: TODO
 * @Author lxc
 * @Date 2020/5/28 14:15
 * @Version V1.0
 **/
@Aspect
public class LogAnnotationAspect {
    @SuppressWarnings("unused")
    //定义切入点，提供一个方法，这个方法的名字就是切入点的id
    @Pointcut("execution(* service.impl.*.*(..))")  //关联核心业务函数
    private void allMethod() {
        System.out.println("日志系统开始启动!");
    }

    //针对指定的切入点表达式选择的切入点应用前置通知
    @Before("allMethod()")
    public void before(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println("开始执行:" + className + "." + methodName + "()方法...");
    }

    //访问命名切入点来应用后置通知
    @AfterReturning("allMethod()")
    public void afterReturn(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println(className + "." + methodName + "()方法正常执行结束...");
    }

    //应用最终通知
    @After("allMethod()")
    public void after(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println(className + "." + methodName + "()最终执行步骤(finally)...");
    }

    //应用异常抛出后通知
    @AfterThrowing("allMethod()")
    public void afterThrowing(JoinPoint call) {
        String className = call.getTarget().getClass().getName();
        String methodName = call.getSignature().getName();
        System.out.println(className + "." + methodName + "()方法抛出了异常...");
    }

    //应用周围通知
    //@Around("allMethod()")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {
        Object result = null;
        this.before(call);//相当于前置通知
        try {
            result = call.proceed();
            this.afterReturn(call); //相当于后置通知
        } catch (Throwable e) {
            this.afterThrowing(call);  //相当于异常抛出后通知
            throw e;
        } finally {
            this.after(call);  //相当于最终通知
        }
        return result;
    }
}
