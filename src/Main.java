import com.code.Range;
import com.code.RangeMerger;
import com.code.ReaderWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] arg) {

        RangeMerger rm = new RangeMerger();
        List<String> inputData= ReaderWriter.readData("input.txt");
        //collect the data in a arraylist
        List<Range> rangeList=ReaderWriter.convertToPinCodeRangeList(inputData);
        System.out.println("input list"+rangeList);
        ReaderWriter.writeData(rm.rangeMerger(rangeList),"output.txt");

    }
}
