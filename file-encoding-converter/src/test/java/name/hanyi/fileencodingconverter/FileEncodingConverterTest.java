package name.hanyi.fileencodingconverter;

import name.hanyi.fileencodingconverter.reader.FileEncodingCharacterReader;
import name.hanyi.fileencodingconverter.reader.FileEncodingDataReader;
import name.hanyi.fileencodingconverter.reader.FileEncodingReader;
import name.hanyi.fileencodingconverter.writer.FileEncodingCharacterWriter;
import name.hanyi.fileencodingconverter.writer.FileEncodingDataWriter;
import name.hanyi.fileencodingconverter.writer.FileEncodingWriter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FileEncodingConverterTest {

    private FileEncodingReader characterReader;
    private FileEncodingReader dataReader;
    private FileEncodingWriter characterWriter;
    private FileEncodingWriter dataWriter;

    private FileEncodingConverter converter;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        converter = new FileEncodingConverter();
        characterReader = new FileEncodingCharacterReader();
        dataReader = new FileEncodingDataReader();
        characterWriter = new FileEncodingCharacterWriter();
        dataWriter = new FileEncodingDataWriter();
    }

    @Test
    public void convertCharToData() throws IOException, URISyntaxException {
        URL resourceURL = getClass().getClassLoader().getResource("character.txt");
        File outputFile = folder.newFile("data.txt");
        converter.setReader(characterReader);
        converter.setWriter(dataWriter);

        converter.convert(Paths.get(resourceURL.toURI()), outputFile.toPath());

        URL dataURL = getClass().getClassLoader().getResource("data.txt");
        assertTrue(compareTwoFiles(outputFile.toPath(), Paths.get(dataURL.toURI())));;
    }

    @Test
    public void convertDataToChar() throws IOException, URISyntaxException {
        URL resourceURL = getClass().getClassLoader().getResource("data.txt");
        File outputFile = folder.newFile("character.txt");
        converter.setReader(dataReader);
        converter.setWriter(characterWriter);

        converter.convert(Paths.get(resourceURL.toURI()), outputFile.toPath());

        URL characterURL = getClass().getClassLoader().getResource("character.txt");
        assertTrue(compareTwoFiles(outputFile.toPath(), Paths.get(characterURL.toURI())));
    }

    private boolean compareTwoFiles(Path pathFrom, Path pathTo) throws IOException {
        byte[] bytesFrom = Files.readAllBytes(pathFrom);
        byte[] bytesTo = Files.readAllBytes(pathTo);
        return Arrays.equals(bytesFrom, bytesTo);
    }
}