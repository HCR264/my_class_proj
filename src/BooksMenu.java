import java.util.Scanner;

public class BooksMenu {
    private static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice()<book2.getPrice()) {
            return book2;
        } else {
            return book1;
        }
    }

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int bkIdx = 0;
        int auxIndex1 = 0;
        int auxIndex2 = 0;

        while(true) {
            System.out.print("""
                            \nMenu:
                            \t1. View books.
                            \t2. Add books.
                            \t3. Change the price of a book.
                            \t4. Compare two books.
                            \tAny other to exit.
                            Option:\s""");
            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                for (int i=0; i<books.length; i++) {
                    if(books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if(bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }
                System.out.print("""
                        \nWhich constructor do you want to use?
                        \tPress 1 for default+
                        \tPress 2 for creating a clone of an existing object
                        \tPress any other key for overloaded constructor
                        Option:\s""");
                String constructor = scanner.nextLine();

                if (!constructor.equals("2")) {
                    System.out.print("Enter book title: ");
                    String tmpTitle = scanner.nextLine();
                    System.out.print("Enter book author:");
                    String tmpAuthor = scanner.nextLine();
                    System.out.print("Enter book price:");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());
                    if (constructor.equals("1")) {
                        Book bkTmp = new Book();
                        bkTmp.setTitle(tmpTitle);
                        bkTmp.setAuthor(tmpAuthor);
                        bkTmp.setPrice(tmpPrice);
                        books[bkIdx++] = bkTmp;
                    } else {
                        books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tmpPrice);
                    }
                } else {
                    System.out.print("Enter the index of the book to clone: ");
                    auxIndex1 = Integer.parseInt(scanner.nextLine());
                    try {
                        books[bkIdx++] = (Book) books[auxIndex1].clone();
                    } catch (Exception e) {
                        System.out.println("Error cloning book");
                    }
                }
            } else if (userAction.equals("3")) {
                System.out.print("Enter index of first book to change price: ");
                auxIndex1 = Integer.parseInt(scanner.nextLine());

                if (auxIndex1 >= bkIdx) {
                    System.out.println("Invalid index");
                    continue;
                }

                System.out.print("Enter the new price of the book: ");
                books[auxIndex1].setPrice(Float.parseFloat(scanner.nextLine()));
            } else if (userAction.equals("4")) {
                System.out.print("Enter index of first book to compare: ");
                auxIndex1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter index of second book to compare: ");
                auxIndex2 = Integer.parseInt(scanner.nextLine());
                if (auxIndex1 >= bkIdx || auxIndex2 >= bkIdx) {
                    System.out.println("Invalid index");
                    continue;
                }
                if (books[auxIndex1].equals(books[auxIndex2])) {
                    System.out.println("The books are the same.");
                } else {
                    System.out.println("The books are not the same.");
                }
            } else {
                break;
            }
        }
    }
}