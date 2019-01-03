package offer;

public class FindDuplicateNumberINArray {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null ||numbers.length == 0) return false;
        if (length == 0) return false;
        for (int i = 0; i < length;){
            int val = numbers[i];
            if (val == i){
                i++;
                continue;
            }else {
                if (numbers[val] == val){
                    duplication[0] = val;
                    return true;
                }
                int tmp = numbers[val];
                numbers[val] = numbers[i];
                numbers[i] = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{2,3,1,0,2,5,3};
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers,numbers.length,duplication));

        System.out.println(duplication[0]);
    }

}
