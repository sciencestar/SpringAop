package aspect;

public class AnimalActionAspect {
	
	public void beforeRunAction()
	{
		System.out.println("run order has been sent");
	}
	
	public void afterRunAction()
	{
		System.out.println("run action ended");
	}
	
	public void beforeJumpAction()
	{
		System.out.println("jump order has been sent");
	}
	
	public void afterJumpAction()
	{
		System.out.println("jump action ended");
	}
}
