package com.example.checkers_gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CheckerView extends View {

    private final Paint boardPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint piece_black = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint piece_red = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CheckerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        piece_black.setColor(getResources().getColor(R.color.checker_black_piece));
        piece_red.setColor(getResources().getColor(R.color.checker_red_piece));

    }

    @Override
    public void draw(final Canvas c) {
        super.draw(c);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((x + y) % 2 == 0) boardPaint.setColor(getResources().getColor(R.color.checker_black));
                else boardPaint.setColor(getResources().getColor(R.color.checker_red));
                c.drawRect((x*150)+150,(y*150)+150,(x*150)+300,(y*150)+300, boardPaint);
            }
        }

        //black pieces
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                if (y % 2 != 0) c.drawCircle((x*300)+375, (y*150)+225, 60, piece_black);
                else c.drawCircle((x*300)+225, (y*150)+225, 60, piece_black);
            }
        }

        //red pieces
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                if (y % 2 != 0) c.drawCircle((x*300)+225, (y*150)+975, 60, piece_red);
                else c.drawCircle((x*300)+375, (y*150)+975, 60, piece_red);
            }
        }
    }

}
