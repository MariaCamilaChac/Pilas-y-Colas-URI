/**
* Data Structure, List
*	@author :Camila chacón
*	@date 23-03-2019
*	@version 1
**/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class URI1068 {
	
	public URI1068() {}
	
	
	public static Node_String head = null;
	
	public boolean isEmpty(){
		return head == null ? true: false;
	}
	

	public void enqueue(Node_String NewNode) { //put Queue
		
		if(isEmpty()) {  // conditional using the method 
			
			head = NewNode;	
			
		}else{
			
		Node_String temp = head;
		
		while(temp.next != null) {  //fill the Queue
			
			temp = temp.next;
		}
		temp.next = NewNode;	
		}

	}
	public int StringSize(){
	int counter=0;
	Node_String temp=head;
	while(temp !=null){
		counter +=1;
		temp=temp.next;
		
	}
	return counter;
	

	}
	
	
public boolean Contains(String Letter) {
		
		
		boolean ToF = false;
		
		Node_String temp = head;
		
		for (int i = 0; i < StringSize(); i++) {
			
			 if(temp.Sym != Letter){
				
				ToF = false;
			}else

			if(temp.Sym == Letter) {
				
				ToF = true;
			
				
			}
			
			temp = temp.next;
			
		}	
		
		return ToF;
	}


	
	public void PrintList() throws IOException { //print the final list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		Node_String temp = head;
		while(temp != null) {
			
			bw.write(temp.toString()+"\n");
			temp = temp.next;
		}
		
		bw.flush();
		bw.close();
	}
	


	
	public static void main(String[] args) {
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		URI1068 list = new URI1068();
		
		int dato=0;

		
		try {
			
			String array = br.readLine();// create the String to read the numbers
			dato= array.length();
			
		
			do{	
			
				for(int i = 0; i < dato; i++){  
				
				
					list.enqueue(new Node_String(array.split("")[i])); // fill the queue with the numbers
				
				}
					
					int cont = 0; //create variables

					//for (int i = 0; i < list.StringSize(); i++) {
					
						if(list.Contains("(")==false)
						cont++;
						System.out.println(cont);
						if(list.Contains(")")==false)
							cont++;
						System.out.println(cont);
						/*if(cont > 0)
						
							if(list.Contains(")")==true){
							
							
								cont-=1;
						System.out.println(cont);}
							else{
							
							cont =-1;
							
									break;
								}
			System.out.println(cont);
				*/
				if(cont!=0){
					bw.write("incorrect\n");
					bw.flush();
						
				}
				if(cont==0){
					bw.write("correct\n");
					bw.flush();
	
				
				}
				

			}while(dato ==0);
		


		}catch  (Exception ex){}
}
}