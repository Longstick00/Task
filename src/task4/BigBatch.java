package task4;

public interface BigBatch {

    <T> T bigBatchHandler();

    void initData(int size);
}
