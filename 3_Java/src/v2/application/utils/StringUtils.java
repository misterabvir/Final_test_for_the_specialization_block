package v2.application.utils;

public class StringUtils {
    private StringUtils(){}
    public static String rightPad(String string, int pad){
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() <= pad)
            stringBuilder.append(" ");
        string = stringBuilder.toString();
        return string;
    }
}
