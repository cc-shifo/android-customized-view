package com.example.overrideondraw.wedgit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 17-12-15.
 */

public class CircleView extends View {
    private static final String TAG = "CircleView";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.RED;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        init();
    }

    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        int width = getWidth();  // android:layout_width="match_parent"
//        int height = getHeight();// android:layout_height="200dp"
//        int radius = Math.min(width, height)/2;
//        canvas.drawCircle(width/2, height/2, radius, mPaint);

        // 考虑xml文件中添加padding属性后的计算方式
        int pdl = getPaddingLeft();
        int pdr = getPaddingRight();
        int pdt = getPaddingTop();
        int pdb = getPaddingBottom();
        int width = getWidth() - pdl - pdr;
        int height = getHeight() - pdt -pdb;
        int radius = Math.min(width, height)/2;
        canvas.drawCircle(pdl + width/2, pdt + height/2, radius, mPaint);
    }

    // 重写onMeasure()函数目的：处理xml文件中wrap_content属性。否则wrap_content表现出match_parent的效果
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        // 对于wrap_content的情况，我们指定一个默认大小
        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, 400);
        } else if (wSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(400, hSpecSize);
        } else if (hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize, 400);
        }
        // width和height都不是wrap_content的情况时，使用传入参数作为大小。
    }
}
