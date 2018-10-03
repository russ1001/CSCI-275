package streffTask1;

public class streffTask1TEST {

	    public static void main(String[] args) {

	        String[] temp1 = MyString1.split("WordAttachedlolol", "Attached");
	        for (String s : temp1) {
	            System.out.println(s);
	        }

	        String[] temp2 = MyString1.split("Wor#dAt#tac#he#dl#ol#ol", "#");
	        for (String s : temp2) {
	            System.out.println(s);
	        }

	        
	        
	    }
	}

