package src.oopJava;
/*
author: Spyros Tsioupros
Year: 2021

1st year university project
*/

//class that manages the daily sales of books
public class DaySales {
    
    //attributes
    //capacity of antitypaSales and pSales have to be equal with vivlia's length
    static int[] antitypaSales = new int[Main.N]; //array to count the sales of each copy-book
    static Book[] pSales = new Book[Main.N]; //array to store the daily sales of books (books are sold from vivlia[] )

    static boolean exists = false;//variable to check the existanse of isbn at vivlia[] 

    //method to enter the sales of each book from vivlia[] to pSales[] and counter them to antitypaSales[]
    public static void copyBookSalesPlus(String isbn, Book[] vivlia){

        for(int i = 0; i < Main.k; i++){

            if( isbn.compareTo(vivlia[i].getISBN()) == 0 ){ //if this isbn there is on vivlia[i] then....
                exists = true;//isbn exists on vivlia[]
    
                    if(pSales[i] == null ) //if this isbn there is on pSales[i] then....
                        initPSales(i, isbn, vivlia); //initialize the i-st index of pSales with Science or Dictionary object 
    
                    

                antitypaSales[i]++; //increase the sale counter of the i-st copy-book 
    
            }
            
        }
        if(exists)
            return;

        //else
        System.out.println("This ISBN don't exists on library..."); 
        
    }

    //method to display each book's isbn, book category (science or dictionary), sum of sales
    public static void displaySales(Book[] vivlia){

        System.out.println("ISBN\tBook Category\t\tTotal Copy Sales");
        System.out.println("----------------------------------------\n");

        for(int i = 0; i < Main.k; i++){
            if(antitypaSales[i] != 0){// if in the i-st index are 0 sales then false
                System.out.println(pSales[i].getISBN()+"\t"+vivlia[i].getBookCategory()+"\t\t"+antitypaSales[i]);

            }

        }
    }

    //method to display the daily best seller (book that sold the most copies from others)
    public static int dailyBestSeller(){
        
        int maxPos = 0;

        for(int i = 1; i < antitypaSales.length; i++){
            if(antitypaSales[i] > antitypaSales[maxPos])
                maxPos = i;

        }

        return maxPos;
        
    }

    //method to initialize the sold book to the right book category
    public static void initPSales(int i, String isbn, Book[] vivlia){

        if(vivlia[i].getBookCategory().compareTo("Science") == 0) //if this object from vivlia[] is from class Science then....
            pSales[i] = vivlia[i] /*new Science(isbn)*/;

        else
            pSales[i] = vivlia[i] /*new Dictionary(isbn)*/;

    }

    //method to calculate income from sales of scientific books, dictionaries and the sum of those
    public static void incomeFromSales(Book[] vivlia){

        double scienceBooksSales = 0;
        double dictionaryBooksSales = 0;

        for(int i = 0; i < Main.k; i++){
            if(pSales[i] != null){
                if(vivlia[i].getBookCategory().compareTo("Science") == 0) 
                    scienceBooksSales += pSales[i].getPrice() * antitypaSales[i];

                else 
                    dictionaryBooksSales += pSales[i].getPrice() * antitypaSales[i];
            }
        }

        System.out.println("\n\tIncomes from scientific book(s): " + scienceBooksSales);
        System.out.println("\tIncomes from dictionarie(s): " + dictionaryBooksSales);
        System.out.println("\tTotal income: " + (scienceBooksSales+dictionaryBooksSales));

    }
}





















