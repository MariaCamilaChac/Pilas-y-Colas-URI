/**
* Data Structure, List
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
**/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1025 {
	
	public  URI1025(){}
	
	public static Node head = null; //head equal null
	
	public static boolean isEmpty() { //check if the Stack is empty
		
		return head == null ? true : false;
	}
	
	public void InsertAtEnd(Node newNode) { //insert new node at the end
		if (isEmpty()) { //Verify 
			head = newNode;
		}else {
			Node temp = head;
			while(temp.next != null) {	
				temp = temp.next;
			}
		
			temp.next = newNode;	
	
		}
	}
	


	public void enqueue(Node NewNode) { //put Queue
		
		if(isEmpty()) {  // conditional using the method 
			
			head = NewNode;	
			
		}else{
			
		Node temp = head;
		
		while(temp.next != null) {  //fill the Queue
			
			temp = temp.next;
		}
		temp.next = NewNode;	
	}
}
	
	
	public static int listSize() {//Length of Queue
		
		int counter = 0;
		Node temp = head;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;		
	}
	
	public void quickSort() throws IOException {//Sort list by criterion (Quicksort)
		
		if(!isEmpty()) {//Check is empty
			
			URI1025 leftSet = new URI1025();
			URI1025 rightSet = new URI1025();
			
			Node pivot = head;
			Node temp = head.next;
			
			while(temp != null)
			{
				if(temp.Num < pivot.Num) {
					
					leftSet.InsertAtEnd(temp.clone());
					
				}else {
					
					rightSet.InsertAtEnd( temp.clone());
				}
				
				temp = temp.next;
			}
			
			leftSet.quickSort();
			rightSet.quickSort();
			
			pivot.next = rightSet.head;
			leftSet.InsertAtEnd(pivot);
			head = leftSet.head;
			
		}
	}//end method
	
	public  Node getNode(int index) { //catch the number of an specific index
		
		if(listSize()< index)
			return null;
		
		else {
			Node temp=head;
			for (int i = 0; i < index; i++) {
				temp=temp.next;
				
			}
			return temp;
			
		}
	
	}
	
	
	
	
	public int binarySearch(int index) {
		
		int  inicio = 0;
		int  finall = listSize();
		int Num=0;
		int result;
		boolean Positive = false ;
		
		while(!(Positive) && inicio <=finall ){
			int mitad = ((inicio + finall)/2);
			
			
			if ( getNode(mitad).Num == index){
				Positive = true;
				Num=mitad;
			}else
				if(index < getNode(mitad).Num)
					finall=mitad-1;
				 else
					if(index > getNode(mitad).Num)
					inicio= mitad+1;	
		
		}
		if(Positive)
			 System.out.println("found at "+ (result=Num));
		else
			System.out.println((result=-1) +" not found");
		
		
		return result;
				
	} 
	
	public void PrintList() throws IOException { //print the final list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node temp = head;
		while(temp != null) {
			
			bw.write(temp.toString()+"\n");
			temp = temp.next;
		}
		
		bw.flush();
		bw.close();
	}
	
	
	
	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		URI1025 list = new URI1025();
		Node List= new Node();
		
		bw.write("escriba el numero de canicas y el # de oportunidades \n");
		bw.flush();
		String entrada = br.readLine();
		int Num = 0;
		int tam = Integer.parseInt(entrada.split(" ")[0]); // data for the length of Queue
		int opp = Integer.parseInt(entrada.split(" ")[1]);
		
		try{
			bw.write("Escriba los numero de las canicas\n");
			bw.flush();
		
		String array = br.readLine();//read the string
		
		for(int i = 0; i < tam; i++) {
			
			list.enqueue(new Node(Integer.parseInt(array.split(" ")[i]))); // entry of marbles, and catch the numbers in the list
		
		}
		
		do{
			
			for (int j = 0; j < opp; j++) {
				bw.write("escriba el numero de su "+ (j+1) + " intento\n");
				 bw.flush();
				    Num = Integer.parseInt(br.readLine()); //number index to find in the queue
				
				    list.binarySearch(Num); //call the method of search
		
			}
		}while(opp<0);
		
		}catch(Exception ex){}
	}
	

}
