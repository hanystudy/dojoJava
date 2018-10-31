package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintByteCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "catb";
    }

    @Override
    public String getHelp() {
        return "print file in bytes";
    }

    @Override
    public void execute(Console console) throws IOException {
        Path path = getPath(console);
        try {
            int number = getNumberOfBytesPerLine(console);
            StringBuilder builder = getHexString(path, number);
            console.format("%s", builder.toString());
        } catch (IOException ex) {
            console.format("Can not read file\n");
        }
    }

    private StringBuilder getHexString(Path path, int number) throws IOException {
        byte[] content = Files.readAllBytes(path);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (byte bt : content) {
            i++;
            builder.append(String.format("%02X ", bt));
            if (i == number) {
                builder.append("\n");
                i = 0;
            }
        }
        if (i != 0) {
            builder.append("\n");
        }
        return builder;
    }

    private Path getPath(Console console) {
        String pathString = console.readLine("input path:");
        return Paths.get(pathString);
    }

    private int getNumberOfBytesPerLine(Console console) {
        String numberString = console.readLine("input number of bytes per line (>=1):");
        try {
            int number = Integer.valueOf(numberString);
            return number >= 1 ? number : 1;
        } catch (NumberFormatException ex) {
            return 1;
        }
    }
}
