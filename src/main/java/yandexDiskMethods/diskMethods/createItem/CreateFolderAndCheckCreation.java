package yandexDiskMethods.diskMethods.createItem;

public class CreateFolderAndCheckCreation {
    public static void createFolderAndCheckCreation(String folderPath, int SCItemCreated201,
                                                    int SCCreationValidation200) {

        //code 201 for creation, 200 for validation
        CreateFolder.createFolder(folderPath, SCItemCreated201);
        EnsureItemCreatedOrRestored.ensureItemCreatedOrRestored(folderPath, SCCreationValidation200);
    }
}
