package Linked_List;

public class test {

	public static void main(String[] args) {
		LinkedList A = new LinkedList();
		A.append(2);
		A.append(1);
		A.append(2);
		A.append(3);
		A.append(4);
		A.append(4);
		A.append(2);
		A.print();
		System.out.println("---------");
		A.removeDups();
		A.print();
	}

}
