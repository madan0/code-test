package com.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeMerger {

    /**
     * Compare current and next element of the sorted list and merge the range which overlaps or contained in each other
     * @param rangeList
     * @return mergedlist
     */
    public List<Range> rangeMerger(List<Range> rangeList) {
        List<Range> mergedRangeList = new ArrayList<>();
        Range current = null;
        Range next = null;
        while (rangeList.size() > 0) {
            current = rangeList.get(0);
            if (rangeList.size() > 1) {
                next = rangeList.get(1);
                if (isRangeOverlapsOtherRange(current, next)) {
                    mergedRangeList.add(new Range(current.getStart(), next.getEnd()));
                    rangeList.remove(next);
                } else if (isRangeContainsOtheRange(current, next)) {
                    processAnElement(rangeList, mergedRangeList, current, next);
                } else {
                    processAnElement(rangeList, mergedRangeList, current, current);
                }
            } else {//if list have only one element
                processAnElement(rangeList, mergedRangeList, current, current);
            }
        }
        return mergedRangeList;
    }

    /**
     *
     * @param rangeList
     * @param mergedRngeList
     * @param current
     * @param next
     */
    private void processAnElement(List<Range> rangeList, List<Range> mergedRngeList, Range current, Range next) {
        if (!mergedRngeList.contains(current)) {
            mergedRngeList.add(current);
        }
        rangeList.remove(next);
    }

    /**
     * Check if one range overlaps other range
     * @param range1
     * @param range2
     * @return boolean
     */
    public boolean isRangeOverlapsOtherRange(Range range1, Range range2) {
        if ((range1.getEnd() >= range2.getStart()) && (range1.getEnd() < range2.getEnd())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if one range contains other
     * @param range1
     * @param range2
     * @return boolean
     */
    public boolean isRangeContainsOtheRange(Range range1, Range range2) {
        if ((range1.getStart() <= range2.getStart()) && (range1.getEnd() >= range2.getEnd())) {
            return true;
        } else {
            return false;
        }
    }


}
