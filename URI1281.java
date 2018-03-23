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

public class URI1281 {
	
	public String Product;
	public double cost;
	
	public URI1281() {}
	public URI1281 next; //pointer
	
	public URI1281(String prod , double value) {
		
		this.Product = prod;
		this.cost = value;
		
	}
	
	public String toString() {//method print list
		
		return "Producto: " + this.Product + "\tPrecio: " + this.cost + "\n";
		
	}
	
	public static URI1281 head = null; //Empty list
	
	public boolean EmptyList() {//Method Check if empty
		
		return head == null ? true : false;
		
	}//end method
	
	public void printList() throws IOException {//Method that prints the contents of the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		URI1281 temp = head;
		
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}//end method
	
	public void insertAtEnd(URI1281 newURI1281) {//Method insert at end of the list
		
		if(EmptyList()) {
			
			head = newURI1281;	
			
		}else{
			
		URI1281 temp = head;
		
		while(temp.next != null) {
			
			temp = temp.next;
		}
		temp.next = newURI1281;	
	}
}//end method
	
	public int Length(){//gets List size
		
		int counter = 0;
		URI1281 temp = head;
		
		while(temp != null)
		{
			
			counter +=1;
			temp = temp.next;
			
		}
		
		return counter;
		
	}//end method
	
	public URI1281 getNode(int index) {//Lineal Search in ths list
		
		if(Length()<index) {
			return null;
		}else {
			
			URI1281 temp = head;
			
			for (int i = 0; i < index; i++) {
				
				temp = temp.next;
				
			}
			
			return temp;
			
		}
		
	}//end method
	
	public static void main(String[] args) throws IOException {
		
		URI1281 U = new URI1281();
		URI1281 temp = U.head;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("shopping\n");
		bw.flush();
		int Shop = Integer.parseInt(br.readLine());
		int Cant = 0;
		double Final = 0.0;
		double cont = 0.0;
		for (int i = 0; i < Shop; i++) {
			
			bw.write("Numero de prodctos a comparar \n");
			bw.flush();
			
			int T = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < T; j++) {
				
				bw.write("Escriba primero el nombre del producto y luego el precio del mismo \n");
				bw.flush();
				U.insertAtEnd(new URI1281(br.readLine(),Double.parseDouble(br.readLine())));
				
			}
			
			U.printList();
			int t = U.Length();
			System.out.println(t);
			
			URI1281 temp_2 = head;
			for (int j = 0; j < t; j++) {
				
				bw.write("how many products " + temp_2.Product + "\n");
				bw.flush();
				Shop = Integer.parseInt(br.readLine());
				Final = Shop * (temp_2.cost);
				cont += Final;
				temp_2 = temp_2.next;
					
			}
			
			bw.write("are : " + "$"+cont);
			bw.flush();
			
		}
		
		
	}
	
	

}