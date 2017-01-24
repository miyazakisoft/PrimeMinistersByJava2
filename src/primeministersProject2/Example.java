package primeministersProject2;

import java.util.ArrayList;
import java.util.List;

public class Example extends Object {

	public static void main(String[] arguments) {
		// 総理大臣と徳川幕府の属性リストのクラス群を作る。

		List<Class<? extends Attributes>> classes = new ArrayList<Class<? extends Attributes>>();
		classes.add(AttributesForPrimeMinisters.class);
		classes.add(AttributesForTokugawaShogunate.class);

		for (Class<? extends Attributes> classOfAttributes : classes) {
			//Translator.perform(classOfAttributes);
		}

		return;
	}
}
