package Application.programs;

public class RemoveWhiteSpace {
    public static void main(String[] args) {
        String str = "wel come java";
        str.strip();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (!Character.isWhitespace(ch)) {
                sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
