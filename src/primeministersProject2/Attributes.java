package primeministersProject2;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性リスト：情報テーブルを入出力する際の属性情報を記憶。
 * 
 * @author kou
 *
 */
public abstract class Attributes extends java.lang.Object {

	/**
	 * 属性リストのキー群を記憶する（インスタンス変数）フィールド。
	 */
	private List<java.lang.String> keys;

	/**
	 * 属性リストの名前群を記憶する（インスタンス変数）フィールド。
	 */
	private List<java.lang.String> names;

	/**
	 * タイムスタンプを記憶する（クラス変数）フィールド。
	 */
	private static java.lang.String timestamp;

	/**
	 * 属性リストを作成するコンストラクタ。
	 */
	public Attributes() {
		super();
		keys = new ArrayList<String>();
		names = new ArrayList<String>();
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	 * 
	 * @param index
	 *            インデックス
	 * @return 名前（キー）
	 */
	protected java.lang.String at(java.lang.Integer index) {
		java.lang.String aString = names.get(index);

		if (aString.compareTo("") != 0) {
			return keys.get(index);
		}
		return aString;
	}

	/**
	 * 標題文字列を応答する。
	 * 
	 * @return 標題文字列
	 */
	abstract java.lang.String captionString();

	/**
	 * ページのためのディレクトリ（存在しなければ作成して）を応答する。
	 * 
	 * @return ページのためのディレクトリ
	 */
	public java.io.File directoryOfPages() {

		return null;
	}

	/**
	 * ページのためのディレクトリを文字列で応答する。
	 * 
	 * @return ページのためのディレクトリ文字列
	 */
	abstract java.lang.String directoryString();

	/**
	 * 情報を記したローカルなCSVファイルを応答する。
	 * 
	 * @return 情報を記したローカルなCSVファイル
	 */
	public java.io.File fileOfCSV() {
		return null;
	}

	/**
	 * ページのためのローカルなHTMLのインデックスファイル(index.html)を応答する。
	 * 
	 * @return ページのためのローカルなHTMLのインデックスファイル
	 */
	public java.io.File fileOfHTML() {
		return null;
	}

	/**
	 * 情報を記したCSVファイルを文字列で応答する。
	 * 
	 * @return 情報を記したCSVファイル文字列
	 */
	abstract java.lang.String fileStringOfCSV();

	/**
	 * ページのためのローカルなHTMLのインデックスファイル(index.html)を文字列で応答する。
	 * 
	 * @return ページのためのローカルなHTMLのインデックスファイル文字列
	 */
	abstract java.lang.String fileStringOfHTML();

	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * 
	 * @param aString
	 *            キー
	 * @return インデックス
	 */
	protected java.lang.Integer indexOf(java.lang.String aString) {
		return this.keys.indexOf(aString);
	}

	/**
	 * 在位日数のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfDays() {
		return this.indexOf("days");
	}

	/**
	 * 画像のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfImage() {
		return this.indexOf("image");
	}

	/**
	 * ふりがなのインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfKana() {
		return this.indexOf("kana");
	}

	/**
	 * 氏名のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfName() {
		return this.indexOf("name");
	}

	/**
	 * 番号のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfNo() {
		return this.indexOf("no");
	}

	/**
	 * 在位期間のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfPeriod() {
		return this.indexOf("period");
	}

	/**
	 * 縮小画像のインデックスを応答する。
	 * 
	 * @return インデックス
	 */
	public java.lang.Integer indexOfThumbnail() {
		return this.indexOf("thumbnail");
	}

	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 * 
	 * @param index
	 *            インデックス
	 * @return キー
	 */
	protected java.lang.String keyAt(java.lang.Integer index) {
		return this.keys.get(index);
	}

	/**
	 * キー群を応答する。
	 * 
	 * @return キー群
	 */
	public java.util.List<java.lang.String> keys() {
		return this.keys;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * 
	 * @param index
	 *            インデックス
	 * @return 名前
	 */
	protected java.lang.String nameAt(java.lang.Integer index) {
		return this.names.get(index);
	}

	/**
	 * 名前群を応答する。
	 * 
	 * @return 名前群
	 */
	public java.util.List<java.lang.String> names() {
		return this.names;
	}

	/**
	 * 名前群を設定する。
	 * 
	 * @param aCollection
	 *            名前群
	 */
	public void names(java.util.List<java.lang.String> aCollection) {
		this.names = aCollection;
	}

	/**
	 * 属性リストの長さを応答する。
	 * 
	 * @return 属性リストの長さ
	 */
	public java.lang.Integer size() {
		return this.keys.size();
	}

	/**
	 * タイムスタンプを応答する。
	 * 
	 * @return タイムスタンプ
	 */
	public static java.lang.String timestamp() {
		return timestamp;
	}

	/**
	 * タイトル文字列を応答する。
	 * 
	 * @return タイトル文字列
	 */
	abstract java.lang.String titleString();

	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 
	 * @return 自分自身の文字列
	 */
	@Override
	public java.lang.String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Attributes> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[keys=");
		aBuffer.append(keys);
		aBuffer.append(",names=");
		aBuffer.append(names);
		aBuffer.append("]");
		return aBuffer.toString();
	}

	/**
	 * 情報の在処(URL)を文字列で応答する。
	 * 
	 * @return 情報の在処の文字列
	 */
	abstract java.lang.String urlString();

	/**
	 * 情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 * 
	 * @return 情報を記したCSVファイル文字列
	 */
	public java.lang.String urlStringOfCSV() {
		return new StringBuilder().append(this.urlString()).append(this.fileStringOfCSV()).toString();
	}

}
