package primeministersProject2;

/**
 * 属性リスト：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 * 
 * @author kou
 *
 */
public class AttributesForPrimeMinisters extends Attributes {

	/**
	 * 入力用("input")または出力用("output")で総理大臣の属性リストを作成するコンストラクタ。
	 * 
	 * @param aString
	 *            入力用("input")または出力用("output")
	 */
	public AttributesForPrimeMinisters(String aString) {
		super();
		
		if (aString.compareTo("input") == 0) {
			String[] aCollection = new String[] { "no", "order", "name", "kana", "period", "school", "party", "place",
					"image", "thumbnail" };

			for (String each : aCollection) {
				this.keys().add(each);
				this.names().add(new String());
			}
		}

		if (aString.compareTo("output") == 0) {
			String[] aCollection = new String[] { "no", "order", "name", "kana", "period", "days", "school", "party",
					"place", "image" };

			for (String each : aCollection) {
				this.keys().add(each);
				this.names().add(new String());
			}
		}

	}

	@Override
	public java.lang.String captionString() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public java.lang.String titleString() {
		return "Prime Ministers";
	}

	@Override
	String baseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String csvUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
