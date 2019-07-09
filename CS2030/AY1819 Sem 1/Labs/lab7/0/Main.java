class Main {
	public static void main(String[] args) {
		// InfiniteList<Integer> list = InfiniteList.generate(() -> 1).limit(5);
		InfiniteList<Integer> list = InfiniteList
			.iterate(1, i -> i + 1)
			//.generate(() -> 1)
			.limit(5);
		list.forEach(System.out::println);
		// while (list != null) {
		// 	System.out.println(list.get());
		// 	list = list.next();
		// }
	}
}