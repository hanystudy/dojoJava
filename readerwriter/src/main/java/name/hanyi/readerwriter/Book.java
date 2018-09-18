package name.hanyi.readerwriter;

public class Book {
    private String content = "";
    private boolean empty = true;

    public synchronized void write(String sentence) {
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException ex) {}
        }
        empty = false;
        content = content.concat(sentence);
        notifyAll();
    }

    public synchronized String read() {
        while(empty) {
            try {
                wait();
            } catch(InterruptedException ex) {}
        }
        empty = true;
        notifyAll();
        return content;
    }
}
