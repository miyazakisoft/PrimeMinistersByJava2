package primeministersProject2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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

	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 * 
	 * @param periodString
	 *            在位期間の文字列
	 * @return 在位日数の文字列
	 */
	public String computeNumberOfDays(String periodString) {

		// 数字以外の文字列を得る（空文字列を含む）
		String[] stringArray = periodString.split("[0-9]+", 0);
		Set<String> aSet = new HashSet<String>();

		// 空文字を除去しながらダブりも除く
		for (String aString : stringArray) {
			if (aString.compareTo("") != 0) {
				aSet.add(aString);
			}
		}

		StringBuilder regexBuilder = new StringBuilder();

		// 「年,月,日,日〜」を除くような正規表現を作成
		regexBuilder.append("[");
		for (String aString : aSet) {
			regexBuilder.append(aString);
		}
		regexBuilder.append("]+");

		// 「年,月,日,日〜」以外の文字列を得る
		String[] stringArray2 = periodString.split(regexBuilder.toString(), 0);

		for (String aString : stringArray2) {
			System.out.println(aString);
		}

		Integer yearFrom, monthFrom, dayFrom;
		Integer yearTo, monthTo, dayTo;

		yearFrom = Integer.parseInt(stringArray2[0]);
		monthFrom = Integer.parseInt(stringArray2[1]);
		dayFrom = Integer.parseInt(stringArray2[2]);

		if (stringArray2.length < 4) {
			Calendar aCalendar = Calendar.getInstance();
			yearTo = aCalendar.get(Calendar.YEAR); // 現在の年を取得
			monthTo = aCalendar.get(Calendar.MONTH) + 1; // 現在の月を取得
			dayTo = aCalendar.get(Calendar.DATE) + 1; // 現在の日を取得
		} else {
			yearTo = Integer.parseInt(stringArray2[3]);
			monthTo = Integer.parseInt(stringArray2[4]);
			dayTo = Integer.parseInt(stringArray2[5]);
		}

		LocalDate from = LocalDate.of(yearFrom, monthFrom, dayFrom);
		LocalDate to = LocalDate.of(yearTo, monthTo, dayTo);
		Long diffDays = ChronoUnit.DAYS.between(from, to) + 1;

		String days = String.format("%,d", diffDays);

		return days;
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
		Downloader aDownload = new Downloader(inputTable);
		
		aDownload.perform();
		
		this.inputTable = aDownload.table();


		// CSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換
		this.translate();

		// Table aTable = this.table(this.inputTable);

		// Writer aWriter = new Writer();
		// aWriter.table(aTable);
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
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

			aTranslator.perform();

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
