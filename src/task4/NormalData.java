//package task4;
//
//import java.util.Random;
//
//class Data {
//    private String data;
//
//    public Data() {
//        this.data = generateRandomString(10);
//    }
//
//    private String generateRandomString(int length) {
//        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            char c = characters.charAt(random.nextInt(characters.length()));
//            sb.append(c);
//        }
//        return sb.toString();
//    }
//
//    public void fToKorean() {
//        if (this.data.contains("f")) {
//            this.data = this.data.replace("f", "에프");
//        }
//    }
//}