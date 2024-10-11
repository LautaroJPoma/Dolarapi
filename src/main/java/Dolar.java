public class Dolar {

    private double venta;
    private double compra;
    private String moneda;
    private String nombre;
    private String fechaAct;

    public Dolar(double venta, double compra, String moneda, String nombre, String fechaAct) {
        this.venta = venta;
        this.compra = compra;
        this.moneda = moneda;
        this.nombre = nombre;
        this.fechaAct = fechaAct;
    }


    public double getVenta() {
        return venta;
    }
    public void setValor(double venta) {
        this.venta = venta;
    }
    public double getCompra() {
        return compra;
    }
    public void setCompra(double compra) {
        this.compra = compra;
    }
    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaAct() {
        return fechaAct;
    }
    public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }
    

    
}