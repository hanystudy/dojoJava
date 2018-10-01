package name.hanyi.fileencodingconverter;

import name.hanyi.fileencodingconverter.reader.FileEncodingCharacterReader;
import name.hanyi.fileencodingconverter.reader.FileEncodingDataReader;
import name.hanyi.fileencodingconverter.reader.FileEncodingObjectReader;
import name.hanyi.fileencodingconverter.reader.FileEncodingReader;
import name.hanyi.fileencodingconverter.writer.FileEncodingCharacterWriter;
import name.hanyi.fileencodingconverter.writer.FileEncodingDataWriter;
import name.hanyi.fileencodingconverter.writer.FileEncodingObjectWriter;
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

    private FileEncodingReader characterReader = new FileEncodingCharacterReader();
    private FileEncodingReader dataReader = new FileEncodingDataReader();
    private FileEncodingWriter characterWriter = new FileEncodingCharacterWriter();
    private FileEncodingWriter dataWriter = new FileEncodingDataWriter();
    private FileEncodingWriter objectWriter = new FileEncodingObjectWriter();
    private FileEncodingReader objectReader = new FileEncodingObjectReader();

    private FileEncodingConverter converter;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() {
        converter = new FileEncodingConverter();
    }

    @Test
    public void convertCharToData() throws IOException, URISyntaxException, ClassNotFoundException {
        URL resourceURL = getClass().getClassLoader().getResource("character.txt");
        File outputFile = folder.newFile("data.txt");
        converter.setReader(characterReader);
        converter.setWriter(dataWriter);

        converter.convert(Paths.get(resourceURL.toURI()), outputFile.toPath());

        URL dataURL = getClass().getClassLoader().getResource("data.txt");
        assertTrue(compareTwoFiles(outputFile.toPath(), Paths.get(dataURL.toURI())));;
    }

    @Test
    public void convertDataToChar() throws IOException, URISyntaxException, ClassNotFoundException {
        URL resourceURL = getClass().getClassLoader().getResource("data.txt");
        File outputFile = folder.newFile("character.txt");
        converter.setReader(dataReader);
        converter.setWriter(characterWriter);

        converter.convert(Paths.get(resourceURL.toURI()), outputFile.toPath());

        URL characterURL = getClass().getClassLoader().getResource("character.txt");
        assertTrue(compareTwoFiles(outputFile.toPath(), Paths.get(characterURL.toURI())));
    }

    @Test
    public void convertDataToObject() throws URISyntaxException, IOException, ClassNotFoundException {
        URL resourceURL = getClass().getClassLoader().getResource("data.txt");
        File outputFile = folder.newFile("object.txt");
        converter.setReader(dataReader);
        converter.setWriter(objectWriter);

        converter.convert(Paths.get(resourceURL.toURI()), outputFile.toPath());

        URL objectURL = getClass().getClassLoader().getResource("object.txt");
        assertTrue(compareTwoFiles(outputFile.toPath(), Paths.get(objectURL.toURI())));
    }

    @Test
    public void convertObjectToCharacter() throws URISyntaxException, IOException, ClassNotFoundException {
        URL resourceURL = getClass().getClassLoader().getResource("object.txt");
        File outputFile = folder.newFile("character.txt");
        converter.setReader(objectReader);
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