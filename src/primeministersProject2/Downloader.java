package primeministersProject2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import primeministers.IO;
import primeministers.Tuple;

/**
 * ダウンローダ：CSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 * 
 * @author kou
 *
 */
public class Downloader extends IO {

	/**
	 * ダウンローダのコンストラクタ。
	 * 
	 * @param aTable
	 *            テーブル
	 */
	public Downloader(Table aTable) {
		super(aTable);
		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードする。
	 */
	public void downloadCSV() {

	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages() {

	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * 
	 * @param indexOfPicture
	 */
	private void downloadPictures(Integer indexOfPicture) {
		try {
			for (Tuple aTuple : this.table().tuples()) {
				URL aURL = null;
				BufferedImage anImage = null;
				String aString = aTuple.values().get(indexOfPicture);

				StringBuffer aBuffer = new StringBuffer();
				aBuffer.append(this.getUrlString());
				aBuffer.append("/");
				aBuffer.append(aString);

				// MalformedURLExceptionが出るかもしれない
				aURL = new URL(aBuffer.toString());

				// IOExceptionが出るかもしれない
				anImage = ImageIO.read(aURL);
				System.out.println(aBuffer.toString());

				// IOExceptionが出るかもしれない
				ImageIO.write(anImage, "jpeg", new File(IO.directoryOfPages(this.getTittleName()), aString));

				if (indexOfPicture == aTuple.attributes().indexOfThumbnail()) {
					this.table.thumbnails().add(anImage);
				} else {
					this.table.images().add(anImage);
				}
			}
		} catch (MalformedURLException anException) {
			anException.printStackTrace();
		} catch (IOException anException) {
			anException.printStackTrace();
		}
		return;
	}

	/**
	 * 総理大臣のサムネイル画像群をダウンロードする。
	 */
	public void downloadThumbnails() {

	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群もダウンロードする。
	 */
	public void perform() {
		this.downloadCSV();
		this.downloadImages();
		this.downloadThumbnails();
	}

}
