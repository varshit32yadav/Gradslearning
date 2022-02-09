class Room{
	int length,breadth;
	Room(){
		this("abc");//constructor call statement should be always the First Statement.
		System.out.println("Ans is :");

	}
	Room(String str){
      System.out.println("--------------------");
	}
	Room(int length,int breadth){
	   this();
       this.length=length;    
       this.breadth=breadth;
       this.area();//to invoke area method everytime after values are assigned.
	}
	public void area() {
		System.out.println(length*breadth);
	}
}
public class RoomMain2{
	public static void main(String[] args) {
		
		Room r1=new Room(30,40);
		Room r2=new Room(50,60);
		Room r3=new Room(70,80);
		Room r4=new Room(90,100);
	}
}