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

    public ResultadoModel(int type, String partido, int data, String marcador) {
        this.type = type;
        this.data = data;
        this.mPartido = partido;
        this.mMarcador = marcador;
    }
}
