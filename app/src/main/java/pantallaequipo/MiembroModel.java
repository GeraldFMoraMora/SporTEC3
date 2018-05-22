package pantallaequipo;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class MiembroModel {
    public static final int IMAGE_TYPE = 0;

    public int type;
    public String text;
    public String foto;

    public MiembroModel(int type, String text, String foto) {
        this.type = type;
        this.text = text;
        this.foto = foto;
    }
}
