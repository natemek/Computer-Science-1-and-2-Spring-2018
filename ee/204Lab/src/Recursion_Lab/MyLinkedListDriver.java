package Recursion_Lab;
public class MyLinkedListDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add("Sarah");
		myLinkedList.add("Barbara");
		myLinkedList.add("Tom");
		myLinkedList.add("George");
		
		String largest = myLinkedList.findLargest();
		System.out.println(largest);
		
		myLinkedList.add("Zeke");
		myLinkedList.add("Adam");
		
		largest = myLinkedList.findLargest();
		System.out.println(largest);
	}

}