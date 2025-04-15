import java.io.*;
import java.util.*;

class Solution {
    static int video_pos, open_pos, end_pos, now_pos;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video = video_len.split(":");
        video_pos = Integer.parseInt(video[0])*60+Integer.parseInt(video[1]);
        
        String[] start = op_start.split(":");
        open_pos = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
        
        String[] end = op_end.split(":");
        end_pos = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
        
        String[] now = pos.split(":");
        now_pos = Integer.parseInt(now[0])*60+Integer.parseInt(now[1]);
        
        if (open_pos <= now_pos && now_pos <= end_pos) now_pos = end_pos;
        
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                now_pos -= 10;
                if (now_pos < 10) now_pos = 0;
            }
            if (cmd.equals("next")) {
                now_pos += 10;
                if (video_pos-now_pos < 10) now_pos = video_pos;
            }
            if (open_pos <= now_pos && now_pos <= end_pos) now_pos = end_pos;
        }
        
        System.out.println(now_pos);
        int answer_min = now_pos/60;
        if (answer_min < 10) {
            answer += "0"+answer_min+":";
        } else {
            answer += answer_min+":";
        }
        int answer_sec = now_pos%60;
        if (answer_sec < 10) {
            answer += "0"+answer_sec;
        } else {
            answer += answer_sec;
        }
        
        return answer;
    }

}