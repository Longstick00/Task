import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task3 {
    List<Integer> myList = new ArrayList<>(20);
    List<Integer> removedOdds = new ArrayList<>();

    public Task3() {
        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
    }

    public static void main(String[] args) {
        Task3 listData = new Task3();

        System.out.println("Original list: " + listData.myList);

        // 1. Loop로 직접 순회하며 홀수 삭제
        listData.removeOddsWithLoop();

        // 새로 객체를 생성해서 원래 상태로 초기화
        listData = new Task3();

        // 2. Loop로 직접 순회하지 않고 홀수 삭제
        listData.removeOddsWithoutLoop();

        // 3. 홀수 출력
        listData.printRemovedOddsDescending();

        // 4. 삭제한 홀수들을 다시 삭제
        listData.removeFromRemovedOdds(5);
        System.out.println("List after adding back 5: " + listData.myList);
        System.out.println("List after adding back 5: " + listData.removedOdds);
    }

    public void removeOddsWithLoop() {
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 != 0) {
                iterator.remove();
                removedOdds.add(number);
            }
        }
    }

    public void removeOddsWithoutLoop() {
        myList.removeIf(number -> {
            if (number % 2 != 0) {
                removedOdds.add(number);
                return true;
            }
            return false;
        });
    }

    public void printRemovedOddsDescending() {
        removedOdds.sort(Collections.reverseOrder());
        for (int number : removedOdds) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public void removeFromRemovedOdds(Integer number) {
        if (removedOdds.remove(number)) {
            myList.add(number);
            Collections.sort(myList); // 원본 리스트를 정렬하여 원래 순서를 유지
        }
    }
}
