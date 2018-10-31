package name.hanyi.filesystemexplorer.api;

import java.io.Console;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class FileStoreCommand extends SimpleFileSystemCommand {

    private static final int K = 1024 * 1024;
    public static final String FILE_STORES_FORMAT_STRING = "%30s %12s %12s %12s\n";

    @Override
    public String getName() {
        return "df";
    }

    @Override
    public String getHelp() {
        return "list file stores";
    }

    @Override
    public void execute(Console console) throws IOException {
        console.format(FILE_STORES_FORMAT_STRING, "Filesystem", "MegaBytes", "Used", "Avail");
        for (FileStore fileStore : FileSystems.getDefault().getFileStores()) {
            console.format(FILE_STORES_FORMAT_STRING,
                    fileStore.name(),
                    fileStore.getTotalSpace() / K,
                    (fileStore.getTotalSpace() - fileStore.getUnallocatedSpace()) / K,
                    fileStore.getUsableSpace() / K);
        }
    }
}
