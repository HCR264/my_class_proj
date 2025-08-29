public class BookAccess {
    private static void comparePrices(Book book1, Book book2) {
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

        System.out.println(priceCmp);
    }
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("Atomic Habits");
        book1.setAuthor("James Clear");
        book1.setPrice(30.00f);

        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("The first book is: ");
        System.out.println(book1);
        System.out.println("");
        System.out.println("The second book is: ");
        System.out.println(book2);
        System.out.println("");
        comparePrices(book1, book2);
    }
}
