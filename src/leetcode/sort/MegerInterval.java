package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class MegerInterval {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList();
        if (intervals == null || intervals.size() == 0) return ret;
        intervals.sort((o1, o2) -> o1.start - o2.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).start;
        for (int i = 1; i < intervals.size() - 1; i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= end) {
                end = cur.end;
            } else {
                Interval iv = new Interval(start, end);
                ret.add(iv);
                start = cur.start;
                end = cur.end;
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
}
