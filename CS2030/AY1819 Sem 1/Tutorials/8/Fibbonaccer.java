import java.util.concurrent.RecursiveTask;

class Fibbonaccer extends RecursiveTask<Integer> {
	int n;
	public Fibbonaccer(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {
		if (n <= 1) {
			return n;
		} else {
			Fibbonaccer f1 = new Fibbonaccer(this.n - 1);
			Fibbonaccer f2 = new Fibbonaccer(this.n - 2);
			f1.fork();
			return f2.compute() + f1.join();
		}
	}
}