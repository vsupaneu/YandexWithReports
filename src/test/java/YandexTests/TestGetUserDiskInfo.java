package YandexTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import expectedStatusCodes.StatusCodes;

import static yandexDiskMethods.diskMethods.createItem.CreateFileAndCheckCreation.createFileAndCheckCreation;
import static yandexDiskMethods.diskMethods.createItem.CreateFolderAndCheckCreation.createFolderAndCheckCreation;
import static yandexDiskMethods.diskMethods.deleteItem.DeleteItemAndEnsureMovedToTrash.deleteItemAndEnsureMovedToTrash;
import static yandexDiskMethods.trashMethods.removeFromTrash.RestoreItemFromTrashAndEnsureMovedToDisk.restoreItemFromTrashAndEnsureMovedToDisk;
import static yandexDiskMethods.trashMethods.trashInfoMethods.GetSizesOfDeletedFiles.getSizesOfDeletedFiles;
import static yandexDiskMethods.trashMethods.trashInfoMethods.GetTrashSize.getTrashSize;
import static yandexDiskMethods.utilityMethods.BuildItemPathWithFile.buildItemPathWithFile;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFileName;
import static yandexDiskMethods.utilityMethods.GetRandomName.getRandomFolderName;

public class TestGetUserDiskInfo {
    @Test
    public void getUserDiskInfo() {
        String folder1 = getRandomFolderName();
        String file1 = getRandomFileName("docx");
        String file2 = getRandomFileName("docx");
        String file1Path = buildItemPathWithFile(file1, folder1);
        String file2Path = buildItemPathWithFile(file2, folder1);

        int initialTrashSize = getTrashSize();
        createFolderAndCheckCreation(folder1, StatusCodes.SCItemCreated201, StatusCodes.SCCreationValidation200);
        createFileAndCheckCreation(file1Path, StatusCodes.SCGetFileLink200, folder1, StatusCodes.SCItemCreated201,
                StatusCodes.SCCreationValidation200);
        createFileAndCheckCreation(file1Path, StatusCodes.SCGetFileLink200, folder1, StatusCodes.SCItemCreated201,
                StatusCodes.SCCreationValidation200);
        deleteItemAndEnsureMovedToTrash(file1Path, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        deleteItemAndEnsureMovedToTrash(file2Path, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        int sizeOfDeletedFiles = getSizesOfDeletedFiles(file1, file2);
        int finalTrashSize = getTrashSize();
        Assert.assertEquals(finalTrashSize, initialTrashSize + sizeOfDeletedFiles);
        restoreItemFromTrashAndEnsureMovedToDisk(file1, StatusCodes.SCRestoreFromTrash201, StatusCodes.SCCreationValidation200);
        deleteItemAndEnsureMovedToTrash(file1Path, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
        deleteItemAndEnsureMovedToTrash(folder1, StatusCodes.SCForRemoval404, StatusCodes.SCFindItemInTrash200,
                StatusCodes.SCItemDeleted202, StatusCodes.SCItemDeleted204);
    }
}
