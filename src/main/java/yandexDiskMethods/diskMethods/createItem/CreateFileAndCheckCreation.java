package yandexDiskMethods.diskMethods.createItem;

public class CreateFileAndCheckCreation {
    public static void createFileAndCheckCreation(String filePath, int SCGetFileLink200, String destinationPath,
                                                  int SCItemCreated201,  int SCCreationValidation200) {

        //code 200 for link, 201 for creation, 200 for validation
        CreateFile.createFile(filePath, SCGetFileLink200, destinationPath, SCItemCreated201);
        EnsureItemCreatedOrRestored.ensureItemCreatedOrRestored(filePath, SCCreationValidation200);
    }
}

