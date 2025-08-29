public class Book implements Cloneable{
    // Definición de atributos
    private String title;
    private String author;
    private float price;

    // Primer constructor
    public Book () {
        this.title = null;
        this.author = null;
    }

    // Segundo constructor
    public Book (String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Sobrescribiendo el metodo clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public float getPrice() {
        return this.price;
    }

    // Sobrescribiendo el metodo toString()
    public String toString() {
        return "Title - " + this.title + "\nAuthor - "
                + this.author + "\nPrice - "+ String.format("%.2f", this.price);
    }

    // Sobrescribiendo el metodo equals()
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;     // Cast de obj a Book
            return this.title.equals(book.title) && this.author.equals(book.author) && this.price == book.price;
        } else {
            return false;
        }
    }
}