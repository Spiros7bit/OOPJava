package src.oopJava;

/*
Author: Spyros Tsioupros
Year: 2021

1st year university project
*/

import java.util.Scanner;

//main class
public class Main {

    //static attributes
    static int k = 5; //variable legth of array vivlia (k <= 10)
    static boolean isSortISBN = false; //logic variable to check if array is sorted respect to isbn or publish year
    static boolean isSortEtEkd = false;
    //constant
    static final int N = 10;//capacity of array
    
    //------------------------------------Main method
    public static void main(String[] args){

        //--------------variables
        int selec;//user's selection
        int epilEpeks; 
        int bookCategory;
        //------------initialize vivlia array
        Book[] vivlia = new Book[N];
        /* 
        *
        random initialize
        */
        vivlia[0] = new Science("Engineer", "Microelectronics", "Konstantinos Hatzopoulos", "9781572580145", "Tziola", 1001, 2002, 110.5);
        vivlia[1] = new Science("Physics", "Quantum Mechanics 2", "Tai Hunduminda", "9780385737951", "Hindi-English Publishers", 910, 2008, 90.2);
        vivlia[2] = new Dictionary(10000, "English-Greek Language", "Matthew McChristopher", "9783453401372", "Iakinthos", 1000, 2007, 70.9);
        vivlia[3] = new Dictionary(1000, "Spanish-Greek Dictionary", "Sandy Cazorlia", "9780155658110", "Santa Publizer", 100, 1992, 20);
        vivlia[4] = new Science("Mathematics", "Linear Algebra & Complex Numbers", "Panagiotis Henry", "9781292061429", "Pythagoras", 820, 2000, 75.5);
        /*
        *
        *
        *
        *
        */


        do{
        mainMenu();//main menu display
        
        selec = new Scanner(System.in).nextInt();//user's selection
        
        switch(selec){//main switch
            
            //##################################case 1
            case 1: { 
            
                ++k;//increment the variable length of book array

                if(k <= N ){//if k is out of capacity go to else 
                    
                    //enter title
                    System.out.println("\n\nEnter title: ");
                    String titl = new Scanner(System.in).nextLine();
                    
                    //enter author name
                    System.out.println("\nEnter author full name: ");
                    String fullName = new Scanner(System.in).nextLine();
                    
                    //enter publish year      
                    System.out.println("\nEnter year of publish: ");
                    int publYear = new Scanner(System.in).nextInt();
                
                    //enter isbn
                    System.out.println("\nEnter ISBN: ");
                    String isbn = new Scanner(System.in).nextLine();

                    //enter publisher
                    System.out.println("\nEnter publisher: ");
                    String publisher  = new Scanner(System.in).nextLine();
                
                    //enter page number
                    System.out.println("\nEnter number of pages: ");
                    int pages = new Scanner(System.in).nextInt();

                    //enter price
                    System.out.println("\nEnter price: ");
                    double timi = new Scanner(System.in).nextDouble();

                    //enter book category
                    do{//user's selection for defin the book category 1.Science, 2.Dictionary
                        System.out.println("\nEnter book category: ");
                        System.out.println("1-->Science\n2-->Dictionary");
                        bookCategory = new Scanner(System.in).nextInt();

                    }while(bookCategory > 3);

                    if(bookCategory == 1){
                        System.out.println("\nEnter science field: ");
                        String sci = new Scanner(System.in).nextLine();

                        vivlia[k-1] = new Science(sci, titl, fullName, isbn, publisher, pages, publYear, timi);//downcast Book --> Science
                    }
                    else{
                        System.out.println("\nEnter number of translated words: ");
                        int dict = new Scanner(System.in).nextInt();

                        vivlia[k-1] = new Dictionary(dict, titl, fullName, isbn, publisher, pages, pages, timi);//downcast Book --> Dictionary

                    }
                    
                    break;//end of "for"

                }//end of if

                else{
                    System.out.println("\nThere is no space for more books");
                }
 
                
            } break;//end of case 1
            
            //##################################case 2
            case 2:{
                if(k == 0){ //if there are 0 books on vivlia[] you can't enter to case 2
                    System.out.println(" The libary is empty...");
                    break;
                }

                do{//if the user's selection is over 4 then go back to main menu

                eplEpeksergasias();//selection2 menu

                epilEpeks = new Scanner(System.in).nextInt();//user's selection

                switch(epilEpeks){

                    case 1:{ //search of book in vivlia[]
                        searchBook(vivlia);

                    } break;//back to main menu


                    case 2:{ //sort of books in vivlia[]
                        sortArray(vivlia);
                    
                    } break;//back to main menu


                    case 3:{ //print books between two prices (from.....to)
                        metaksiTimwn(vivlia);
                    } break;//back to main menu


                    case 4:{ //display all books of vivlia[]
                        displayFullInformations(vivlia);
                    } break;//back to main menu


                }

                }while(epilEpeks < 5);

            }break;//end of case 2

            //##################################case 3
            case 3:{
                if(k == 0){ //if there are 0 books on vivlia[] you can't enter to case 3
                    System.out.println(" The libary is empty...");
                    break;
                }

        
                int epilPwl;

                do{
                    menuSelThree();// display menu
                    epilPwl = new Scanner(System.in).nextInt();//user's selection

                    switch(epilPwl){
                        case 1:{
                            //enter books for sale
                            eisagwgiVivlPwlish(vivlia);

                        }break;


                        case 2:{
                            //calculate incomes from sale of every book category (dictionary, science) and the sum of these 
                            DaySales.incomeFromSales(vivlia);

                        }break;


                        case 3:{
                            //the arrays vivlia[], antitypaSales[] and pSales[] matche same indexes to the same data
                            System.out.println("\nThe dialy Best-Seller is: " + vivlia[DaySales.dailyBestSeller()].getTitle());  

                        }break; 


                        case 4:{
                            //display info about sales if books
                            DaySales.displaySales(vivlia);

                        }break;
                    }


                }while(epilPwl < 5);

            }break;//end of case 3

        }//end of main switch



        }while(selec < 4);//end of program with selec >= 5 
     
        
    }
    

