package br.com.mobiplus.simplerecylerview.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class TypefaceUtil {

	static Map<String, Typeface> typefaces = new HashMap<>();

	public static void defineTextStyle(Context context, TextView textView, String textStyle) {

		if (context != null) {

			if (textView != null) {
				Typeface typeface = typefaces.get(textStyle);

				if (typeface == null) {
					typeface = Typeface.createFromAsset(context.getAssets(), textStyle);
					typefaces.put(textStyle, typeface);
				}

				textView.setTypeface(typeface);
			}
		}
	}
}
