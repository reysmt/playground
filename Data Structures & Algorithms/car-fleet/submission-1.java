class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        Deque<Double> cars = new ArrayDeque<>();

        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        for(int[] car : pair){
            double time = (target - car[0]) / car[1];

            if(cars.isEmpty() || time > cars.peek()){
                cars.push(time);
            }
        }

        return cars.size();
    }
}
