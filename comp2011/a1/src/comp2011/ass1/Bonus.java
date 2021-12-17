package comp2011.ass1;

public class Bonus {

    public static int[] secondSmallest(int[] a, int low, int high) {
        if (low > high) return null;
        int[] ans = new int[2];
        if (high == low) {
            ans[0] = ans[1] = high;
            return ans;
        }
        if (high == low + 1) {
            ans[0] = (a[low] > a[high]) ? low : high;
            ans[1] = low - ans[0] + high;
            return ans;
        }

        // in the rest high - low >= 2.
        int mid = low + (high - low) / 2;
        int[] a1 = secondSmallest(a, low, mid);
        int[] a2 = secondSmallest(a, mid + 1, high);
        if (a[a1[1]] < a[a2[1]]) {
            ans[1] = a1[1];  // the smallest
            ans[0] = (a[a1[0]] < a[a2[1]]) ? a1[0] : a2[1];  // the second smallest
        } else {
            ans[1] = a2[1];  // the smallest
            ans[0] = (a[a2[0]] < a[a1[1]]) ? a2[0] : a1[1];  // the second smallest
        }
        return ans;
    }

    public static int secondSmallest(int[] integers) {
        int[] ans = secondSmallest(integers, 0, integers.length - 1);
        return integers[ans[0]];
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 4, 6, 4, 9, 3, 9};
        System.out.println(secondSmallest(a));
    }
}
