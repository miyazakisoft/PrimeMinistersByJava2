package primeministersProject2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * ダウンローダ：CSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 * 
 * @version 1.0
 * @author 宮崎光
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
		Attributes anAttributes = this.attributes();

		List<String> aCollection = IO.readTextFromURL(anAttributes.csvUrl());
		File aFile = new File(anAttributes.baseDirectory(), "TokugawaShogunate.csv");
		IO.writeText(aCollection, aFile);
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages() {

		attributes().baseDirectory("images");

		Integer index = this.attributes().indexOfImage();
		this.downloadPictures(index);
	}

	/**
	 * 総理大臣のサムネイル画像群をダウンロードする。
	 */
	public void downloadThumbnails() {

		attributes().baseDirectory("thumbnails");

		Integer index = this.attributes().indexOfThumbnail();
		this.downloadPictures(index);
	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 * 
	 * @param indexOfPicture
	 */
	private void downloadPictures(Integer indexOfPicture) {
		try {
			for (Tuple aTuple : this.tuples()) {
				URL aURL = null;
				BufferedImage anImage = null;
				String aString = aTuple.values().get(indexOfPicture);

				// MalformedURLExceptionが出るかもしれない
				aURL = new URL(this.attributes().baseDirectory());
				System.out.println(this.attributes().baseDirectory());

				// IOExceptionが出るかもしれない
				anImage = ImageIO.read(aURL);

				// IOExceptionが出るかもしれない
				// ImageIO.write(anImage, "jpeg", new
				// File(IO.directoryOfPages(this.getTittleName()), aString));

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
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群もダウンロードする。
	 */
	public void perform() {
		this.downloadCSV();
		// this.downloadImages();
		// this.downloadThumbnails();
	}

}
