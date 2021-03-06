package com.wedeploy.tutorial_auth_android.binding;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Silvio Santos
 */
public class Font {

	public static final String ICONS_12 = "icons-12px.ttf";

	public static final String ICONS_16 = "icons-16px.ttf";

	public static Typeface getFont(Context context, String name) {
		AssetManager manager = context.getAssets();
		name = "fonts/" + name;

		return Typeface.createFromAsset(manager, name);
	}

	public static void setFont(TextView textView, String name) {
		if (textView.isInEditMode()) {
			return;
		}

		Typeface font = _fonts.get(name);

		if (font == null) {
			Context context = textView.getContext();
			font = getFont(context, name);

			_fonts.put(name, font);
		}

		textView.setTypeface(font);
	}

	private static final Map<String, Typeface> _fonts = new HashMap<>();
}