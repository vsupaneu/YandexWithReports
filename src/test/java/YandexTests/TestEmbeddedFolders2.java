package YandexTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import expectedStatusCodes.StatusCodes;

import static yandexDiskMethods.diskMethods.createItem.CreateFileAndCheckCreation.createFileAndCheckCreation;
import static yandexDiskMethods.diskMethods.createItem.CreateFolderAndCheckCreation.createFolderAndCheckCreation;
import static yandexDiskMethods.diskMethods.deleteItem.DeleteItemAndEnsureMovedToTrash.deleteItemAndEnsureMovedToTrash;
import static yandexDiskMethods.trashMethods.removeFromTrash.ClearTrash.clearTrash;
import static yandexDiskMethods.trashMethods.trashInfoMethods.GetTrashSize.getTrashSize;
import static yandexDiskMethods.utilityMethods.BuildItemPath.buildItemPath;
import static yandexDiskMethods.utilityMethods.BuildItemPathWithFile.buildItemPathWithFile;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFileName;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFolderName;

public class TestEmbeddedFolders2 {
    @Test
    public void embeddedFolders2() {
        String folder1 = getRandomFolderName();
        String folder2 = getRandomFolderName();
        String file1 = getRandomFileName("jpeg");
        String folder2Path = buildItemPath(folder1, folder2);
        String file1Path = buildItemPathWithFile(file1, folder1, folder2);

        createFolderAndCheckCreation(folder1, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFolderAndCheckCreation(folder2Path, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFileAndCheckCreation(file1Path, StatusCodes.SCGetFileLink200, folder2Path, StatusCodes.SCItemCreated201,
                StatusCodes.SCCreationValidation200);
        deleteItemAndEnsureMovedToTrash(folder1, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        clearTrash(StatusCodes.SCClearTrash202);
        int trashSize = getTrashSize();
        Assert.assertEquals(trashSize, 0);
    }
}
