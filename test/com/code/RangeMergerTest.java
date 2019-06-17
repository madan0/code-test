package com.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RangeMergerTest {


    @Test
    public void testIsRangeOverlapsOtherRange_false(){

        //Prepare
        Range range2= new Range(2000345,2000446);
        Range range1 =new Range(2000348,2000490);
        //Execute
        RangeMerger rm = new RangeMerger();
        boolean isRangeContainsOtherRange =rm.isRangeOverlapsOtherRange(range1,range2);
        //assert
        Assert.assertFalse(isRangeContainsOtherRange);
    }

    @Test
    public void testIsRangeOverlapsOtherRange_true(){
        //Prepare
        Range range1= new Range(2000345,2000446);
        Range range2 =new Range(2000345,2000456);
        //Execute
        RangeMerger rm = new RangeMerger();
        boolean isRangeContainsOtherRange =rm.isRangeOverlapsOtherRange(range1,range2);
        //assert
        Assert.assertTrue(isRangeContainsOtherRange);
    }

    @Test
    public void testIsRangeContainsOtheRange_true(){
        //Prepare
        Range range1= new Range(2000345,2000556);
        Range range2 =new Range(2000345,2000455);
        //Execute
        RangeMerger rm = new RangeMerger();
        boolean isRangeContainsOtherRange =rm.isRangeContainsOtheRange(range1,range2);
        //assert
        Assert.assertTrue(isRangeContainsOtherRange);

    }

    @Test
    public void testIsRangeContainsOtheRange_false(){
        //Prepare
        Range range1= new Range(2000345,2000446);
        Range range2 =new Range(2000345,2000456);
        //Execute
        RangeMerger rm = new RangeMerger();
        boolean isRangeContainsOtherRange =rm.isRangeContainsOtheRange(range1,range2);
        //assert
        Assert.assertFalse(isRangeContainsOtherRange);
    }

    @Test
    public void testRangeMerger_merged(){
        //Prepare
        Range range1= new Range(2000345,2000446);
        Range range2 =new Range(2000345,2000456);
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(range1);
        rangeList.add(range2);
        //Execute
        Collections.sort(rangeList);
        RangeMerger rm = new RangeMerger();
        List<Range>  mergedList=rm.rangeMerger(rangeList);
        //assert
        Assert.assertEquals(1,mergedList.size());
        Assert.assertEquals(2000345,mergedList.get(0).getStart());
        Assert.assertEquals(2000456,mergedList.get(0).getEnd());

    }

    @Test
    public void testRangeMerger_notMerged(){
        //Prepare
        Range range1= new Range(2000345,2000446);
        Range range2 =new Range(2000447,2000456);
        List<Range> rangeList = new ArrayList<>();
        rangeList.add(range1);
        rangeList.add(range2);
        //Execute
        Collections.sort(rangeList);
        RangeMerger rm = new RangeMerger();
        List<Range>  mergedList=rm.rangeMerger(rangeList);
        //assert
        Assert.assertEquals(2,mergedList.size());

    }

}
