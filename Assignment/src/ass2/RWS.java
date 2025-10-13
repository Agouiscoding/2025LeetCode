package ass2;

public class RWS {
    public String reverseWords(String s) {
        // Step 1: 去除首尾空格
        s = s.trim();
        int end = s.length() - 1, start = end;
        StringBuilder sb = new StringBuilder();

        // Step 2: 从右向左扫描
        while (start >= 0) {
            // 找到当前单词的起点
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            // 把 [start+1, end] 的单词加入结果
            sb.append(s, start + 1, end + 1).append(' ');

            // 跳过中间多余的空格
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start; // 下一个单词的尾部
        }

        // 删除最后一个多余空格
        return sb.toString().trim();
    }
}
