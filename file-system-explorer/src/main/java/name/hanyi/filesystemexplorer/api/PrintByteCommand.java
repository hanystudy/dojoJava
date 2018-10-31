package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintByteCommand implements FileSystemCommand {

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
        int number = getNumberOfBytesPerLine(console);
        try {
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
            console.format("%s\n", builder.toString());
        } catch (IOException ex) {
            console.format("Can not read file\n");
        }
    }

    private Path getPath(Console console) {
        String pathString = console.readLine("input path:");
        return Paths.get(pathString);
    }

    private int getNumberOfBytesPerLine(Console console) {
        String numberString = console.readLine("input number of bytes per line (>=0):");
        try {
            int number = Integer.valueOf(numberString);
            return number >= 0 ? number : 0;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
