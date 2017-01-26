package primeministersProject2;

/**
 * タプル：情報テーブルの中の各々のレコード。
 * 
 * @version 1.0
 * @author 宮崎光
 *
 */
public class Tuple extends java.lang.Object {

	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * 値リストを記憶するフィールド。
	 */
	private java.util.List<java.lang.String> values;

	/**
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 * @param valueCollection
	 *            値リスト
	 */
	Tuple(Attributes instanceOfAttributes, java.util.List<java.lang.String> valueCollection) {
		this.attributes = instanceOfAttributes;
		this.values = valueCollection;
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 
	 * @return 属性リスト
	 */
	public Attributes attributes() {
		return this.attributes;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 
	 * @return 自分自身の文字列
	 */
	@Override
	public java.lang.String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Tuple> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		return aBuffer.toString();
	}

	/**
	 * 値リストを応答する。
	 * 
	 * @return 値リスト
	 */
	public java.util.List<java.lang.String> values() {
		return this.values;
	}

}
