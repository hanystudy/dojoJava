package name.hanyi.fileencodingconverter;

import name.hanyi.fileencodingconverter.reader.FileEncodingReader;
import name.hanyi.fileencodingconverter.writer.FileEncodingWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileEncodingConverter {

    private FileEncodingWriter writer;
    private FileEncodingReader reader;

    public void setWriter(FileEncodingWriter writer) {
        this.writer = writer;
    }

    public void setReader(FileEncodingReader reader) {
        this.reader = reader;
    }

    public void convert(Path inputPath, Path outputPath) throws IOException, ClassNotFoundException {
        List<Integer> list = reader.readPath(inputPath);
        writer.writePath(list, outputPath);
    }
}