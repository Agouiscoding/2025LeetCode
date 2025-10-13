package ass2;

public class STIA {
        public int myAtoi(String s) {
            int i = 0, n = s.length();
            int sign = 1;
            long num = 0;  // 用 long 暂存，防止中间溢出

            // Step 1: 跳过前导空格
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // Step 2: 判断符号
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;
            }

            // Step 3: 读取数字字符
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';

                // Step 4: 溢出检查
                if (num > (Integer.MAX_VALUE - digit) / 10) {
                    // 发生溢出
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                num = num * 10 + digit;
                i++;
            }

            // Step 5: 返回结果
            return (int)(sign * num);
        }
}
