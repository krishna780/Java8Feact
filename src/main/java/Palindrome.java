public class Palindrome {
    public static void main(String[] args) {
        String str="wewksks";
        char[] chars = str.toCharArray();
        StringBuffer sb= new StringBuffer();
        for (int i=chars.length-1;i>=0;i--){
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
}
