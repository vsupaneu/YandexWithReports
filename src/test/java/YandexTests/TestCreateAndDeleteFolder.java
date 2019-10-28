package YandexTests;

import org.testng.annotations.Test;
import expectedStatusCodes.StatusCodes;

import static yandexDiskMethods.diskMethods.createItem.CreateFolderAndCheckCreation.createFolderAndCheckCreation;
import static yandexDiskMethods.diskMethods.deleteItem.DeleteItemAndEnsureMovedToTrash.deleteItemAndEnsureMovedToTrash;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFolderName;

public class TestCreateAndDeleteFolder {
    @Test
    public void createAndDeleteFolder() {
        String folder1 = getRandomFolderName();

        createFolderAndCheckCreation(folder1, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        deleteItemAndEnsureMovedToTrash(folder1, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
    }
}
