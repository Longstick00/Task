package task4;

import java.util.ArrayList;
import java.util.List;

public class BigBatchArrayList implements BigBatch{
    private List<IndexData> indexDataBatches;

    @Override
    public void initData(int batchSize) {
        indexDataBatches = new ArrayList<>(batchSize);
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
