package com.company.Back;

import javax.swing.plaf.basic.BasicFormattedTextFieldUI;

public class first {
    int minCount = Integer.MAX_VALUE;
    public int solution(String s) {
        int i,j = 0;
        for (i = 1; i <= s.length(); i++) { // offset
            int offset = i;
            int same = 1;
            int isSame = 0;
            String copy = "";
            StringBuffer sb = new StringBuffer("");
            for (j = 0; j < s.length(); j+=offset) {
                int nowIdx = j + offset;
                int nextIdx = nowIdx + offset;
                if (nowIdx > s.length()) {
                    if (isSame == 1) {
                        sb.append(same);
                        sb.append(s.substring(j));
                    } else
                        sb.append(s.substring(j));
                    break;
                }

                if (nextIdx > s.length()) {
                    if (isSame == 1) {
                        sb.append(same);
                        sb.append(s.substring(j));
                    } else
                        sb.append(s.substring(j));
                    break;
                }

                String before = s.substring(j, nowIdx);
                String next = s.substring(nowIdx, nextIdx);

                if (before.equals(next)) {
                    same++;
                    isSame = 1;
                    copy = before;
                } else {
                    if (isSame == 1) {
                        sb.append(same);
                        sb.append(copy);
                    } else {
                        sb.append(before);
                    }
                    isSame = 0;
                    same = 1;
                }

            }
            minCount = Math.min(minCount, sb.length());
            System.out.println(sb.toString());
        }
        return minCount;
    }

}

//aaddbbada
//dedede -> 3de

//abab cdcd abab cdcd
//2ababcdcd
//aabbaccc
//2a2ba3c