package br.com.fiap.beans;

public class Chamado
{
    private int id;
    private double cordX, cordY;
    private String status, data;

    public Chamado(){super();}

    public Chamado(double cordX, double cordY)
    {
        this.cordX = cordX;
        this.cordY = cordY;
        this.status = "Solicitação em aberto";
    }

    public double getCordX() {
        return cordX;
    }

    public void setCordX(double cordX) {
        this.cordX = cordX;
    }

    public double getCordY() {
        return cordY;
    }

    public void setCordY(double cordY) {
        this.cordY = cordY;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "id=" + id +
                ", cordX=" + cordX +
                ", cordY=" + cordY +
                ", status='" + status + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}

