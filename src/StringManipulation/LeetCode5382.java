package StringManipulation;

public class LeetCode5382 {
    static class Solution {
        String template[] = {"amp;","apos;","frasl;","gt;","lt;","quot;"};
        char mathc[] = {'&', '\'', '/', '>', '<', '\"'};

        public int insert(StringBuffer sb, char input[], int index) {
            for(int i = 0;i < template.length;i++) {
                int j = 0;
                for(int k = index + 1;j < template[i].length();j++) {
                    if(input[k++] != template[i].charAt(j)) break;
                }

                if(j == template[i].length()) {
                    sb.append(mathc[i]);
                    index = index + template[i].length() + 1;
                    return index;
                }
            }

            sb.append('&');
            return index + 1;
        }

        public String entityParser(String text) {
            char input[] = text.toCharArray();
            StringBuffer sb = new StringBuffer();

            for(int i = 0;i < input.length;) {
                if(input[i] != '&') {
                    sb.append(input[i]);
                    i++;
                }
                else{
                    i = insert(sb, input, i);
                }
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }
}
