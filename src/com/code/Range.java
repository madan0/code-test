package com.code;

public class Range implements Comparable<Range> {

    private int start;
    private int end;

    public Range() {
    }

    public Range(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }


    public boolean isOverlapping(Range range1, Range range2) {
        if (range1.end >= range2.getStart()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * sort the pincode range
     *
     * @param range
     * @return int
     */
    @Override
    public int compareTo(Range range) {
        if (this.getStart() == (range.getStart())) {
            if (this.getEnd() == (range.getEnd()))
                return 0;
            else if (this.getEnd() > (range.getEnd()))
                return -1;
            else return 1;
        } else if (this.getStart() > (range.getStart())) {
            return 1;
        } else {
            return -1;
        }

    }
}
