package kiemtra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KiemTraSo1 {
    public static void main(String[] args) {
//        Bai 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap mot so nguyen ");
        int n = sc.nextInt();
        System.out.println(test(n));
//        Bai 1A
        Integer inputArray[] = new Integer[]{1, 4, 17, 7, 25, 3, 100};
        int sum = 0;
        System.out.println("Mang goc");
        System.out.println(Arrays.toString(inputArray));
        for (int i = 0; i < inputArray.length; i++) {
            sum = sum + inputArray[i];
        }
        double average = sum / inputArray.length;
        System.out.println("Trung binh cua mang goc la " + average);
        System.out.println("So trong mang lon hon gia tri tb la ");
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > average) {
                System.out.println(inputArray[i]);
            }
        }
//        Bai 2
        Scanner ch = new Scanner(System.in);
        System.out.println("Nhap mot chuoi");
        String str = ch.nextLine();
        System.out.println("Kiem tra tat ca ky tu cua chuoi co phai nguyen am khong");
        System.out.println(test2(str));
//        Bai 2A
        int[] num = {4, 2, 3, 3, 7, 2, 4};
        int k = 6 ;
        System.out.println("Mang goc "+Arrays.toString(num));
        System.out.println("So nguyen cho truoc: "+k);
        System.out.println("Tong so mang con co tong bang k la co: "+max_SubArry(num, k )+" mang");
//        Bai 3
       Scanner sdt = new Scanner(System.in);
        System.out.println("Nhap vao so dien thoai: ");
        String phone = sdt.nextLine();
        Pattern p = Pattern.compile("^0\\d{9}$");
        if (p.matcher(phone).find()){
            System.out.println("Đúng stđ Việt Nam ");
        }else {
            System.out.println("Không đúng sđt Việt Nam");
        }
//        Bai 4
        int[] numBer = {1, -2, 5, -4, 3, -6};
        System.out.println("Mang ban đầu: "+ Arrays.toString(numBer));
        boolean result = test3(numBer);
        System.out.print("Kiểm tra xem một mảng các số nguyên có các giá trị âm xen kẽ giữa các giá trị dương hay k: " +result);

    }

    public static boolean test(int n) {
        final int f = 10;
        if (n == 0) {
            return false;
        }
        while (n != 0) {
            if ((n % f) % 2 != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static boolean test2(String input) {
        String str_nguyenAm = "u, e, o, a, i";
        String cumTu = input.toLowerCase();
        for (int i = 0; i < cumTu.length(); i++) {
           if (str_nguyenAm.indexOf(cumTu.charAt(i)) == -1)
               return false;
        }
        return true ;
    }
    public  static  int max_SubArry(int[] num, int k ){
        int ctr = 0 , sum = 0 ;
        Map<Integer, Integer>map = new HashMap<>();
        map.put(0 , 1);
        for (int i = 0 ; i <num.length; i++){
            sum +=num[i];
            if (map.containsKey(sum - k)){
                ctr = ctr + map.get(sum - k);
            }
            if (map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }else {
                map.put(sum, 1);
            }
        }
        return ctr;
    }
    public static boolean test3(int[] numBer){
        for (int n: numBer){
            if (n == 0)
                return false;
        }
        for (int i = 1; i < numBer.length; i++){
            if (numBer[i - 1] > 0 && numBer[i] > 0){
                return false;
            }else if (numBer[i - 1] < 0 && numBer[i] < 0){
                return false;
            }
        }
        return true;
    }
}
