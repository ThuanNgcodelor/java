package a23127_ass5;

public class XeOTo {

    private String tenXe;
    private String hangsx;
    private int namsx;

    public XeOTo(String tenXe, String hangsx, int namsx) {
        this.tenXe = tenXe;
        this.hangsx = hangsx;
        this.namsx = namsx;
    }

    public XeOTo() {
        this.tenXe = null;
        this.hangsx = null;
        this.namsx = 0;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getHangsx() {
        return hangsx;
    }

    public void setHangsx(String hangsx) {
        this.hangsx = hangsx;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }
}
