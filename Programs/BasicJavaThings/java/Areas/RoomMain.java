class Room{
	int length,breadth;
	Room(){
		length=10;
		breadth=20;
	}
	Room(int x,int y){
       length=x;    
       breadth=y;
	}
	public void area() {
		System.out.println(length*breadth);
	}
}
public class RoomMain{
	public static void main(String[] args) {
		Room r1=new Room();
		Room r2=new Room(30,40);//initialied r2 with the object of this class
		r1.area();
		r2.area();
		System.out.println("1)----------------------------");
		r1.length=50;
		r2.length=60;
		r1.area();
		r2.area();
		System.out.println("2)----------------------------");
   		r2=r1;  //both the obj ref variables are pointing to the same address in the heap memory.
   		r1.length=70;
   		r2.breadth=80;
   		r1.area();
		r2.area();
		System.out.println("----------------------------");
	}
}
