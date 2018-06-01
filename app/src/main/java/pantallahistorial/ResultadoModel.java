package pantallahistorial;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class ResultadoModel {
    public static final int IMAGE_TYPE = 0;

    public int type;
    public int data;
    public String mPartido;
    public String mMarcador;
    public String mFoto1;
    public String mFoto2;

    public ResultadoModel(int type, String partido, int data, String marcador, String foto1, String foto2) {
        this.type = type;
        this.data = data;
        this.mPartido = partido;
        this.mMarcador = marcador;
        this.mFoto1 = foto1;
        this.mFoto2 = foto2;
    }
}
