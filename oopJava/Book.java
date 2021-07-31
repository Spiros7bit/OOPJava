package src.oopJava;

/*
Author: Spyros Tsioupros
Year: 2021

1st year university project
*/

import java.util.Scanner;

//class that creates book objects
public abstract class Book {
      
    //variables
    private String title;
    private String fullName;
    private String ISBN;
    private String publisher;
    private int pages;
    private int publYear;
    private double price;
    
    //constructors
    public Book(){}

    public Book(String ISBN){
        this.ISBN = ISBN;
    }

    public Book(String title, String fullName, String ISBN, String publisher, int pages, int publYear, double price){
        this.title = title;
        this.fullName = fullName;

        while (!correctISBN(ISBN)){
			System.out.print("False ISBN. Enter new ISBN: ");
			ISBN = new Scanner(System.in).nextLine();
		}
		this.ISBN = ISBN;

        this.publisher = publisher;
        this.pages = pages;
        this.publYear = publYear;
        this.price = price;

    }
    
    //methods

    //get@ methods
    abstract String getBookCategory();

    
    public String getTitle(){
        return title;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public String getISBN(){
        return ISBN;
    }
    
    public String getPublisher(){
        return publisher;
    }
    
    public int getPages(){
        return pages;
    }
    
    public int getPublYear(){
        return publYear;
    }
    
    public double getPrice(){
        return price;
    }

    //set@ methods
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public void setISBN(String isbn){

        while (!correctISBN(isbn)){
			System.out.print("False ISBN. Enter new ISBN: ");
			isbn = new Scanner(System.in).nextLine();
		}
		ISBN=isbn;
    }
    
    public void setEkdotis(String publisher){
        this.publisher = publisher;
    }
    
    public void setSel(int pages){
        this.pages = pages;
    }
    
    public void setEtEkd(int publYear){
        this.publYear = publYear;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    //toString method
     public String toString(){
        return "Title: "+title+", Full Name: "+fullName+", ISBN: "+ISBN+", Publisher: "+publisher+", Pages: "+pages+", Year of Publish: "+publYear+", Price: "+price;
    }

    
    //method to check the input ISBN
    public static boolean correctISBN(String isbn){
       
        //initialize of sum
        int sum = 0;
        
        //if digits of isbn isn't 10 or 13 then ISBN is false
        if(isbn.length() != 13 && isbn.length() != 10){
            return false;
        }
    
        //else
            if(isbn.length() == 10){//if digits are 10 then do...
        
                for(int i = 0; i < isbn.length(); i++){
                    String s = String.valueOf(isbn.charAt(i));
                    int temp = Integer.parseInt(s);//trandform the i-st character to integer
                    temp = temp*(isbn.length()-i);//multiplication with right factor
                    sum += temp;//sum
                }//end of "10 digits" for
                //check the sum
                if(sum%11 == 0)
                    return true;
                /*else
                    return false;*/  
            }//end of "10 digits" if 

            else if(isbn.length() == 13){//if digits are 13 then do...
                
                for(int i = 0; i < 13; i++){
                    
                    String s = String.valueOf(isbn.charAt(i));
                    int temp = Integer.parseInt(s);//trandform the i-st character to integer
                    
                        if(i%2 == 0){  //if digit is at event number index the factor is 3
                            temp = temp*1;
                            sum += temp;//sum  
                        }
                        else{ //else if digit isn't at event number index the factor is 1
                            temp = temp*3;
                            sum += temp;//sum 
                        }
                }//end of "13 digits" for
                        //check the sum
                        if(sum%10 == 0)
                            return true;
                        /*else
                            return false;*/
            }//end of "13 digits" if 

            return false;
        
    }
}
