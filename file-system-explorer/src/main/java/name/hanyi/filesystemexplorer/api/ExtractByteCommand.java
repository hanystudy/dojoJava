package name.hanyi.filesystemexplorer.api;

import name.hanyi.filesystemexplorer.model.FileSystemModel;
import name.hanyi.filesystemexplorer.util.PathUtil;

import java.io.Console;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtractByteCommand extends SimpleFileSystemCommand {

    @Override
    public String getName() {
        return "eb";
    }

    @Override
    public String getHelp() {
        return "extract bytes from file by given position";
    }

    @Override
    public void execute(Console console, FileSystemModel fileSystemModel) throws IOException {
        Path path = PathUtil.getAbsolutePath(fileSystemModel, getPath(console));
        try (FileChannel file = FileChannel.open(path)) {
            int start = getStartBytesPerLine(console);
            int number = getTotalNumberOfBytes(console);
            int numberOfBytesPerLine = getNumberOfBytesPerLine(console);
            file.position(start);
            ByteBuffer buffer = ByteBuffer.allocate(number);
            file.read(buffer);
            StringBuilder builder = getHexString(numberOfBytesPerLine, buffer);
            console.format("%s", builder);
        } catch (IOException ex) {
            console.format("Can not read file\n");
        }
    }

    private StringBuilder getHexString(int number, ByteBuffer buffer) {
        byte[] content = buffer.array();
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

    private int getStartBytesPerLine(Console console) {
        String numberString = console.readLine("input position of start (>=0):");
        try {
            int number = Integer.valueOf(numberString);
            return number >= 0 ? number : 0;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private Path getPath(Console console) {
        String pathString = console.readLine("input path:");
        return Paths.get(pathString);
    }

    private int getNumberOfBytesPerLine(Console console) {
        String numberString = console.readLine("input number of bytes per line (>=1):");
        try {
            int number = Integer.valueOf(numberString);
            return number > 0 ? number : 1;
        } catch (NumberFormatException ex) {
            return 1;
        }
    }

    private int getTotalNumberOfBytes(Console console) {
        String numberString = console.readLine("input total number of bytes to read (>=1):");
        try {
            int number = Integer.valueOf(numberString);
            return number > 0 ? number : 1;
        } catch (NumberFormatException ex) {
            return 1;
        }
    }
}
