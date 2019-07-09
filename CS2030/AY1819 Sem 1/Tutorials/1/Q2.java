class Q2 {
	public static void main(String[] args) {
		Q.P p = new Q.P();
		//P p = new P();
		Q q = new Q();
		q.changeOther(p);
	}
}

class P {
	private int x;
}

class Q {

	public static class P {
		private int x;
	}

	public void changeOther(P p) {
		p.x = 1;
	}
}