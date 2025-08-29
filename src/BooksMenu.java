import java.util.Scanner;

public class BooksMenu {
    // Metodo para comparar
    public static String comparePrices (Book book1, Book book2) {
        float price1 = book1.getPrice();
        float price2 = book2.getPrice();
        String priceCmp;

        if (price1 > price2) {
            priceCmp = book1.getTitle() + " is more expensive than " + book2.getTitle();
        } else if (price1 < price2) {
            priceCmp = book1.getTitle() + " is cheaper than " + book2.getTitle();
        } else {
            priceCmp = book1.getTitle() + " has the same price as " + book2.getTitle();
        }

        return priceCmp;
    }

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Book[] books = new Book[10];
        int bkIdx = 0;
        int auxIndex1, auxIndex2;

        while(true) {
            System.out.print("Press 1 to view books, 2 to add books, 3 to compare the prices or any other key to exit: ");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                for(int i=0;i<books.length;i++) {
                    if(books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) {
                if(bkIdx == 10) {
                    System.out.println("10 books added already. Cannot add any more books!");
                    continue;
                }
                System.out.print("Enter book title: ");
                String tmpTitle = scanner.nextLine();
                System.out.print("Enter book author: ");
                String tmpAuthor = scanner.nextLine();
                System.out.print("Enter book price: ");
                float tmpPrice = Float.parseFloat(scanner.nextLine());

                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tmpPrice);
                books[bkIdx++] = bkTmp;

            } else if (userAction.equals("3")) {
                if (bkIdx < 2) {
                    System.out.println("You must add at least 2 books to compare prices!");
                    continue;
                }
                System.out.print("Enter the index of the first book to compare: ");
                auxIndex1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the index of the second book to compare: ");
                auxIndex2 = Integer.parseInt(scanner.nextLine());

                if (auxIndex1 >= bkIdx || auxIndex2 >= bkIdx){
                    System.out.println("Invalid indexes!");
                    continue;
                }
                System.out.println(comparePrices(books[auxIndex1], books[auxIndex2]));

            } else {
                break;
            }
        }
    }
}

