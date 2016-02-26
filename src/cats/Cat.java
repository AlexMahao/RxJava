package cats;

public class Cat implements Comparable<Cat> {

	/**
	 * 图片
	 */
	String image;

	/**
	 * 喜爱度
	 */
	int cuteness;

	@Override
	public int compareTo(Cat another) {
		return Integer.compare(cuteness, another.cuteness);
	}

}
