public class Customer implements Comparable<Customer>{
    String last,first;
    String acctNo;
    double balance;
    
    public Customer(String first, String last , String acctNo, double balance) {
        this.last = last;
        this.first = first;
        this.balance = balance;
        this.acctNo = acctNo;
    }
    
    
    public String toString() {
    return "First name:" + first + " " + "\nLast name:" + last + " " + "\nAccount Number: " + acctNo + " " + "\nBalance: $" + balance + "\n ";
    }
    public String getlast() {
        return last;
    }
    
    public void setLast(String last) {
        this.last = last;
    }
    
    public String getfirst() {
        return first;
    }
    
    public void setfirst() {
        this.first = first;
    }
    
    public String getacctNo() {
        return acctNo;
    }
    
    public void setacctNo(String acctNo) {
        this.acctNo = acctNo;
    }
    
    public double getbalance() {
        return balance;
    }
    
    public void setbalance(double d) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
    	if(amount <= balance)
            balance -= amount;
    	else {
    		System.out.println("insufficient funds");
    	}
    }
    

    
    public int compareTo(Customer other) {
        int result = this.last.compareTo(other.last);
        if(result == 0) {
            result = this.first.compareTo(other.first);
        }

        return result;
    }
    
    public boolean equals(Customer other) {
    	return this.acctNo.equals(other.acctNo);
    	}
    
    
    
    //project 2
}