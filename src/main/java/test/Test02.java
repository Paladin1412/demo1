package test;

public class Test02 {

    public static void main(String[] args) {
        String str1 = "mynameistom";
        String str2 = "henameisjack";
        String myfun = myfun(str1, str2);
        System.out.println(myfun);
//        String a = "abcd";
//        System.out.println(a.substring(3,4));

    }

    // abcd
    private static String myfun(String str1, String str2) {

        String result = null;
        int len = 0;
        byte[] str1Bytes = str1.getBytes();
        for (int i = 0; i < str1Bytes.length; i++) {
            for (int j = i + 1; j <= str1Bytes.length; j++) {
                //截取str1,在str2中进行判断
                String substring = str1.substring(i, j);
                if (str2.contains(substring)) {
                    if (substring.length() > len) {
                        len = substring.length();
                        result = substring;
                    }
                }

            }
        }
        return result;
    }


}
