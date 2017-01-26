package primeministersProject2;

import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public abstract class IO extends java.lang.Object {

	/**
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	protected Table table;

	/**
	 * 入出力のコンストラクタ 良好（2017年1月10日）
	 */
	public IO(Table aTable) {
		super();
		this.table = aTable;
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 
	 * @return 属性リスト
	 */
	public Attributes attributes() {
		return table.attributes();
	}

	/**
	 * ファイルやディレクトリを削除するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aFile
	 *            ファイル名
	 */
	public static void deleteFileOrDirectory(File aFile) {
		if (aFile.exists()) {
			aFile.delete();
		}
	}

	/**
	 * 指定された文字列をHTML内に記述できる正式な文字列に変換して応答する。
	 * 
	 * @param aString
	 * @return
	 */
	public static java.lang.String htmlCanonicalString(java.lang.String aString) {
		return null;
	}

	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aFile
	 *            ファイル
	 * @return aCollection リスト
	 */
	public static List<java.lang.String> readTextFromFile(File aFile) {
		Reader inputStreamReader = null;

		try {
			// IOExceptionがでるかもしれない
			InputStream inputStream = new FileInputStream(aFile);

			// UnsupportedEncodingExceptionがでるかもしれない
			inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> aCollection = IO.readText(inputStreamReader);

		return aCollection;
	}

	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aFileString
	 *            ファイル文字列
	 * @return aCollection リスト
	 */
	public static List<java.lang.String> readTextFromFile(String aFileString) {
		File aFile = new File(aFileString);
		List<String> aCollection = IO.readTextFromFile(aFile);
		return aCollection;
	}

	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param urlString
	 *            URL文字列
	 * @return aCollection リスト
	 */
	public static List<java.lang.String> readTextFromURL(String urlString) {
		URL aURL = null;
		try {
			// MalformedURLException anExceptionがでるかもしれない
			aURL = new URL(urlString);
		} catch (MalformedURLException anException) {
			anException.printStackTrace();
		}
		List<String> aCollection = IO.readTextFromURL(aURL);
		return aCollection;
	}

	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aURL
	 *            URL
	 * @return aCollection リスト
	 */
	public static List<String> readTextFromURL(URL aURL) {
		Reader inputStreamReader = null;
		try {
			// IOExceptionがでるかもしれない
			InputStream inputStream = aURL.openStream();

			// UnsupportedEncodingExceptionがでるかもしれない
			inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> aCollection = IO.readText(inputStreamReader);

		return aCollection;
	}

	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド。
	 * 
	 * @param string
	 *            文字列
	 * @param separators
	 *            セパレータ文字列
	 * @return トークン列
	 */
	public static ArrayList<String> splitString(String string, String separators) {
		ArrayList<Integer> indexes;
		int stop;
		int index;
		ArrayList<String> result;

		indexes = new ArrayList<Integer>();
		indexes.add(-1);
		stop = string.length();
		for (index = 0; index < stop; index++) {
			if ((separators.indexOf(string.charAt(index))) >= 0) {
				indexes.add(index);
			}
		}
		indexes.add(stop);
		stop = indexes.size() - 1;
		result = new ArrayList<String>();
		for (index = 0; index < stop; index++) {
			int start;
			int end;

			start = indexes.get(index) + 1;
			end = indexes.get(index + 1) - 1;
			if (end >= start) {
				result.add(string.substring(start, end + 1));
			}
		}
		return result;
	}

	/**
	 * テーブルを応答する。 良好（2017年1月10日）
	 * 
	 * @return talbe テーブル（表：スプレッドシート）
	 */
	public Table table() {
		return this.table;
	}

	/**
	 * タプル群を応答する。
	 * 
	 * @return タプル群
	 */
	public List<Tuple> tuples() {
		return this.table().tuples();
	}

	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aCollection
	 *            リスト
	 * @param aFile
	 *            ファイル
	 */
	public static void writeText(List<String> aCollection, File aFile) {

		try {
			// FileNotFoundExceptionが出るかもしれない
			OutputStream outputStream = new FileOutputStream(aFile);
			// UnsupportedEncodingExceptionが出るかもしれない
			Writer outputStreamWriter = new OutputStreamWriter(outputStream, IO.encodingSymbol());

			Writer outputWriter = new BufferedWriter(outputStreamWriter);

			String crlf = System.getProperty("line.separator");
			for (String aString : aCollection) {
				// IOExceptionが出るかもしれない
				outputWriter.write(aString);
				outputWriter.write(crlf);
			}
			// IOExceptionが出るかもしれない
			outputWriter.close();
		} catch (IOException anException) {
			anException.printStackTrace();
		}
		return;

	}

	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aCollection
	 *            リスト
	 * @param pathName
	 *            パス名
	 */
	public static void writeText(List<String> aCollection, String pathName) {
		File aFile = new File(pathName);
		IO.writeText(aCollection, aFile);
		return;
	}

	/**
	 * テキストをリストに追加し、そのリストを返すクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param inputStreamReader
	 *            インプットストリームリーダー
	 * @return aCollection リスト
	 */
	private static List<String> readText(Reader inputStreamReader) {
		List<String> aCollection = new ArrayList<String>();
		BufferedReader inputReader = new BufferedReader(inputStreamReader);
		String aString = null;
		try {
			// IOExceptionがでるかもしれない
			while ((aString = inputReader.readLine()) != null) {
				aCollection.add(aString);
			}
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aCollection;
	}

	/**
	 * 入出力する際の文字コードを応答するクラスメソッド。
	 * 
	 * @return 文字コード
	 */
	public static java.lang.String encodingSymbol() {
		return "UTF-8";
	}

}
