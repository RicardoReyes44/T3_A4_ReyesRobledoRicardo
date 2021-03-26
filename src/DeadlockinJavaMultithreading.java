
public class DeadlockinJavaMultithreading {

	public static void main(String[] args)
	 {
	     // creating one object
	     Shared s1 = new Shared();

	     // creating second object
	     Shared s2 = new Shared();

	     // creating first thread and starting it
	     Thread1 t1 = new Thread1(s1, s2);
	     t1.start();

	     // creating second thread and starting it
	     Thread2 t2 = new Thread2(s1, s2);
	     t2.start();

	     // sleeping main thread
	     Util.sleep(2000);
	 }

}


//Java program to illustrate Deadlock
//in multithreading
class Util
{
 // Util class to sleep a thread
 static void sleep(long millis)
 {
     try
     {
         Thread.sleep(millis);
     }
     catch (InterruptedException e)
     {
         e.printStackTrace();
     }
 }
}

//This class is shared by both threads
class Shared
{
 // first synchronized method
 synchronized void test1(Shared s2)
 {
     System.out.println("test1-begin");
     Util.sleep(1000);

     // taking object lock of s2 enters
     // into test2 method
     s2.test2();
     System.out.println("test1-end");
 }

 // second synchronized method
 synchronized void test2()
 {
     System.out.println("test2-begin");
     Util.sleep(1000);
     // taking object lock of s1 enters
     // into test1 method
     System.out.println("test2-end");
 }
}

