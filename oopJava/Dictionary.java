package src.oopJava;

/*
Author: Spyros Tsioupros
Year: 2021

1st year university project
*/

//class that spesializes book objects
public class Dictionary extends Book{

    //attributes
    private int dictEntries;

    //constructors
    public Dictionary(){}

    public Dictionary(String ISBN){
        super(ISBN);
    }
    
    public Dictionary(int dictEntries, String title, String fullName, String ISBN, String publisher, int pages, int publYear, double price){
        
        super(title, fullName, ISBN, publisher, pages, publYear, price);
        this.dictEntries = dictEntries;
    }

    public Dictionary(String ISBN, int dictEntries){
        
        super(ISBN);
        this.dictEntries = dictEntries;
    }

    //get@ methods
    public int getDictEntries(){
        return dictEntries;
    }

    @Override
    public String getBookCategory(){
        return "Dictionary";
    }

    //set@ method
    public void setDictEntries(int dictEntries){
        this.dictEntries = dictEntries;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + ", Word Count: " + dictEntries;

    }

}
