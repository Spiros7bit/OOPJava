package src.oopJava;

/*
Author: Spyros Tsioupros
Year: 2021

1st year university project
*/

//class that spesializes book objects
public class Science extends Book{

    //attributes
    private String scienceField;

    //constuctors
    public Science(){}

    public Science(String scienceField, String title, String fullName, String ISBN, String publisher, int pages, int publYear, double price){

        super(title, fullName, ISBN, publisher, pages, publYear, price);
        this.scienceField = scienceField;
    }

    public Science(String ISBN){
        super(ISBN);
    }

    public Science(String ISBN, String scienceField){
        super(ISBN);
        this.scienceField = scienceField;
    }

    //set@ method
    public void setScienceField(String scienceField){
        this.scienceField = scienceField;
    }

    //get@ methods
    public String getScienceField(){
        return scienceField;
    }

    @Override
    public String getBookCategory(){
        return "Science";
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + ", Science Field: " + scienceField;

    }

   

}