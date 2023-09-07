public class eee {
    public static int findMajorityElement(int[] nums) {
        int majorityElement = nums[0];//значением первого элемента массива nums[0]
        int count = 1;

        for (int i = 1; i < nums.length; i++) {//В этом случае majorityElement обновляется значением текущего элемента nums[i].
            //В этом случае majorityElement обновляется значением текущего элемента nums[i]
            if (count == 0) {
                majorityElement = nums[i];
                count = 1;//Значение count также обновляется 1.
            }
            else if (nums[i] == majorityElement) {count++;}//Если текущий элемент nums[i] равен majorityElement, то увеличивается значение count.
            else {count--;}}//Если текущий элемент nums[i] не равен majorityElement, то уменьшается значение count.
        return majorityElement;//В конце прохода по массиву, переменная majorityElement будет содержать значение мажоритарного элемента.
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 3, 4, 2, 1, 2, 2};
        int majorityElement = findMajorityElement(nums);//проход findMajorityElement
        System.out.println(majorityElement);
    }
}
