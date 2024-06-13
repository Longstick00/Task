package task4;

import java.util.LinkedList;
import java.util.List;

public class BigBatchLinkedList implements BigBatch{
    private List<IndexData> indexDataBatches;

    @Override
    public void initData(int batchSize) {
        indexDataBatches = new LinkedList<>();
        for (int i = 0; i < batchSize; i++) {
            indexDataBatches.add(new IndexData());
        }
    }

    @Override
    public List<IndexData> bigBatchHandler() {
        for (IndexData indexData : indexDataBatches) {
            indexData.fToKorean();
        }
        return indexDataBatches;
    }
}
