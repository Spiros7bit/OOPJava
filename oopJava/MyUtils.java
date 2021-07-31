package src.oopJava;


/*
Author: Spyros Tsioupros
Year: 2021

1st year university project
*/

//class that containes algorithms for project
public class MyUtils {
    
    //linear search respect to publish year   
    public static int seqSearch(Book[] n,int key){
        
        for(int i = 0; i < Main.k; i++){
            if(key == n[i].getPublYear())
                return i;
        }
        return -1;
    }

    //linear search respect to isbn
    public static int seqSearch(Book[] n, String key){
        
        for(int i = 0; i < Main.k; i++){
            if(key.equals(n[i].getISBN()))
                return i;
        }
        return -1;

    
    }
    
    //binary search respect to publish year
    public static int binSearch(Book[] n, int key){
        
        int right = Main.k - 1;
        int left = 0;
        int mid;
        int pos = -1;
        
        while(pos == -1 && left <= right){
            mid = (left + right)/2;

            if(key < n[mid].getPublYear()){
                right = mid - 1;
            }
            else{
                if(key > n[mid].getPublYear())
                    left = mid + 1;
                else
                    pos = mid;
            }
        }
        return pos;
    }
    
    //binary search respect to isbn
    public static int binSearch(Book[] n, String key){
        
        int right = Main.k - 1;
        int left = 0;
        int mid, pos = -1;
        
        while(pos == -1 && left <= right ){
            mid = (left + right)/2;
            
            if(key.compareTo(n[mid].getISBN()) > 0){
                left = mid + 1;
            }
            else {
                if(key.compareTo(n[mid].getISBN()) < 0)
                    right = mid - 1;
                else
                    pos = mid;
        }
    }

        return pos;
    }
    
    //show books respect to their prices
    public static void valueSearch(double apo, double mexri, Book[] n){
        
        for(int i = 0; i < Main.k; i++){
            if(n[i].getPrice() >= apo && n[i].getPrice() <= mexri){
                System.out.println(" "+n[i]);
            }
            
        }
    }

    //-----------------------------------------------------------------BubbleSorts methods
    //publish year
    public static void bubbleSortEtEkd(Book[] n){
        
        Book temp;
        boolean flag;
        Main.isSortEtEkd = true;//sort with respect to PublYear - mix respect to ISBN
        Main.isSortISBN = false;
        
        for(int i = 1; i < Main.k; i++){
            flag = true;
            for(int j = 0; j < Main.k - i; j++){
                if(n[j].getPublYear() > n[j+1].getPublYear()){
                    temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                    
                    flag = false;
                }
            }
            if (flag) 
                return;
            
        }
    }

    //price
    public static void bubbleSortPrice(Book[] n){
        
        Book temp;
        boolean flag;
       
        for(int i = 1; i < Main.k; i++){
            flag = true;
            for(int j = 0; j < Main.k - i; j++){
                if(n[j].getPrice() > n[j+1].getPrice()){
                    temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                    
                    flag = false;
                }
            }
            if (flag) 
                return;
            
        }
    }
    
    //isbn
    public static void bubbleSortISBN(Book[] n){
        
        Book temp;
        boolean flag;
        Main.isSortISBN = true;//sort with respect to ISBN - mix respect to PublYear
        Main.isSortEtEkd = false;
        
        for(int i = 1; i < Main.k; i++){
            flag = true;
            for(int j = 0; j < Main.k - i; j++){
                if(n[j].getISBN().compareTo(n[j+1].getISBN()) > 0){
                    temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                    
                    flag = false;
                }
            }
            if (flag) 
                return;
        }
    }
    
