	/**
	* Data Structure, Node
	*	@author :Camila chacón
	*	@date 23-03-2019
	*	@version 1
	**/
	// this is father class or principal class


public class Node_String {

		public String Sym; //global variable
		
		public Node_String next; //pointer

		
		public Node_String() {} //empty constructor
		
		public Node_String (String strings) {
			
			this.Sym=strings;
		}
		
		
		public String toString() { //print in console
			return ""+ this.Sym; 
		}
		
		
		public Node_String clone() { //clone the principal list
			Node_String clone = new Node_String (this.Sym);
			return clone;
		}

	
}


