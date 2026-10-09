package br.com.componentes;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import br.com.componentes.extras.SizeText;

public class ProgressIndeterminate {

    private Dialog dialog;
    private Context context;
    private TextView messageTextView;
    private ConstraintLayout constraintLayout;
    private GeometricProgressView progressBarUi;
    private int background = 0;
    private boolean multColor = false;
    private int multColorIndex;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final int[] multicolorPalette = {
            Color.RED,
            Color.MAGENTA,
            Color.GREEN,
            Color.BLUE
    };
    private final Runnable multicolorRunnable = new Runnable() {
        @Override
        public void run() {
            if (!multColor || !dialog.isShowing() || progressBarUi == null) {
                return;
            }

            progressBarUi.setColor(multicolorPalette[multColorIndex]);
            multColorIndex = (multColorIndex + 1) % multicolorPalette.length;
            mainHandler.postDelayed(this, 1000);
        }
    };

    public ProgressIndeterminate(Context context) {
        this.context = context;
        dialog = new Dialog(context);
        dialog.setOnDismissListener(ignored -> stopMulticolorAnimation());
    }

    public ProgressIndeterminate create(String message) {

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.view_custon_progress_dialog);

        dialog.getWindow().getAttributes().windowAnimations = R.style.scale_fade_in_out;
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.rectangle_back);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);

        int width = 700; // DEFAULT
        if (displayMetrics != null) {
            width = displayMetrics.widthPixels;
        }

        dialog.getWindow().setLayout(width - 100, 300);

        constraintLayout = dialog.findViewById(R.id.rl);
        constraintLayout.setBackgroundColor(context.getResources().getColor(R.color.colorSurface));

        progressBarUi = dialog.findViewById(R.id.progressBarUi);

        messageTextView = dialog.findViewById(R.id.msg);
        messageTextView.setTextSize((float) context.getResources().getInteger(R.integer.medium_text)); // TEXTSIZE DEFAULT
        messageTextView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
        messageTextView.setText(message);

        return this;
    }

    public ProgressIndeterminate setBackgroundColor(int color) {
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(context.getResources().getColor(color));
        }
        return this;
    }

    public ProgressIndeterminate setTextSize(SizeText sizeText) {
        messageTextView = dialog.findViewById(R.id.msg);
        switch (sizeText) {
            case SMALL:
                messageTextView.setTextSize((float) context.getResources().getInteger(R.integer.small_text));
                break;

            case MEDIUM:
                messageTextView.setTextSize((float) context.getResources().getInteger(R.integer.medium_text));
                break;

            case LARGE:
                messageTextView.setTextSize((float) context.getResources().getInteger(R.integer.large_text));
                break;

            case XLARGE:
                messageTextView.setTextSize((float) context.getResources().getInteger(R.integer.extra_large_text));
                break;
        }
        return this;
    }

    public ProgressIndeterminate cancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return this;
    }

    public boolean isShowing(){
       return dialog.isShowing();
    }

    public void setMessage(String message){
        messageTextView.setText(message);
    }

    public ProgressIndeterminate multColor(boolean multColor){
        this.multColor = multColor;
        if (multColor && dialog.isShowing()) {
            startMulticolorAnimation();
        } else if (!multColor) {
            stopMulticolorAnimation();
        }
        return this;
    }

    public ProgressIndeterminate show() {
        dialog.show();
        startMulticolorAnimation();
        return this;
    }

    private void startMulticolorAnimation() {
        stopMulticolorAnimation();
        if (multColor && dialog.isShowing() && progressBarUi != null) {
            multColorIndex = 0;
            mainHandler.post(multicolorRunnable);
        }
    }

    private void stopMulticolorAnimation() {
        mainHandler.removeCallbacks(multicolorRunnable);
    }

    public static ProgressIndeterminate show(Context context, String mesagem){
        return new ProgressIndeterminate(context).create(mesagem).show();
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
