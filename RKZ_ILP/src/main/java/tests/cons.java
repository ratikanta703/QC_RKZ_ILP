package tests;

public class cons {
	String name;
	int id;
/*public cons()
{
	name="Ratikanta";
	id=2906;
	System.out.println("default");
}	*/
public cons(String str,int in)
{
	name=str;
	id=in;
	System.out.println("parameterized"+name);	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cons obj=new cons("virinchi",2907);
		//cons obj=new cons();
		System.out.println(obj.name);
		System.out.println(obj.id);
	}
}

//Example of Interface
/*interface Pet{
	  public void test();
	}
	class cons implements Pet{
	   public void test(){
	     System.out.println("Interface Method Implemented");
	  }
	   public static void main(String args[]){
	     Pet p = new cons();
	     p.test();
	  }
	}*/