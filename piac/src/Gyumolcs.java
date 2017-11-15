public class Gyumolcs {
    private int ar;
    private String szin;
    private String fajta;

    public Gyumolcs(int ar, String szin, String fajta) {
        this.ar = ar;
        this.fajta = fajta;
        if (szin.equals("zöld") || szin.equals("sarga") || szin.equals("piros")){
            this.szin = szin;
        } else {
            this.szin = "zöld";
        }
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public String getFajta() {
        return fajta;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    @Override
    public String toString() {
        return "Gyumolcs{" +
                "ar=" + ar +
                ", szin='" + szin + '\'' +
                ", fajta='" + fajta + '\'' +
                '}';
    }
}
