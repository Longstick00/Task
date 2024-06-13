package task4;

class BigBatchArray implements BigBatch{
    private IndexData[] indexDataBatches;

    @Override
    public void initData(int batchSize) {
        indexDataBatches = new IndexData[batchSize];
        for (int i = 0; i < batchSize; i++) {
            indexDataBatches[i] = new IndexData();
        }
    }

    @Override
    public IndexData[] bigBatchHandler() {
        for (IndexData indexData : indexDataBatches) {
            indexData.fToKorean();
        }
        return indexDataBatches;
    }
}