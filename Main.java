package m24;
interface MyInterface
{
   /* compiler will treat them as: 
    * public abstract void method1();
    * public abstract void method2();
    */
   public void method1();
   public void method2();
}



public class Main implements MyInterface {
	
	 public void method1()
	   {
		System.out.println("implementation of method1");
	   }
	   public void method2()
	   {
		System.out.println("implementation of method2");
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyInterface obj = new Main();
		obj.method1();
		obj.method2();
		
	}

}
