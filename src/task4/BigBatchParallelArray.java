package task4;

import java.util.Arrays;

public class BigBatchParallelArray implements BigBatch{
    private IndexData[] indexDataBatches;

    public void initData(int batchSize) {
        indexDataBatches = new IndexData[batchSize];
        for (int i = 0; i < batchSize; i++) {
            indexDataBatches[i] = new IndexData();
        }
    }

    @Override
    public IndexData[] bigBatchHandler() {
        Arrays.stream(indexDataBatches)
                .parallel()
                .forEach(IndexData::fToKorean);
        return indexDataBatches;
    }
}


