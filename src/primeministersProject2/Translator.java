package primeministersProject2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * トランスレータ：CSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends Object {

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
					| InvocationTargetException e) {
				e.printStackTrace();
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

		}

		return null;
	}

}
