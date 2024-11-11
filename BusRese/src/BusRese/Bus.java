package BusRese;

public class Bus {
private int BusNo;
private String BusName;
private boolean ac;
private int capacity;

Bus(int no ,String name, boolean ac , int cap){
	this.BusNo=no;
	this.BusName=name;
	this.ac=ac;
	this.capacity=cap;
}
public int getBusNo() {
	return BusNo;
}
public boolean isac() {
	return ac;
}
public int getCapacity() {
	return capacity;
}
public void setAc(boolean val) {
	ac = val;
}
public void setCapacity(int cap) {
	 capacity=cap;
}
public void displayBusInfo() {
	System.out.print("Bus No:" + BusNo + "=>" + " Bus Name " + BusName + " Ac:" + ac + " Total Capacity: " + capacity);
}

}
