import java.util.Scanner;

class CommunityLibrary {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] books = new String[5];
        int count = 0;
        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book name: ");
                    books[count] = sc.nextLine();
                    count++;
                    System.out.println("Book added!");
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        System.out.println(i + " - " + books[i]);
                    }
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int id = sc.nextInt();

                    if (id >= 0 && id < count) {
                        books[id] = books[id] + " (Issued)";
                        System.out.println("Book issued!");
                    } else {
                        System.out.println("Invalid ID");
                    }
                    break;

                case 4:
                    System.out.println("Book returned!");
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}