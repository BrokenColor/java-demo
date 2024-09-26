package toolUtil.carparkEncrypt;

/**
 * StringUtils
 *
 * @author michael
 * @version 1.0.0
 * @date 2020-01-03
 */
public abstract class StringUtils {

    public static final String EMPTY = "";

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasText(CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean hasText(String str) {
        return hasText((CharSequence) str);
    }

    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }
}
