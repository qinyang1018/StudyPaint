package testview.com.paintteat;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 当前类注释：随手指滑动绘制
 * 项目名：PaintTeat
 * 包名： testview.com.paintteat
 * Created by QYang on 2016/4/22.
 */
public class PaintView extends View {
    private Paint mPaint;//画圆画笔
    private Paint mFillPaint;//填充画笔
    private BitmapShader mBitmapShader;// Bitmap着色器
    private float posX, posY;//手指移动的X,Y坐标

    public PaintView(Context context) {
        super(context);

    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaint.setColor(0xFF000000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        mFillPaint = new Paint();
        /*
         * 生成BitmapShader
         */
//        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        mFillPaint.setShader(mBitmapShader);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            posX = event.getX();
            posY = event.getY();

            invalidate();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制
        canvas.drawCircle(posX, posY, 200, mPaint);
        canvas.drawCircle(posX, posY, 200, mFillPaint);
    }
}
