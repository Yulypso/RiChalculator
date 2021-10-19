public class Complexe implements ObjEmp{

    public Double real;
    public Double imag;

    public Complexe(Double real, Double imag){
        this.real = real;
        this.imag = imag;
    }

    public Complexe(Double imag){
        this.real = 0.0;
        this.imag = imag;
    }

    @Override
    public ObjEmp add(ObjEmp oe) {
        try {
            switch (oe.getClass().getName()) {
                case "Complexe" -> {
                    this.real += ((Complexe) oe).real;
                    this.imag += ((Complexe) oe).imag;
                    return this;
                }
                case "Nombre" -> {
                    this.real += ((Nombre) oe).value;
                    return this;
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {return null;}
    }

    @Override
    public ObjEmp sub(ObjEmp oe) {
        try {
            switch (oe.getClass().getName()) {
                case "Complexe" -> {
                    this.real -= ((Complexe) oe).real;
                    this.imag -= ((Complexe) oe).imag;
                    return this;
                }
                case "Nombre" -> {
                    this.real -= ((Nombre) oe).value;
                    return this;
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {return null;}
    }

    @Override
    public ObjEmp mul(ObjEmp oe) {
        try {
            switch (oe.getClass().getName()) {
                case "Complexe" -> {
                    double tmpReal = this.real * ((Complexe) oe).real;
                    double tmpImag = this.real * ((Complexe) oe).imag;
                    this.real = tmpReal - this.imag * ((Complexe) oe).imag;
                    this.imag = tmpImag + this.imag * ((Complexe) oe).real;
                    return this;
                }
                case "Nombre" -> {
                    this.real *= ((Nombre) oe).value;
                    return this;
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {return null;}
    }

    @Override
    public ObjEmp div(ObjEmp oe) {
        try {
            switch (oe.getClass().getName()) {
                case "Complexe" -> {
                    double realTmp = (this.real * ((Complexe) oe).real + this.imag * ((Complexe) oe).imag) / (((Complexe) oe).real * ((Complexe) oe).real + ((Complexe) oe).imag * ((Complexe) oe).imag);
                    double imagTmp = (this.imag * ((Complexe) oe).real - this.real * ((Complexe) oe).imag) / (((Complexe) oe).real * ((Complexe) oe).real + ((Complexe) oe).imag * ((Complexe) oe).imag);
                    this.real = realTmp;
                    this.imag = imagTmp;
                    return this;
                }
                case "Nombre" -> {
                    this.real *= ((Nombre) oe).value;
                    return this;
                }
                default -> throw new Exception();
            }
        } catch (Exception e) {return null;}
    }

    @Override
    public ObjEmp mod(ObjEmp oe) {
        return null;
    }

    @Override
    public String toString() {
        return "(" + real + " + " + imag + "j)";
    }
}
