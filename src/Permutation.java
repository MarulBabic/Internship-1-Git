import java.util.Scanner;

public class Permutation {

    public void generatePermutation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite niz cijelih brojeva odvojenih razmacima:");
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");

        int[] numbArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            numbArr[i] = Integer.parseInt(strArr[i]);
        }

        permutationRecursion(numbArr,0);

        scanner.close();
    }

    private void permutationRecursion(int[] numbArr, int start) {
        if(start == numbArr.length){
            for(int i : numbArr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for(int i = start; i < numbArr.length; i++){
            swap(numbArr,start,i);
            permutationRecursion(numbArr,start + 1);
            swap(numbArr,start,i);
        }
    }

    private void swap(int[] niz, int i, int j) {
        int temp = niz[i];
        niz[i] = niz[j];
        niz[j] = temp;
    }
}
