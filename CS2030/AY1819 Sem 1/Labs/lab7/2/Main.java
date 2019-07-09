class Main {
	public static void main(String[] args) {
		InfiniteList<Integer> list = InfiniteList.generate(() -> 1);
		for (int i = 0; i < 5; ++i) {
			System.out.println(list.get());
			list = list.next();
		}
	}
}