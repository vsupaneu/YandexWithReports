package yandexDiskMethods.trashMethods.removeFromTrash;

import yandexDiskMethods.diskMethods.createItem.EnsureItemCreatedOrRestored;

public class RestoreItemFromTrashAndEnsureMovedToDisk {
    public static void restoreItemFromTrashAndEnsureMovedToDisk(String path, int SCRestoreFromTrash201,
                                                                int SCCreationValidation200) {
        //code 201 for restore, 200 - for validation
        RestoreItemFromTrash.restoreItemFromTrash(path, SCRestoreFromTrash201);
        EnsureItemCreatedOrRestored.ensureItemCreatedOrRestored(path, SCCreationValidation200);
    }
}
