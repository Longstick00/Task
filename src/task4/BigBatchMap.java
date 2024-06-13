package task4;

import java.util.HashMap;
import java.util.Map;

public class BigBatchMap implements BigBatch {
    private Map<Integer, IndexData> dataBatch;

    public void initData(int batchSize) {
        dataBatch = new HashMap<>(batchSize);
        for (int i = 0; i < batchSize; i++) {
            dataBatch.put(i, new IndexData());
        }
    }

    @Override
    public Map<Integer, IndexData> bigBatchHandler() {
        for (IndexData indexData : dataBatch.values()) {
            indexData.fToKorean();
        }
        return dataBatch;
    }
}
