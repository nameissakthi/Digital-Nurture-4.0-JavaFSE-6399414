public class Library {
    Book[] books = { 
        new Book(1, "Java Programming", "John Doe"),
        new Book(2, "Data Structures", "Jane Doe"),
        new Book(3, "Algorithms", "Alice Smith"),
        new Book(4, "Operating Systems", "Bob Johnson")
    };

    public void displayBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }

    public void linearSearch(int id){
        for(Book book : books){
            if(book.getId() == id){
                System.out.println(book);
                return;
            }
        }

        System.out.println("Book not found");
    }

    public void binarySearch(int id){
        int start = 0, end = books.length-1;

        while(start<end){
            int mid = (start+end)/2;

            if(books[mid].getId() == id){
                System.out.println(books[mid]);
                return;
            }else if(books[mid].getId()>id){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        System.out.println("Book not found");
    }
}
