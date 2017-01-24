package primeministersProject2;

/**
 * 属性リスト：徳川幕府の情報テーブルを入出力する際の属性情報を記憶。
 * 
 * @author kou
 *
 */
public class AttributesForTokugawaShogunate extends Attributes {

	/**
	 * 入力用("input")または出力用("output")で徳川幕府の属性リストを作成するコンストラクタ。
	 * 
	 * @param aString
	 *            入力用("input")または出力用("output")
	 */
	public AttributesForTokugawaShogunate(String aString) {
		super();
		if (aString.compareTo("input") == 0) {
			String[] aCollection = new String[] { "no", "name", "kana", "period", "family", "rank", "image",
					"thumbnail", "former", "cemetery" };

			for (String each : aCollection) {
				this.keys().add(each);
				this.names().add(new String());
			}
		}

		if (aString.compareTo("output") == 0) {
			String[] aCollection = new String[] { "no", "name", "kana", "period", "days", "family", "rank", "image",
					"former", "cemetery" };

			for (String each : aCollection) {
				this.keys().add(each);
				this.names().add(new String());
			}
		}

	}

	@Override
	String captionString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String directoryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String fileStringOfCSV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String fileStringOfHTML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String titleString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String urlString() {
		// TODO Auto-generated method stub
		return null;
	}

}
