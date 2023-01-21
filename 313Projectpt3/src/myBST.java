import java.io.IOException;
import java.io.PrintWriter;

public class myBST{
// node class which uses the customer class as data inside of the node
    public static class node {
        Customer customer;
         node left;
         node right;
        
        public node(Customer customer) {// node with customer as data
            this.customer = customer;
            left = null;
            right = null;
        }
    }
        Customer BSTnode = null;
         node root;
        
        public myBST() { // constructor for binary search tree
            this.root = null;
        
    }

        /*
         * method which calls insert recursion function
         * would be used to then insert the object we create into the BST
         * 
         */
        public void insert(Customer cus) {
            this.root = insertRec(root, cus);
            
        }
        /*
         * iterates through the BST and places it in either a left or right subtree depending on its sorting 
         * regarding the last names of the customer
         */
        public  node insertRec(node root, Customer cus) { // takes in node and customer
            if(root == null) { // if the root is null a new node is created with the customer data inserted into it
                root = new node(cus); 
            }
            else if(cus.compareTo(root.customer) < 0) { // if the string is less than the other string 
            	root.left = insertRec(root.left,cus); // goes towards left of the binary search tree and repeats process until it reaches a leaf node
            }
            else if(cus.compareTo(root.customer) > 0) {
            	root.right = insertRec(root.right,cus); // if the string is greater than the given customer or eqaul to it is inserted towards the right of the BST
            }
            
            else if(cus.compareTo(root.customer) == 0) {
            	root.right = insertRec(root.right,cus);
            }
        
            return root;

            
        }
        
        //traverses the bst inorder
        public void inorderRec(node root) {
            if(root == null) {
                return;
            }
            inorderRec(root.left);
            System.out.println(root.customer + " ");
            inorderRec(root.right);
        }
            
        public void inorder() {
            inorderRec(root);
        }
        //traverses the bst in preorder
        //prints out the bst in preorder onto the new textfile "output.txt"
        public void preorderRec(node root, PrintWriter writer) throws IOException {
            if(root == null) {
                return;
            }
            writer.println(root.customer.toString());
            preorderRec(root.left, writer);
            preorderRec(root.right,writer);
        }
            
        public void showPreOrder(PrintWriter writer) throws IOException {
            preorderRec(root,writer);
        }
        

        
        /*
         * iterates through the left subtree until it reaches a leaf
         * once it reaches a leaf it pulls the data from the node 
         * with return root.customer
         */
        public static Customer findMinN(node root) {
            while(root.left != null) {
                root = root.left;
            }
            return root.customer;
        }
        
        /*
         * iterates through the right subtree until it reaches a leaf
         * once it reaches a leaf it pulls the data from the node 
         * with return root.customer
         */
        public static Customer findMaxN(node root) {
            while(root.right != null) {
                root = root.right;
            }
            return root.customer;
        }
        
        /*
         * method which calls delete recursive function
         */
        public void delete(Customer key){
            this.root = deleteRec(root,key);
        }
        
        public static node deleteRec(node root, Customer person) {
            if(root == null) {
                return root;
            }
            else if(person.compareTo(root.customer) < 0) { // customer being compared to is less than given customer data //person comes first
            	root.left = deleteRec(root.left,person); // traverses through left subtree
            	}
            else if(person.compareTo(root.customer) > 0) { // customer being compared to is greater than given customer //customer comes first
            	root.right = deleteRec( root.right,person); //traverses through right subtree
            	}
            else { 
            	if(root.right == null && root.left == null) { // if key is found and theres no children to it  
            	return null; //return null
            	}
            	else if(root.right == null) { // case 2 node has one child 
            		return root.left;
            	}
            	else if(root.left == null) { // case 2 node has one child
            		return root.right;
            	}
            	else { //case 3 node has two children
            	root.customer = findMaxN(root.left);  // this is done to keep the BST rule where smaller values to the left and larger values to the right
            	root.left = deleteRec(root.left,root.customer); 
            	}
            }
            return root;
            
        }
        /*
         * checks if bst is empty or not
         */
        public boolean isEmpty() {
            return root == null;
        }
        /*
         * calls recursive search function
         * search method can be turned into boolean by changing return type to boolean
         */
        public Customer search(Customer person) {
            return searchRec(this.root, person);
        }
        
        /*
         * several test cases to see if the customer is found in the bst
         * by iterating through left and right subtrees depending on the 
         * result of the compareTo method
         * 
         */
        
        // search method that returns a customer
        public Customer searchRec(node root,Customer person) {
            if(root == null ) {
                return null;
            }
            else {
            while(root != null) {
            	if(root.customer.compareTo(person) > 0) { // traverses left subtree
            		return searchRec(root.left, person);
            	}
            	else if(root.customer.compareTo(person) < 0) { //traverses right subtree
            		return searchRec(root.right,person);
            	}
            	else if(root.customer.compareTo(person) == 0) { // if customer is found return true
            		return root.customer;
            	}
            	else { // if not return false
            		return null;
            	}
            }
            return null;
        }
      }
     
     //project 2
}

        
