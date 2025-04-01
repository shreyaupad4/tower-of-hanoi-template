public class TowerSolver {
    private TowerModel model;

    // Constructors
    public TowerSolver() {
        // No initialization needed here; model will be set later.
    }

    public TowerSolver(TowerModel model) {
        this.model = model;
    }

    // Public solve method that sets the model if provided
    public void solve(TowerModel model) {
        this.model = model;
        solveHanoi(model.getHeight(), 0, 2, 1); // Start solving with 3 towers: 0 (source), 2 (destination), 1 (auxiliary)
    }

    // Recursive method to solve Tower of Hanoi
    private void solveHanoi(int numDisks, int source, int destination, int auxiliary) {
        if (numDisks == 0) return; // Base case: no disks to move

        // Move (n-1) disks from source to auxiliary using destination as buffer
        solveHanoi(numDisks - 1, source, auxiliary, destination);

        // Move the nth disk directly from source to destination
        moveDisk(source, destination);

        // Move (n-1) disks from auxiliary to destination using source as buffer
        solveHanoi(numDisks - 1, auxiliary, destination, source);
    }

    // Moves a disk and updates the model
    private void moveDisk(int source, int destination) {
        System.out.println("Move from tower " + source + " to tower " + destination);
        model.move(source, destination);
    }

    // Setter method for model
    public void setModel(TowerModel model) {
        this.model = model;
    }
}
