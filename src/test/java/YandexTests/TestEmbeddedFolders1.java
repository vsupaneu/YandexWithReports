package YandexTests;

import org.testng.annotations.Test;
import expectedStatusCodes.StatusCodes;

import static yandexDiskMethods.diskMethods.createItem.CreateFileAndCheckCreation.createFileAndCheckCreation;
import static yandexDiskMethods.diskMethods.createItem.CreateFolderAndCheckCreation.createFolderAndCheckCreation;
import static yandexDiskMethods.diskMethods.deleteItem.DeleteItemAndEnsureMovedToTrash.deleteItemAndEnsureMovedToTrash;
import static yandexDiskMethods.diskMethods.deleteItem.EnsureItemIsDeleted.ensureItemIsDeleted;
import static yandexDiskMethods.diskMethods.itemInfo.GetItemInfo.checkFolderInfo;
import static yandexDiskMethods.utilityMethods.BuildDiskPath.buildItemDiskPath;
import static yandexDiskMethods.utilityMethods.BuildItemPath.buildItemPath;
import static yandexDiskMethods.utilityMethods.BuildItemPathWithFile.buildItemPathWithFile;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFileName;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFolderName;

public class TestEmbeddedFolders1 {
    @Test
    public void embeddedFolders1() {
        String folder1 = getRandomFolderName();
        String folder2 = getRandomFolderName();
        String file1 = getRandomFileName("docx");
        String folder1DiskPath = buildItemDiskPath(folder1);
        String folder2Path = buildItemPath(folder1, folder2);
        String file1Path = buildItemPathWithFile(file1, folder1, folder2);
        int amountOfEmbeddedItems = 1;

        createFolderAndCheckCreation(folder1, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFolderAndCheckCreation(folder2Path, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFileAndCheckCreation(file1Path,  StatusCodes.SCGetFileLink200, folder2Path, StatusCodes.SCItemCreated201,
                StatusCodes.SCCreationValidation200);
        checkFolderInfo(amountOfEmbeddedItems, folder1DiskPath, folder1);
        deleteItemAndEnsureMovedToTrash(folder1, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        ensureItemIsDeleted(folder2Path, StatusCodes.SCForRemoval404);
        ensureItemIsDeleted(file1Path, StatusCodes.SCForRemoval404);
    }
}