    //full name
    public static void bubbleSortFullName(Book[] n){
        
        Book temp;
        boolean flag;
        
        for(int i = 1; i < Main.k; i++){
            flag = true;
            for(int j = 0; j < Main.k - i; j++){
                if(n[j].getFullName().compareTo(n[j+1].getFullName()) > 0){
                    temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                    
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
    
     
    //-----------------------------------------------------------------InsertionSorts methods
    //isbn
    public static void insertSortISBN(Book[] n){

        Main.isSortISBN = true;//sort with respect to ISBN - mix respect to PublYear
        Main.isSortEtEkd = false;
        
        for(int i = 1; i <  Main.k; i++){
            Book current = n[i];
            int position = i;

            while(position > 0 && n[position-1].getISBN().compareTo(current.getISBN()) > 0){
                n[position] = n[position-1];
                position--;
            }
            n[position] = current;
        }
    }
   
    //full name
    public static void insertSortFullName(Book[] n){
        
        for(int i = 1; i <  Main.k; i++){
            Book current = n[i];
            int position = i;

            while(position > 0 && n[position-1].getFullName().compareTo(current.getFullName()) > 0){
                n[position] = n[position-1];
                position--;
            }
            n[position] = current;
        }
    }

    //publish year
    public static void insertSortEtEkd(Book n[]){

        Main.isSortEtEkd = true;//sort with respect to PublYear - mix respect to ISBN
        Main.isSortISBN = false;
        
        for(int i = 1; i <  Main.k; i++){
            Book current = n[i];
            int position = i;

            while(position > 0 && n[position-1].getPublYear() > current.getPublYear()){
                n[position] = n[position-1];
                position--;
            }
            n[position] = current;
        }
    }

    //price
    public static void insertSortPrice(Book n[]){
         
        for(int i = 1; i <  Main.k; i++){
            Book current = n[i];
            int position = i;

            while(position > 0 && n[position-1].getPrice() > current.getPrice()){
                n[position] = n[position-1];
                position--;
            }
            n[position] = current;
        }
    }
     
    //----------------------------------------------------------------------SelectionSorts methods
    //isbn
     public static void selectSortISBN(Book[] n){
        int min;
        Book temp;

        Main.isSortISBN = true;//sort with respect to ISBN - mix respect to PublYear
        Main.isSortEtEkd = false;
       
        for(int i = 0; i < Main.k - 1; i++){
            
            min = i;
            for(int k = i+1; k < Main.k; k++)
                if(n[k].getISBN().compareTo(n[min].getISBN()) < 0)
                    min = k;
            //swap the values
            temp = n[min];
            n[min] = n[i];
            n[i] = temp;
        }
    }
     
    //full name
    public static void selectSortFullName(Book[] n){
        int min;
        Book temp;
       
        for(int i = 0; i < Main.k - 1; i++){
            
            min = i;
            for(int k = i+1; k < Main.k; k++)
                if(n[k].getFullName().compareTo(n[min].getFullName()) < 0)
                    min = k;
            //swap the values
            temp = n[min];
            n[min] = n[i];
            n[i] = temp;
        }
    }
        
    //publish year 
    public static void selectSortEtEkd(Book[] n){
        int min;
        Book temp;

        Main.isSortEtEkd = true;//sort with respect to PublYear - mix respect to ISBN
        Main.isSortISBN = false;
        
        for(int i = 0; i < Main.k - 1; i++){
            
            min = i;
            for(int k = i+1; k < Main.k; k++)
                if(n[k].getPublYear() < n[min].getPublYear())
                    min = k;
            //swap the values
            temp = n[min];
            n[min] = n[i];
            n[i] = temp;
        }
    }
      
    //price
    public static void selectSortPrice(Book[] n){
        int min;
        Book temp;
       
        for(int i = 0; i < Main.k - 1; i++){
            
            min = i;
            for(int k = i+1; k < Main.k; k++)
                if(n[k].getPrice() < n[min].getPrice())
                    min = k;
            //swap the values
            temp = n[min];
            n[min] = n[i];
            n[i] = temp;
        }
    }
      
      
     //-----------------------------------------------------------QuickSorts methods 
    // publish year
    public static void quickSortEtEkd(Book[] f){
        Main.isSortEtEkd = true;//sort with respect to PublYear - mix respect to ISBN
        Main.isSortISBN = false;
        qSortEtEkd(f, 0, Main.k-1);
    
    }
    
    public static int partitionEtEkd(Book[] a, int f, int l){
        int retV = 0;
        int lowerL = f;
        int mid = (f + l) / 2;
        swap(a,f,mid);
        
        Book pivot = a[f];
        f++;
        
        while(f < l){
            while(a[f].getPublYear() <= pivot.getPublYear() && f < l) f++;
            while(a[l].getPublYear() >= pivot.getPublYear() && f <= l) l--;
            if(f < l) swap(a,f,l);
        }
        
        if(pivot.getPublYear() > a[f].getPublYear()){
            swap(a,f,lowerL);
            retV = f;
        }
        else{
            if(pivot.getPublYear() >= a[l].getPublYear()){
                swap(a,l,lowerL);
                retV = l;
            }
        }
        return retV;
    }  
    
    public static void qSortEtEkd(Book[] a, int f, int l){
        if(l-f>0){
            int pivot_index = partitionEtEkd(a, f, l);
            
            qSortEtEkd(a, f, pivot_index-1);
            qSortEtEkd(a, pivot_index+1, l);
        }
    }
    
    //Price
    public static void quickSortPrice(Book[] f){
        qSortPrice(f, 0, Main.k-1);
       
    }
    
    public static int partitionPrice(Book[] a, int f, int l){
        int retV = 0;
        int lowerL = f;
        int mid = (f + l) / 2;
        swap(a,f,mid);
        
        Book pivot = a[f];
        f++;
        
        while(f < l){
            while(a[f].getPrice() <= pivot.getPrice() && f < l) f++;
            while(a[l].getPrice() >= pivot.getPrice() && f <= l) l--;
            if(f < l) swap(a,f,l);
        }
        
        if(pivot.getPrice() > a[f].getPrice()){
            swap(a,f,lowerL);
            retV = f;
        }
        else{
            if(pivot.getPrice() >= a[l].getPrice()){
                swap(a,l,lowerL);
                retV = l;
            }
        }
        return retV;
    }  
    
    public static void qSortPrice(Book[] a, int f, int l){
        if(l-f>0){
            int pivot_index = partitionPrice(a, f, l);
            
            qSortPrice(a, f, pivot_index-1);
            qSortPrice(a, pivot_index+1, l);
        }
    }
    
    //ISBN
    public static void quickSortISBN(Book[] f){
        Main.isSortISBN = true;//sort with respect to ISBN - mix respect to PublYear
        Main.isSortEtEkd = false;
        qSortISBN(f, 0, Main.k-1);
       
    }
    
    public static int partitionISBN(Book[] a, int f, int l){
        int retV = 0;
        int lowerL = f;
        int mid = (f + l) / 2;
        swap(a,f,mid);
        
        Book pivot = a[f];
        f++;
        
        while(f < l){
            while(a[f].getISBN().compareTo(pivot.getISBN()) <= 0 && f < l) f++;
            while(a[l].getISBN().compareTo(pivot.getISBN()) >= 0 && f <= l) l--;
            if(f < l) swap(a,f,l);
        }
        
        if(pivot.getISBN().compareTo(a[f].getISBN()) > 0){
            swap(a,f,lowerL);
            retV = f;
        }
        else{
            if(pivot.getISBN().compareTo(a[l].getISBN()) > 0){
                swap(a,l,lowerL);
                retV = l;
            }
        }
        return retV;
    }  
    
    public static void qSortISBN(Book[] a, int f, int l){
        if(l-f>0){
            int pivot_index = partitionISBN(a, f, l);
            
            qSortISBN(a, f, pivot_index-1);
            qSortISBN(a, pivot_index+1, l);
        }
    }
    
        
    //full name
    public static void quickSortFullName(Book[] f){
        qSortFullName(f, 0, Main.k-1);
       
    }
    
    public static int partitionFullName(Book[] a, int f, int l){
        int retV = 0;
        int lowerL = f;
        int mid = (f + l) / 2;
        swap(a,f,mid);
        
        Book pivot = a[f];
        f++;
        
        while(f < l){
            while(a[f].getFullName().compareTo(pivot.getFullName()) <= 0 && f < l) f++;
            while(a[l].getFullName().compareTo(pivot.getFullName()) >= 0 && f <= l) l--;
            if(f < l) swap(a,f,l);
        }
        
        if(pivot.getFullName().compareTo(a[f].getFullName()) > 0){
            swap(a,f,lowerL);
            retV = f;
        }
        else{
            if(pivot.getFullName().compareTo(a[l].getFullName()) > 0){
                swap(a,l,lowerL);
                retV = l;
            }
        }
        return retV;
    }  
    
    public static void qSortFullName(Book[] a, int f, int l){
        if(l-f>0){
            int pivot_index = partitionFullName(a, f, l);
            
            qSortFullName(a, f, pivot_index-1);
            qSortFullName(a, pivot_index+1, l);
        }
    }
    
    //-----------------------------------------------------------MergeSorts methods
    //ISBN
    public static void mergeSortISBN(Book[] a){
        Main.isSortISBN = true;//sort with respect to ISBN - mix respect to PublYear
        Main.isSortEtEkd = false;
        mSortISBN(a, 0, Main.k-1);
        
    }
    
    
    public static void mSortISBN(Book[] a, int f, int l){
        if(f == l) return;
        
        int mid = (f + l) / 2;
        
        mSortISBN(a, f, mid);
        mSortISBN(a, mid+1, l);
        mergeISBN(a, f, l, mid);
    }
    
    
    public static void mergeISBN(Book[] a, int f, int l, int mid){
        int n = l-f+1;
        
        Book[] b = new Book[n];
        
        int i1 = f, i2 = mid + 1;
        int j = 0;
        
        while(i1 <= mid && i2 <= l){
            if(a[i1].getISBN().compareTo(a[i2].getISBN()) < 0){
                b[j] = a[i1];
                i1++;
            }
            else{
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        
        while(i1 <= mid){
            b[j] = a[i1];
            i1++;
            j++;
            
        }
        
        while(i2 <= l){
            b[j] = a[i2];
            i2++;
            j++;
        }
        
        for(j = 0; j < n; j++)
            a[f+j] = b[j];
    }
    
    
    //full name
    public static void mergeSortFullName(Book[] a){
        mSortFullName(a, 0, Main.k-1);
        
    }
    
    
    public static void mSortFullName(Book[] a, int f, int l){
        if(f == l) return;
        
        int mid = (f + l) / 2;
        
        mSortFullName(a, f, mid);
        mSortFullName(a, mid+1, l);
        mergeFullName(a, f, l, mid);
    }
    
    
    public static void mergeFullName(Book[] a, int f, int l, int mid){
        int n = l-f+1;
        
        Book[] b = new Book[n];
        
        int i1 = f, i2 = mid + 1;
        int j = 0;
        
        while(i1 <= mid && i2 <= l){
            if(a[i1].getFullName().compareTo(a[i2].getFullName()) < 0){
                b[j] = a[i1];
                i1++;
            }
            else{
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        
        while(i1 <= mid){
            b[j] = a[i1];
            i1++;
            j++;
            
        }
        
        while(i2 <= l){
            b[j] = a[i2];
            i2++;
            j++;
        }
        
        for(j = 0; j < n; j++)
            a[f+j] = b[j];
    }
    
    
    //publish year
    public static void mergeSortEtEkd(Book[] a){
        Main.isSortEtEkd = true;//sort with respect to PublYear - mix respect to ISBN
        Main.isSortISBN = false;
        mSortEtEkd(a, 0, Main.k-1);
        
        
    }
    
    
    public static void mSortEtEkd(Book[] a, int f, int l){
        if(f == l) return;
        
        int mid = (f + l) / 2;
        
        mSortEtEkd(a, f, mid);
        mSortEtEkd(a, mid+1, l);
        mergeEtEkd(a, f, l, mid);
    }
    
    
    public static void mergeEtEkd(Book[] a, int f, int l, int mid){
        int n = l-f+1;
        
       Book[] b = new Book[n];
        
        int i1 = f, i2 = mid + 1;
        int j = 0;
        
        while(i1 <= mid && i2 <= l){
            if(a[i1].getPublYear() < a[i2].getPublYear() ){
                b[j] = a[i1];
                i1++;
            }
            else{
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        
        while(i1 <= mid){
            b[j] = a[i1];
            i1++;
            j++;
            
        }
        
        while(i2 <= l){
            b[j] = a[i2];
            i2++;
            j++;
        }
        
        for(j = 0; j < n; j++)
            a[f+j] = b[j];
    }
    
    //price
    public static void mergeSortPrice(Book[] a){
        mSortPrice(a, 0, Main.k-1);
        
        
    }
    
    
    public static void mSortPrice(Book[] a, int f, int l){
        if(f == l) return;
        
        int mid = (f + l) / 2;
        
        mSortPrice(a, f, mid);
        mSortPrice(a, mid+1, l);
        mergePrice(a, f, l, mid);
    }
    
    
    public static void mergePrice(Book[] a, int f, int l, int mid){
        int n = l-f+1;
        
       Book[] b = new Book[n];
        
        int i1 = f, i2 = mid + 1;
        int j = 0;
        
        while(i1 <= mid && i2 <= l){
            if(a[i1].getPrice() < a[i2].getPrice() ){
                b[j] = a[i1];
                i1++;
            }
            else{
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        
        while(i1 <= mid){
            b[j] = a[i1];
            i1++;
            j++;
            
        }
        
        while(i2 <= l){
            b[j] = a[i2];
            i2++;
            j++;
        }
        
        for(j = 0; j < n; j++)
            a[f+j] = b[j];
    }
    
    //swap method
     public static void swap(Book[] a, int x, int y){
        Book temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
     
    
}