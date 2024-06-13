package task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Double> timeList = new ArrayList<>();

        BigBatch bigBatchArray = new BigBatchArray();
        run(bigBatchArray, timeList);

        BigBatch bigBatchParallelArray = new BigBatchParallelArray();
        run(bigBatchParallelArray, timeList);

        BigBatch bigBatchArrayList = new BigBatchArrayList();
        run(bigBatchArrayList, timeList);

        BigBatch bigBatchParallelList = new BigBatchParallelList();
        run(bigBatchParallelList, timeList);

        BigBatch bigBatchLinkedList = new BigBatchLinkedList();
        run(bigBatchLinkedList, timeList);

        BigBatch bigBatchMap = new BigBatchMap();
        run(bigBatchMap, timeList);
    }

    private static void run(BigBatch bigBatch, List<Double> timeList) {
        for (int i = 0; i < 5; i++) {
            int batchSize = 50000;

            long initStartTime = System.nanoTime();
            bigBatch.initData(batchSize);
            long initEndTime = System.nanoTime();
            double initTime = (initEndTime - initStartTime) / 1_000_000_000.0;

            long handlerStartTime = System.nanoTime();
            bigBatch.bigBatchHandler();
            long handlerEndTime = System.nanoTime();
            double handlerTime = (handlerEndTime - handlerStartTime) / 1_000_000_000.0;

            timeList.add(handlerTime);
            System.out.println("Init Time: " + initTime + " seconds");
            System.out.println("Handler Execution Time: " + handlerTime + " seconds");
        }
        double avgTime = timeList.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("avgTime = " + avgTime + " " + bigBatch.getClass());
        timeList.clear();
    }


}