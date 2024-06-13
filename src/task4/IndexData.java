package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class IndexData {
    private char[] data = new char[10000];
    private final List<Integer> list;

    public IndexData() {
        list = new ArrayList<>();
        generateRandomString(10000);
    }

    private void generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            data[i] = c;
            if (c == 'f') {
                list.add(i);
            }
        }
    }

    public void fToKorean() {
        for (Integer i : list) {
            data[i] = '엪';
        }
    }
}