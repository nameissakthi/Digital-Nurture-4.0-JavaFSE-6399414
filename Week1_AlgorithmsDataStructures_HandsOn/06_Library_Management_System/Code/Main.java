public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.displayBooks();

        System.out.println();

        System.out.println("Linear Search : ");
        library.linearSearch(4);

        System.out.println();

        System.out.println("Binary Search");
        library.binarySearch(3);
    }    
}
