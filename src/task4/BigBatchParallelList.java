package task4;

import java.util.ArrayList;
import java.util.List;

public class BigBatchParallelList implements BigBatch{
    private List<IndexData> indexDataBatches;

    public void initData(int batchSize) {
        indexDataBatches = new ArrayList<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            indexDataBatches.add(new IndexData());
        }
    }

    @Override
    public List<IndexData> bigBatchHandler() {
        indexDataBatches.stream()
                .parallel()
                .forEach(IndexData::fToKorean);
        return indexDataBatches;
    }
}
