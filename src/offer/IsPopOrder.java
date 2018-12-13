package offer;


/**
 * @version: V1.0
 * @author: abiao
 * @className: IsPopOrder
 * @packageName: offer
 * @description: 第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * @data: 2018/12/13
 **/
public class IsPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        int len = popA.length;
        if (len == 0) return true;
        if (len == 1){
            if (pushA[0] == popA[0]){
                return true;
            } else {
                return false;
            }
        }
        int value = popA[0];
        int pos = 0;
        for (int i = 0; i < len; i++){
            if (value == pushA[i]){
                pos = i;
                break;
            }
        }
        int p = 1;
        for (int i = pos-1; i >=0;){
            int last = pushA[i];
            if (popA[p] != last) {
                for (int q = i-1; q >= 0; q--){
                    if (popA[p] == pushA[q]) return false;
                }
            }else{
                i--;
            }
            p++;
        }
        return true;
    }

    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        int[] pop1 = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop));
        System.out.println(isPopOrder(push,pop1));
    }
}
