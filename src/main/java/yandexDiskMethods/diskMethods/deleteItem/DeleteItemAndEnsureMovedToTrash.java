package yandexDiskMethods.diskMethods.deleteItem;

import yandexDiskMethods.trashMethods.removeFromTrash.EnsureItemIsInTrash;

public class DeleteItemAndEnsureMovedToTrash {
    public static void deleteItemAndEnsureMovedToTrash(String path, int SCForRemoval404, int SCFindItemInTrash200,
                                                       int SCForDeletion202, int SCForDeletion204) {

        //codes 202, 204 for deletion, 404 - ensureItemIsDeleted, 200 - EnsureItemIsInTrash
        DeleteFileOrFolder.deleteFileOrFolder(path, SCForDeletion202, SCForDeletion204);
        EnsureItemIsDeleted.ensureItemIsDeleted(path, SCForRemoval404);
        EnsureItemIsInTrash.ensureItemIsInTrash(path, SCFindItemInTrash200);
    }
}