    //-----------------------------------secondary methods

     //method for algorithm to choose the right searching algorith (linear or binary) if array is sorting or not
    public static void searchBook(Book[] vivlia){
        int epilogiAnaz;
                    
        do{
            secMenu();
            epilogiAnaz = new Scanner(System.in).nextInt();
            
            if(epilogiAnaz == 1){

                System.out.println("Enter book's isbn that you looking for: ");//enter of searching book's isbn
                String givenIsbn = new Scanner(System.in).nextLine();

                if(isSortISBN == false){ //if array isn't sort respect to ISBN...
                    if(MyUtils.seqSearch(vivlia, givenIsbn) != -1)//if found
                        System.out.println("The book found!");
                    else                                                        
                        System.out.println("Unfortunatly, book not found");

                    return;
                    } 

                //else if(isSortISBN == true)
                    if(MyUtils.binSearch(vivlia, givenIsbn) != -1)//if found
                        System.out.println("The book found!");
                    else                                                        
                        System.out.println("Unfortunatly, book not found");
            }//end if(epilAnaz == 1)


            else if(epilogiAnaz == 2){

                System.out.println("Dose etos ekdosis tou vivliou pou anazitas: ");//enter of searching book's publish year
                int givenEtKik = new Scanner(System.in).nextInt();

                if(isSortEtEkd == false){//if array is sort respect to ISBN...
                    if(MyUtils.seqSearch(vivlia, givenEtKik) != -1)//if found
                        System.out.println("The book found!");
                    else                                                        
                        System.out.println("Unfortunatly, book not found");

                    return;
                    } 

                //else if(isSortEtEkd == true)
                    if(MyUtils.binSearch(vivlia, givenEtKik) != -1)//if found
                        System.out.println("The book found!");
                    else                                                        
                        System.out.println("Unfortunatly, book not found");
            } //end if(epilAnaz == 2)
            

        }while(epilogiAnaz < 3);
        
        return;//end
    
    }

    //method that call method-algorithm for sorting
    public static void sortArray(Book[] vivlia){

        if(k == 0)
            System.out.println("The libary is empty...");

        else{
               
                int epilTaks;//user select for sorting field (Full name, isbn, publish year, price)
                int epilMethod;//user select for sorting method-algorithm

   
                do{
                    epilTaks();//display menu
                    epilTaks = new Scanner(System.in).nextInt();//user's input

                    if(epilTaks == 1){//--------------block for sorting respect to author's name
                        epilMethod();//display the menu of sorting algorithms
                        epilMethod = new Scanner(System.in).nextInt();//user's input for sorting method-algorithms

                        if(epilMethod == 1){ MyUtils.bubbleSortFullName(vivlia);}
                        else if(epilMethod == 2){ MyUtils.insertSortFullName(vivlia);}
                        else if(epilMethod == 3){ MyUtils.selectSortFullName(vivlia);}
                        else if(epilMethod == 4){ MyUtils.quickSortFullName(vivlia);}
                        else if(epilMethod == 5){ MyUtils.mergeSortFullName(vivlia);}

                    }
                    else if(epilTaks == 2){//--------------block for sorting respect to ISBN
                        epilMethod();//display the menu of sorting algorithms
                        epilMethod = new Scanner(System.in).nextInt();//user's input for sorting method-algorithms
                        
                        if(epilMethod == 1){MyUtils.bubbleSortISBN(vivlia);}
                        else if(epilMethod == 2){MyUtils.insertSortISBN(vivlia);}
                        else if(epilMethod == 3){MyUtils.selectSortISBN(vivlia);}
                        else if(epilMethod == 4){MyUtils.quickSortISBN(vivlia);}
                        else if(epilMethod == 5){MyUtils.mergeSortISBN(vivlia);}

                    }
                    else if(epilTaks == 3){//--------------block for sorting respect to publish year
                        epilMethod();//display the menu of sorting algorithms
                        epilMethod = new Scanner(System.in).nextInt();//user's input for sorting method-algorithms
                        
                        if(epilMethod == 1){ MyUtils.bubbleSortEtEkd(vivlia);}
                        else if(epilMethod == 2){ MyUtils.insertSortEtEkd(vivlia);}
                        else if(epilMethod == 3){ MyUtils.selectSortEtEkd(vivlia);}
                        else if(epilMethod == 4){ MyUtils.quickSortEtEkd(vivlia);}
                        else if(epilMethod == 5){ MyUtils.mergeSortEtEkd(vivlia);}

                    }
                    else if(epilTaks == 4){//--------------block for sorting respect to price
                        epilMethod();//display the menu of sorting algorithms
                        epilMethod = new Scanner(System.in).nextInt();//user's input for sorting method-algorithms

                        if(epilMethod == 1){ MyUtils.bubbleSortPrice(vivlia);}
                        else if(epilMethod == 2){ MyUtils.insertSortPrice(vivlia);}
                        else if(epilMethod == 3){ MyUtils.selectSortPrice(vivlia);}
                        else if(epilMethod == 4){ MyUtils.quickSortPrice(vivlia);}
                        else if(epilMethod == 5){ MyUtils.mergeSortPrice(vivlia);}

                    }

                }while(epilTaks < 5);//---------------exit from sorting field

                
               
           }

        return;

    }

