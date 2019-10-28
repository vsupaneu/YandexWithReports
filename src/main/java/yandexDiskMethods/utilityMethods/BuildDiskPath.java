package yandexDiskMethods.utilityMethods;

public class BuildDiskPath {
    public static String buildItemDiskPath(String... folders) {
        StringBuilder result = new StringBuilder();
        result.append("disk:/");
        for (String s : folders) {
            result.append(s).append("/");
        }
        return result.toString();
    }
}
