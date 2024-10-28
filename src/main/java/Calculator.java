public class Calculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }else if(numbers.contains(",")){
            String[] nums = numbers.split(",");
            return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
        }
        else {
            return Integer.parseInt(numbers);
        }
    }


}