    //method for user's 2 inputs (1st input "from"....2nd input "to") prices 
    public static void metaksiTimwn(Book[] vivlia){
        //attributes
        double from;
        double to;
                
        //user enters the 2 prices
        System.out.println("Enter a price area from: ");
        from = new Scanner(System.in).nextDouble();
        System.out.println("To: ");
        to = new Scanner(System.in).nextDouble();
        
        MyUtils.valueSearch(from, to, vivlia);
    }

    //method to display all informations about vivlia's objects
    public static void displayFullInformations(Book[] vivlia){

        for(int i = 0; i < k; i++){
            System.out.println("\n~Book: #"+ (i+1)+"----------------");
            System.out.println("~Title: "+vivlia[i].getTitle());
            System.out.println("~Full name: "+vivlia[i].getFullName());
            System.out.println("~ISBN: "+vivlia[i].getISBN());
            System.out.println("~Publisher: "+vivlia[i].getPublisher());
            System.out.println("~Pages: "+vivlia[i].getPages());
            System.out.println("~Publish year: "+vivlia[i].getPublYear());
            System.out.println("~Price: "+vivlia[i].getPrice());
            
        }
    }
 
    //method that user enter isbn of book for sale
    public static void eisagwgiVivlPwlish(Book[] vivlia){
        
        //attributes
        String isbn;

        System.out.println("Enter isbn of book that is sold: ");
        isbn = new Scanner(System.in).nextLine();//user's input

        DaySales.copyBookSalesPlus(isbn, vivlia);

    }

    //-----------------------------------display menu methods
    //method to display case 3 menu
    public static void menuSelThree(){

        System.out.println("\n  Choices to manage sales");
        System.out.println("1. Register new sale");
        System.out.println("2. Sow income from sales");
        System.out.println("3. Daily best-seller");
        System.out.println("4. Show informations of all sales");
        System.out.println("5. Go back to the main list of choices");
        System.out.println("Give a choice (1-5)");
    
    }

    //method to display main menu
    public static void mainMenu(){

        System.out.println("\n\nSelection list");
        System.out.println("1.   Enter a Book");     
        System.out.println("2.   Procces the registered books");
        System.out.println("3.   Sale a book");
        System.out.println("4.   Finish the program");
        System.out.println("Give a choice (1-4):");
    }
    
    //method to display case 2 method
    public static void secMenu(){
        
        System.out.println("\n\n    Select searching method: ");
        System.out.println("1. ISBN ");
        System.out.println("2. Publish year");
        System.out.println("3. Go back to the main list of choices");
        System.out.println("Give a choice (1-3): ");
        
    }
    
    //method for sorting, searching etc the vivlia's data (case 2)
    public static void eplEpeksergasias(){

        System.out.println("\n    Select procces: ");                  
       System.out.println("1. Search book");
       System.out.println("2. Sort books");
       System.out.println("3. Show books between two prices");
       System.out.println("4. Show up all informations of all books");
       System.out.println("5. Go back to the main menu");
       System.out.println("Give a choice (1-5)");

    }

    //method to select object's sorting
    public static void epilTaks(){
        
        System.out.println("\n    Select sort method: ");
        System.out.println("1. Author name");
        System.out.println("2. ISBN");
        System.out.println("3. Publish year");
        System.out.println("4. Price");
        System.out.println("5. Go back to the main list of choices");
        System.out.println("Give a choice (1-5)");
         
    }
     
    //method to select sorting algorithm
    public static void epilMethod(){
        
        System.out.println("\n    Select sort algorithm: ");
        System.out.println("1. Bubble sort");
        System.out.println("2. Insertion sort");
        System.out.println("3. Selection sort");
        System.out.println("4. Quick sort");
        System.out.println("5. Merge sort");
        System.out.println("6. Go back to the list of sorting choices");
        System.out.println("Give a choice (1-6)");  
    
    }


}

        
        
       