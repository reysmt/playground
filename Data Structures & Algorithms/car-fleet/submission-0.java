class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2]; //[position,speed]
        Stack<Double> cars = new Stack<>(); 

        for(int i = 0; i < position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];            
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        for(int[] car : pair){
            cars.push((double) (target - car[0])  / car[1]);

            if(cars.size() >= 2 &&
               cars.peek() <= cars.get(cars.size() - 2)) 
            {
                cars.pop();
            }
        }
        return cars.size();
    }
}
