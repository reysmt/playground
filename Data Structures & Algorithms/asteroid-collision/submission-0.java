class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    stack.pop();          // quello nello stack esplode, si continua
                } else if (top == -asteroid) {
                    stack.pop();          // esplodono entrambi
                    alive = false;
                } else {
                    alive = false;        // il nuovo asteroide esplode
                }
            }

            if (alive) stack.push(asteroid);
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();         // si riempie da destra per rispettare l'ordine
        }
        return res;
    }
}