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

	/**
	 * 標題文字列を応答する。
	 * 
	 * @return 標題文字列
	 */
	@Override
	public java.lang.String captionString() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 徳川幕府ページのためのディレクトリを文字列で応答する。
	 * 
	 * @return 徳川幕府ページのためのディレクトリ文字列
	 */
	@Override
	public java.lang.String directoryString() {
		return null;
	}

	/**
	 * 徳川幕府の情報を記したCSVファイルを文字列で応答する。
	 * 
	 * @return 徳川幕府の情報を記したCSVファイル文字列
	 */
	@Override
	public java.lang.String fileStringOfCSV() {
		return "TokugawaShogunate.csv";
	}

	/**
	 * 徳川幕府ページのためのローカルなHTMLのインデックスファイル(index.html)を文字列で応答する。
	 * 
	 * @return 徳川幕府ページのためのローカルなHTMLのインデックスファイル文字列
	 */
	@Override
	public java.lang.String fileStringOfHTML() {
		return "TokugawaShogunate.html";
	}

	/**
	 * タイトル文字列を応答する。
	 * @return タイトル文字列
	 */
	@Override
	public java.lang.String titleString() {
		return "Prime Ministers";
	}

	/**
	 * 徳川幕府の情報の在処(URL)を文字列で応答する。
	 * @return 徳川幕府の情報の在処の文字列
	 */
	@Override
	public java.lang.String urlString() {
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/VisualWorks/CSV2HTML/TokugawaShogunate/";
	}

}
