package pantallaequipo;

/**
 * Created by GeraldMM on 05/05/2018.
 */

public class EquipoModel {
    public static final int IMAGE_TYPE = 0;

    public int type;
    public String text;
    public String sport;
    public String foto;
    public String win;
    public String lost;
    public String tie;

    public EquipoModel(int type, String text, String sport, String foto, String win, String lost, String tie) {
        this.type = type;
        this.text = text;
        this.sport = sport;
        this.foto = foto;
        this.win = win;
        this.lost = lost;
        this.tie = tie;
    }
}
