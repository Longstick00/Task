package task4;

import java.util.PriorityQueue;
import java.util.Queue;

public class BigBatchQueue implements BigBatch{
    private Queue<IndexData> indexDataBatches;

    @Override
    public void initData(int batchSize) {
        indexDataBatches = new PriorityQueue<>();
        for (int i = 0; i < batchSize; i++) {
            indexDataBatches.add(new IndexData());
        }
    }

    @Override
    public Queue<IndexData> bigBatchHandler() {
        for (IndexData indexData : indexDataBatches) {
            indexData.fToKorean();
        }
        return indexDataBatches;
    }
}
