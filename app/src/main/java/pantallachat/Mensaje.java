package pantallachat;

import android.graphics.Bitmap;

/**
 * Created by geraldportatil on 03/06/18.
 */

public class Mensaje implements XhatConstants {

    private int mType;
    public String mMessage;
    private Bitmap mImage;

    public Mensaje() {
    }

    public int getType() {
        return mType;
    }

    ;

    public String getMessage() {
        return mMessage;
    }

    ;

    public Bitmap getImage() {
        return mImage;
    }

    ;


    public static class Builder {
        private final int mType;
        private Bitmap mImage;
        private String mMessage;

        public Builder(int type) {
            mType = type;
        }

        public Builder image(Bitmap image) {
            mImage = image;
            return this;
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }

        public Mensaje build() {
            Mensaje mensaje = new Mensaje();
            mensaje.mType = mType;
            mensaje.mImage = mImage;
            mensaje.mMessage = mMessage;
            return mensaje;
        }
    }
}
