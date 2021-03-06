// Código criado a partir de https://docs.oracle.com/javase/tutorial/essential/concurrency/


public class Sync08 implements Runnable {
	
	private Object lock1 = new Object();
	private long v1 = 0;
	private long v2 = 0;
	
	public void met1() {
		
		long threadId = Thread.currentThread().getId();
		long v3;

		System.out.println(threadId + ": Entrando no método");

		synchronized(lock1) {
		v1 = threadId*10;
		System.out.println(threadId + ": v1 = " + v1);
		
		v2 = threadId*20;
		System.out.println(threadId + ": v2 = " + v2);
		
		v3 = v1+v2;
		System.out.println(threadId + ": v3 = " + v3);

		}
		
		

		
		System.out.println(threadId + ": Saindo do método");

		
	}

    public void run() {

		met1();
    
	}
        
    public static void main(String args[]) {
		
		
		Thread t[] = new Thread[3];
		
		int i;
		
		for(i=0; i<3; i++){
		 t[i] = new Thread(new Sync08());
		 t[i].start();
		}
			
		System.out.println("Vou encerrar o programa principals");
        
    }
    
}

