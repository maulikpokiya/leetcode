class MovingAverage {

    private int size;
    private Deque<Integer> deque;
    private int runningSum;

    public MovingAverage(int size) {
        this.size = size;
        this.deque = new ArrayDeque<>();
        this.runningSum = 0;
    }
    
    public double next(int val) {
        if(deque.size() == size) {
            int last = deque.removeFirst();
            runningSum -= last;
        }
        deque.add(val);
        runningSum += val;
        return (double) runningSum/deque.size();
    }
}
