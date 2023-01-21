import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class BankCustomers {
    public static myBST tree;
    static String accountName;
    static String accountLname;
    static String accountNumb;
    static String inputt;
    static double amount;
    static Customer[] AcctDB = new Customer[10000]; // array of customers

    
    public BankCustomers() {
        tree = new myBST();// new tree created to hold in the values of the text file being read
    }
    
    	
    public static void load(myBST tree) {

        File file = new File("logOfBankCustomers.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] c = line.split(" ");

            Customer custom = new Customer(c[0],c[1],c[2],Double.parseDouble(c[3]));
            tree.insert(custom);
            AcctDB[Integer.parseInt(custom.getacctNo())] = custom;
        }

        scan.close();
    }
    


public static void menuDisplay() { // menu option display for person to use
	   String menu = "1. Make a deposit to existing customer account." 
			   + "\n2. Make a withdrawal from existing customer account."
			   + "\n3. Check balance of an existing customer account."
			   + "\n4. Open a new customer account."
			   + "\n5. Close a customer account "
			   + "\n6. Exit the program.";
	   		System.out.println(menu);
   }
   


   public static void main(String[] args) throws IOException{
        Scanner Keyboard = new Scanner(System.in); // reads in customer input // scans through input in the case of a file it scans the file
        BankCustomers bCustomer = new BankCustomers(); 
        load(tree);
        
        while(true) {
        	menuDisplay();
        	System.out.println();
        
        	int customerOption = Keyboard.nextInt();
        	
        	switch (customerOption) {
            case 1: // supposed to search for an account based on name and then make a deposit to the account 
            	System.out.println("Press 1 to search by account number or press 2 to search by name"); // gives user options on how to search for an account 
            	inputt = Keyboard.next();
            	if(inputt.equals("1")) {
            		System.out.println("Enter account number");
            		accountNumb = Keyboard.next();
                	System.out.println("\n Enter amount you wish to deposit: ");
                	amount = Keyboard.nextDouble();
            		Customer cTemp = AcctDB[Integer.parseInt(accountNumb)]; 
            		cTemp.deposit(amount);
            	}
            	else if(inputt.equals("2")){
            	
            	System.out.println("Enter account  first name: ");
            	accountName = Keyboard.next();
            	System.out.println("Enter account last name: ");
            	accountLname = Keyboard.next();

            	Customer p1 = new Customer(accountName, accountLname,accountNumb,0); // creates a temp customer object with the attributes we're looking for from the actual customer
            	if(tree.search(p1) == null) { // temp object is searched for in the bst to find a customer with the same attributes
            		System.out.println("Customer does not exist");
            	}
            	else {
            	System.out.println("\n Enter amount you wish to deposit: ");
            	amount = Keyboard.nextDouble();
            	Customer temp1 = tree.search(p1); // if found a new customer object is created to use a reference to the actual customer which we're going to manipulate
            	temp1.deposit(amount);
            	}
            	}


            	break;
            
            case 2: // withdraws money from the account
            	System.out.println("Press 1 to search by account number or press 2 to search by name");
            	inputt = Keyboard.next();
            	if(inputt.equals("1")) {
            	System.out.println("Enter account number:");
            	accountNumb = Keyboard.next();
                	System.out.println("\n Enter the amount you wish to withdraw: ");
                	amount = Keyboard.nextDouble();
            		Customer ctemp2 = AcctDB[Integer.parseInt(accountNumb)];
            		ctemp2.withdraw(amount);
            	}
            	else if(inputt.equals("2")){
            	System.out.println("Enter account  first name: ");
            	accountName = Keyboard.next();
            	System.out.println("Enter account last name: ");
            	accountLname = Keyboard.next();
            	Customer p2 = new Customer(accountName, accountLname,accountNumb,0);
            	if(tree.search(p2) == null) {
            		System.out.println("Customer does not exist");
            	}
            	else {
            	System.out.println("\n Enter amount you wish to withdraw: ");
            	amount = Keyboard.nextDouble();
            	Customer temp2 = tree.search(p2);
            	temp2.withdraw(amount);
            	}
            	}
            	break;

            case 3: // supposed to check balance of an account 
            	System.out.println("Press 1 to search by account number or press 2 to search by name");
            	inputt = Keyboard.next();
            	if(inputt.equals("1")) {
            	System.out.println("Enter account number:");
            	accountNumb = Keyboard.next();
            		Customer ctemp3 = AcctDB[Integer.parseInt(accountNumb)];
            		System.out.println(ctemp3.getbalance());
            	}
            	else if(inputt.equals("2")) {
            	System.out.println("Enter account  first name: ");
            	accountName = Keyboard.next();
            	System.out.println("Enter account last name: ");
            	accountLname = Keyboard.next();
            	Customer p3 = new Customer(accountName, accountLname,accountNumb, 0);
            	if(tree.search(p3) == null) {
            		System.out.println("Customer does not exist");
            	}
            	else {
            		Customer temp3= tree.search(p3);
                	System.out.println(temp3.getbalance());
            	}
            	}
            	
            	break;
            	


            
            
            case 4: // makes a new account and insert into the bst and array 
            	System.out.println("Enter account  first name: ");
            	accountName = Keyboard.next();
            	System.out.println("Enter account last name: ");
            	accountLname = Keyboard.next();
            	System.out.println("Enter account number: ");
            	accountNumb = Keyboard.next();
	            System.out.println("Enter a deposit: ");
	            amount = Keyboard.nextDouble();
	            Customer cust4 = new Customer(accountName,accountLname,accountNumb,amount);
	            tree.insert(cust4);
	            AcctDB[Integer.parseInt(accountNumb)] = cust4;
	            

	            break;
            
            case 5: // deletes a bank account 
            	System.out.println("Press 1 to search by account number or press 2 to search by name");
            	inputt = Keyboard.next();
            	if(inputt.equals("1")) {
            	System.out.println("Enter account number:");
            	accountNumb = Keyboard.next();
            		Customer newtemp = AcctDB[Integer.parseInt(accountNumb)];
            		tree.delete(newtemp);
            		AcctDB[Integer.parseInt(accountNumb)] = null;
            	}
            	else if(inputt.equals("2")) {
            	System.out.println("Enter account  first name: ");
            	accountName = Keyboard.next();
            	System.out.println("Enter account last name: ");
            	accountLname = Keyboard.next();
	            Customer p4 = new Customer(accountName,accountLname,accountNumb, 0);
	            if(tree.search(p4) == null) {
	            	System.out.println("Customer does not exist");
	            }
	            else {
	            Customer temp4 = tree.search(p4);
	            tree.delete(temp4);
	            AcctDB[Integer.parseInt(temp4.getacctNo())] = null;
	            }
            	}
            break;
            
            case 6:
                PrintWriter output = new PrintWriter("Output.txt");
                tree.showPreOrder(output);
                output.flush();
                output.close();
                System.exit(0);
            break;
        }
        
    }
   }
}
//project 2
   