package YandexTests;

import org.testng.annotations.Test;
import expectedStatusCodes.StatusCodes;

import static yandexDiskMethods.diskMethods.createItem.CreateFileAndCheckCreation.createFileAndCheckCreation;
import static yandexDiskMethods.diskMethods.createItem.CreateFolderAndCheckCreation.createFolderAndCheckCreation;
import static yandexDiskMethods.diskMethods.deleteItem.DeleteItemAndEnsureMovedToTrash.deleteItemAndEnsureMovedToTrash;
import static yandexDiskMethods.utilityMethods.BuildItemPathWithFile.buildItemPathWithFile;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFileName;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFolderName;

public class TestCreateFolderWithFileAndDeleteBoth {
    @Test
    public void createFolderWithFileAndDeleteBoth() {
        String folder1 = getRandomFolderName();
        String file1 = getRandomFileName("jpg");
        String filePath = buildItemPathWithFile(file1, folder1);

        createFolderAndCheckCreation(folder1, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFileAndCheckCreation(filePath, StatusCodes.SCGetFileLink200, folder1, StatusCodes.SCItemCreated201,
                StatusCodes.SCCreationValidation200);
        deleteItemAndEnsureMovedToTrash(filePath, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        deleteItemAndEnsureMovedToTrash(folder1, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
    }
}
