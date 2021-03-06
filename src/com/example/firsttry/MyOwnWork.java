package com.example.firsttry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyOwnWork extends View {

	Bitmap globe;
	float changingY;
	Typeface font;
	
	public MyOwnWork(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		globe = BitmapFactory.decodeResource(getResources(), R.drawable.globe);
		changingY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "G-Unit.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("RedNation", canvas.getWidth()/2, 200, textPaint);
		
		canvas.drawBitmap(globe, (canvas.getWidth()/2), changingY, null);
		if(changingY < canvas.getHeight()){
			changingY += 10;
		} else {
			changingY = 0;
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}
	
	
}
