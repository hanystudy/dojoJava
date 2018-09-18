import name.hanyi.readerwriter.Book;

public class ReaderWriterMain {
    public static void main(String[] args) {
        Book book = new Book();
        Thread reader = new Thread(new Runnable() {
            public void run() {
                String sentence = book.read();
                System.out.println("reader gets " + sentence);
            }
        });
        Thread writer = new Thread(new Runnable() {
            public void run() {
                book.write("hello world!");
            }
        });
        reader.start();
        writer.start();
    }
}
