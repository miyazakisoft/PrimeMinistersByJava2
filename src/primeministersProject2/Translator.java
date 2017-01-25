package primeministersProject2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * トランスレータ：CSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends java.lang.Object {

	/**
	 * CSVに由来するテーブルを記憶するフィールド。
	 */
	private Table inputTable;

	/**
	 * HTMLに由来するテーブルを記憶するフィールド。
	 */
	private Table outputTable;

	/**
	 * 属性リストのクラスを指定したトランスレータのコンストラクタ。
	 * 
	 * @param classOfAttributes
	 *            属性リストのクラス
	 */
	Translator(Class<? extends Attributes> classOfAttributes) {
		super();

		try {
			Constructor<? extends Attributes> aConstructor = classOfAttributes.getConstructor(String.class);

			try {
				this.inputTable = new Table(aConstructor.newInstance("input"));
				this.outputTable = new Table(aConstructor.newInstance("output"));

			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException anException) {
				anException.printStackTrace();
			}

		} catch (NoSuchMethodException anException) {
			anException.printStackTrace();
		}

	}

	public String computeNumberOfDays(String periodString) {

		// 数字以外の文字列を得る（空文字列を含む）
		String[] stringArray = periodString.split("[0-9]+", 0);
		Set<String> aSet = new HashSet<String>();

		// 空文字を除去しながらダブりも除く
		for (String aString : stringArray) {
			System.out.println(aString);
		}

		return null;
	}

	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 * 
	 * @param aString
	 *            画像の文字列
	 * @param aTuple
	 *            タプル
	 * @param no
	 *            番号
	 * @return サムネイル画像から画像へ飛ぶためのHTML文字列
	 */
	public java.lang.String computeStringOfImage(java.lang.String aString, Tuple aTuple, java.lang.Integer no) {
		List<String> values = aTuple.values();

		String aNo = values.get(aTuple.attributes().indexOfNo());
		String aImage = values.get(aTuple.attributes().indexOfImage());
		String aThumbnail = values.get(aTuple.attributes().indexOfThumbnail());

		String imageTag = "<a name=" + aNo + " href=" + aImage + "><img class=\"borderless\" src=" + aThumbnail
				+ " width=\"25\" height=\"32\" alt=" + aNo + ".jpg></a>";

		return imageTag;
	}

	/**
	 * CSVに由来するテーブルの属性リストを応答する。
	 * 
	 * @return CSVに由来するテーブルの属性リスト
	 */
	public Attributes inputAttributes() {
		return this.inputTable().attributes();
	}

	/**
	 * CSVに由来するテーブルを応答する。
	 * 
	 * @return CSVに由来するテーブル
	 */
	public Table inputTable() {
		return this.inputTable();
	}

	/**
	 * HTMLに由来するテーブルの属性リストを応答する。
	 * 
	 * @return HTMLに由来するテーブルの属性リスト
	 */
	public Attributes outputAttributes() {
		return this.outputTable().attributes();
	}

	/**
	 * HTMLに由来するテーブルを応答する。
	 * 
	 * @return HTMLに由来するテーブル
	 */
	public Table outputTable() {
		return this.outputTable;
	}

	/**
	 * CSVファイルをHTMLページへ変換する。
	 */
	public void perform() {
	}

	/**
	 * 属性リストのクラスを受け取って、CSVファイルをHTMLページへと変換するクラスメソッド。
	 * 
	 * @param classOfAttributes
	 *            属性リストのクラス
	 */
	public static void perform(java.lang.Class<? extends Attributes> classOfAttributes) {
		// [参考URL]http://qiita.com/manahirosan/items/32da2cc9f5f03dc454ca

		Class<? extends Translator> classes = Translator.class;

		try {
			// NoSuchMethodExceptionまたはSecurityExceptionが出るかもしれない
			Constructor<? extends Translator> aConstructor = classes.getDeclaredConstructor(java.lang.Class.class);

			// InstantiationException、IllegalAccessException、
			// IllegalArgumentException、InvocationTargetExceptionが出るかもしれない
			Translator aTranslator = aConstructor.newInstance(classOfAttributes);

			// CSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換
			aTranslator.translate();

			// 日付のテスト
			aTranslator.computeNumberOfDays("1745年11月2日〜1760年5月13日");

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException anException) {
			anException.printStackTrace();
		}
	}

	/**
	 * CSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換する。
	 */
	public void translate() {

	}

}
