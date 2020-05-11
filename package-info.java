package phonebook;

//Aaron Reagan
//5/2/2020
//CS 145
//Assignment #1: Phone Book / Linked Lists
//this program will allow you to enter/edit/delete contact details
//into a phone book using linked lists


import java.util.*;

class PhoneBook { // main class and str

String contactName;
String contactAddress;
String contactCity;
String PhoneNumber;
PhoneBook next;

void add(PhoneBook pb)  {
   
}

@Override

public String toString()   { // returns string of obj.

    return "PhoneBook [contactName=" + contactName + ", contactAddress=" + contactAddress + ", contactCity=" + contactCity + ", PhoneNumber=" + PhoneNumber+ "]";
    
}

public PhoneBook(String contactName, String contactAddress, String contactCity, String phoneNumber)   {  // curr. variables

    super();
    this.contactName = contactName;
    this.contactAddress = contactAddress;
    this.contactCity = contactCity;
    PhoneNumber = phoneNumber;
    this.next = null;
    
}

}

class PhoneBookManager  {

PhoneBook start;

void display() {

    PhoneBook temp=start;
    boolean isEmpty=true;
    
    if(temp!=null)
    
        System.out.format("%-15s%-15s%-15s%-15s\n", "Name","Address","City","Number");
        
    while(temp!=null)   {
    
        System.out.format("%-15s%-15s%-15s%-15s\n", temp.contactName,temp.contactAddress, temp.contactCity, temp.PhoneNumber);
        temp=temp.next;
        isEmpty=false;
        
    }
    
    if(isEmpty)
    
        System.out.println("No Info Found in Phonebook");
   
}

void add(PhoneBook pb)  {

    PhoneBook current;
   
   if (start == null || start.contactName.compareTo(pb.contactName)>=0)   { // add head node

      pb.next = start;
      start = pb;
      
   }
   
   else  {

      current = start;

   while (current.next != null && current.next.contactName.compareTo(pb.contactName)<=-1)
  
      current = current.next;
      pb.next = current.next;
      current.next = pb;
      
   }
   
}

void modify(String PhoneNumber)  { // edit #

    PhoneBook temp=start;
    boolean found=false;
    
    
    while(temp!=null)   {
    
        if(temp.PhoneNumber.equals(PhoneNumber))   {
        
            found=true;
            break;
           
        }
        
        temp=temp.next;
        
    }
    
    if(found)  { // add new info.
    
        Scanner sc = extracted();
        System.out.println(temp.toString());
        System.out.println("Enter New Info");
        String contactName=sc.next();
        String contactAddress=sc.next();
        String contactCity=sc.next();
        String phonenumber=sc.next();
       
        temp.contactName=contactName;
        temp.contactAddress=contactAddress;
        temp.contactCity=contactCity;
        temp.PhoneNumber=phonenumber;
        System.out.println("Accepted");
        
    }
    
    else {
    
        System.out.println("Info not found");
        
    }
   
   
   
}

private Scanner extracted() {
	Scanner sc=new Scanner(System.in);
	return sc;
}

void sortList()   {
   
}

void delete(String PhoneNumber)  { // delete #

    if(start.PhoneNumber.equals(PhoneNumber))   {
    
        start=start.next;
        return;
        
    }
    
    PhoneBook temp=start;
    PhoneBook prev=null;
    boolean found=false;
    
    while(temp!=null)   {
    
        if(temp.PhoneNumber.equals(PhoneNumber))   {
        
            found=true;
            break;
           
        }
        
        prev=temp;
        temp=temp.next;
        
    }
    
    if(found)  {
    
        if(start.next!=null)
        
            prev.next=temp.next;
            
        else
        
            start=null;
            
        System.out.println("Removed");
        
    }
    
    else {
    
        System.out.println("Not found");
        
    }
   
}

}

class run

{
public static void main(String[] args) { // runs main program

    PhoneBookManager pbManager=new PhoneBookManager();
    try (Scanner sc = new Scanner(System.in)) {
		System.out.println("1.Add New Contact\n2.View Contacts\n3.Edit Contact Info\n4.Delete Contact\n5.Exit");
		   int choice=sc.nextInt();
		   
		   while(true)   {
		   
		       if(choice==1)   {
		       
		           System.out.println("Please enter contacts name");
		           String contactName=sc.next();
		           System.out.println("Please enter contacts address");
		           String contactAddress=sc.next();
		           System.out.println("Please enter contacts city");
		           String contactCity=sc.next();
		           System.out.println("Please enter contacts phone");
		           String phonenumber=sc.next();
		           PhoneBook pbook=new PhoneBook(contactName,contactAddress,contactCity,phonenumber);
		           pbManager.add(pbook);
		          
		       }
		       
		       else if(choice==2) {
		       
		           pbManager.display();
		          
		          
		       }
		       
		       else if(choice==3) {
		       
		           System.out.println("What phone # do you want to edit?");
		           String number=sc.next();
		            
		           pbManager.modify(number);
		          
		       }
		       
		       else if(choice==4) {
		       
		           System.out.println("What # do you want to delete?");
		           String number=sc.next();
		           pbManager.delete(number);
		          
		       }
		       
		       else   {
		       
		           break;
		           
		       }
		       
		       System.out.println("1.Add New Contact\n2.View Contacts\n3.Edit Contact\n4.Delete Contact\n5.Exit");
		       choice=sc.nextInt();
		              
		   }
	}
    
}

}