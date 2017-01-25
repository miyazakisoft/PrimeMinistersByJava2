package primeministersProject2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Table {

	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * タプル群を記憶するフィールド。
	 */
	private java.util.List<Tuple> tuples;

	/**
	 * 画像群を記憶するフィールド。
	 */
	private java.util.List<BufferedImage> images;

	/**
	 * サムネイル画像群を記憶するフィールド。
	 */
	private java.util.List<BufferedImage> thumbnails;

	/**
	 * テーブルのコンストラクタ。
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 */
	public Table(Attributes instanceOfAttributes) {
		this.images = new ArrayList<BufferedImage>();
		this.thumbnails = new ArrayList<BufferedImage>();
		this.tuples = new ArrayList<Tuple>();
		return;
	}

	/**
	 * タプルを追加する。
	 * 
	 * @param aTuple
	 */
	public void add(Tuple aTuple) {
		this.tuples.add(aTuple);
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
	 * 属性リストを設定する。
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 */
	public void attributes(Attributes instanceOfAttributes) {
		this.attributes = instanceOfAttributes;
	}

	/**
	 * 画像群を応答する。
	 * 
	 * @return 画像群
	 */
	public java.util.List<BufferedImage> images() {
		return this.images;
	}

	/**
	 * 画像またはサムネイル画像の文字列を受けとって当該画像を応答する。
	 * 
	 * @param aString
	 *            画像またはサムネイル画像の文字列
	 * @return 画像
	 */
	private BufferedImage picture(java.lang.String aString) {
		return null;
	}

	/**
	 * サムネイル画像群を応答する。
	 * 
	 * @return サムネイル画像群
	 */
	public java.util.List<BufferedImage> thumbnails() {
		return this.thumbnails;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。 return 自分自身の文字列
	 */
	@Override
	public java.lang.String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Table> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		return aBuffer.toString();
	}

	/**
	 * タプル群を応答する。
	 * 
	 * @return タプル群
	 */
	public java.util.List<Tuple> tuples() {
		return this.tuples;
	}

}
