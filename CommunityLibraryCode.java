import java.util.*;
import java.nio.file.*;

class Book {
    private String name;                 // Module 4: Encapsulation
    private boolean issued;

    // Module 4: Constructor
    Book(String name) {
        this.name = name;
        this.issued = false;
    }

    // Module 4: Getter
    String getName() {
        return name;
    }

    void issue() {
        issued = true;
    }

    void returnBook() {
        issued = false;
    }

    // Module 4: toString()
    public String toString() {
        return name + (issued ? " (Issued)" : " (Available)");
    }
}

class CommunityLibrary {

    // Module 3: Method
    static void showBooks(ArrayList<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + " - " + books.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Module 6: ArrayList + Generics
        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Sort Books");
            System.out.println("7. Save Books");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Module 1 + 2: Input, variables, switch
                case 1:
                    System.out.print("Enter book name: ");
                    String name = sc.nextLine();

                    // Module 4: Object creation
                    books.add(new Book(name));

                    System.out.println("Book added!");
                    break;

                // Module 2 + Module 3: Loop + method
                case 2:
                    showBooks(books);
                    break;

                // Module 2: if-else
                case 3:
                    System.out.print("Enter book ID: ");
                    int id = sc.nextInt();

                    if (id >= 0 && id < books.size()) {
                        books.get(id).issue();
                        System.out.println("Book issued!");
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    id = sc.nextInt();

                    if (id >= 0 && id < books.size()) {
                        books.get(id).returnBook();
                        System.out.println("Book returned!");
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;

                // Module 5: String searching
                case 5:
                    System.out.print("Enter book name to search: ");
                    String search = sc.nextLine().toLowerCase();

                    boolean found = false;

                    for (Book b : books) {
                        if (b.getName().toLowerCase().contains(search)) {
                            System.out.println(b);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                // Module 5: Library sorting algorithm
                case 6:
                    books.sort(Comparator.comparing(Book::getName));
                    System.out.println("Books sorted!");
                    break;

                // Module 5: File I/O
                case 7:
                    try {
                        ArrayList<String> data = new ArrayList<>();

                        for (Book b : books) {
                            data.add(b.toString());
                        }

                        Files.write(
                            Path.of("library.txt"),
                            data
                        );

                        System.out.println("Books saved to file!");

                    } catch (Exception e) {
                        System.out.println("Error saving file.");
                    }
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
